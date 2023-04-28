package mk.ukim.finki.emt.bookshop.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BookWithNameNotFound extends RuntimeException{

    public BookWithNameNotFound(String id) {
        super(String.format("The book with name %d is not found",id));
    }
}
