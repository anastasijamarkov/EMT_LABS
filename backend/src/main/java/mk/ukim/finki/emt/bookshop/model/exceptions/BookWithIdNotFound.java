package mk.ukim.finki.emt.bookshop.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BookWithIdNotFound extends RuntimeException{

    public BookWithIdNotFound(Long id) {
        super(String.format("The book with id %d is not found",id));
    }
}
