package mk.ukim.finki.emt.bookshop.model.exceptions;

public class NoMoreAvailableCopiesException extends Exception{

    public NoMoreAvailableCopiesException(Long id) {
        super("There are no more available copies of the book with id "+id);
    }
}
