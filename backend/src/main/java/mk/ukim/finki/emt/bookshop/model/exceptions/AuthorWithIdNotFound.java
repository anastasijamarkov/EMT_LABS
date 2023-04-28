package mk.ukim.finki.emt.bookshop.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AuthorWithIdNotFound extends RuntimeException{

    public AuthorWithIdNotFound(Long id) {
        super(String.format("The author with id %d is not found",id));
    }
}
