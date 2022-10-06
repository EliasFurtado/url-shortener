package br.com.eliasfurtado.UrlShortener.repositories;

import br.com.eliasfurtado.UrlShortener.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
}
