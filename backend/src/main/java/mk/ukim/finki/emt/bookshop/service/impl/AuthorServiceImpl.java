package mk.ukim.finki.emt.bookshop.service.impl;

import mk.ukim.finki.emt.bookshop.model.Author;
import mk.ukim.finki.emt.bookshop.model.Country;
import mk.ukim.finki.emt.bookshop.model.exceptions.CountryWithIdNotFound;
import mk.ukim.finki.emt.bookshop.repository.AuthorRepository;
import mk.ukim.finki.emt.bookshop.repository.CountryRepository;
import mk.ukim.finki.emt.bookshop.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> save(String name, String surname, Long countryId) {
        Country country=this.countryRepository.findById(countryId).orElseThrow(() -> new CountryWithIdNotFound(countryId));
        Author author=new Author(name,surname,country);
        return Optional.of(this.authorRepository.save(author));
    }


    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }
}
