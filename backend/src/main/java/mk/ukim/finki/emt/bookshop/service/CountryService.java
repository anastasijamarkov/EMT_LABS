package mk.ukim.finki.emt.bookshop.service;

import mk.ukim.finki.emt.bookshop.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> save(String name, String continent);

    void deleteById(Long id);
}
