package mk.ukim.finki.emt.bookshop.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CountryWithIdNotFound extends RuntimeException{

    public CountryWithIdNotFound(Long id) {
        super(String.format("The country with name %d is not found",id));
    }
}
