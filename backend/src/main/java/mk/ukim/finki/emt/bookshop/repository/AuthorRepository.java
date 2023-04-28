package mk.ukim.finki.emt.bookshop.repository;

import mk.ukim.finki.emt.bookshop.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
