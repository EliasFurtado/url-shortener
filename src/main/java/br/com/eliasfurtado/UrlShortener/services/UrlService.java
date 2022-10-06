package br.com.eliasfurtado.UrlShortener.services;

import br.com.eliasfurtado.UrlShortener.dto.UrlLongRequest;
import br.com.eliasfurtado.UrlShortener.entity.Url;
import br.com.eliasfurtado.UrlShortener.repositories.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UrlService {

    private final UrlRepository urlRepository;
    private final BaseConversion baseConversion;

    public UrlService(UrlRepository urlRepository, BaseConversion conversion) {
        this.urlRepository = urlRepository;
        this.baseConversion = conversion;
    }

    public String convertToShortUrl(UrlLongRequest request) {
        Url url = new Url();
        url.setLongUrl(request.getLongUrl());
        url.setCreatedAt(new Date());

        Url entity = urlRepository.save(url);

        return baseConversion.encode(entity.getId());
    }
}
