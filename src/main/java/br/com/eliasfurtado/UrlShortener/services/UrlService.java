package br.com.eliasfurtado.UrlShortener.services;

import br.com.eliasfurtado.UrlShortener.dto.UrlLongRequest;
import br.com.eliasfurtado.UrlShortener.entity.Url;
import br.com.eliasfurtado.UrlShortener.repositories.UrlRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

@Service
public class UrlService {

    private final UrlRepository urlRepository;
    private final BaseConversion conversion;

    public UrlService(UrlRepository urlRepository, BaseConversion baseConversion) {
        this.urlRepository = urlRepository;
        this.conversion = baseConversion;
    }

    public String convertToShortUrl(UrlLongRequest request) {
        Url url = new Url();
        url.setLongUrl(request.getLongUrl());
        url.setCreatedAt(new Date());

        Url entity = urlRepository.save(url);

        return conversion.encode(entity.getId());
    }

    public String getOriginalUrl(String shorUrl) {
        long id = conversion.decode(shorUrl);

        var entity = urlRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no entity with " + id));

        return entity.getLongUrl();

    }
}
