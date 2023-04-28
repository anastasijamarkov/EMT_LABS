package mk.ukim.finki.emt.bookshop.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoryRestController {

    private final List<String> categories;

    public CategoryRestController() {
        this.categories = new ArrayList<>();
        categories.add("NOVEL");
        categories.add("THRILLER");
        categories.add("HISTORY");
        categories.add("FANTASY");
        categories.add("BIOGRAPHY");
        categories.add("CLASSICS");
        categories.add("DRAMA");
    }

    @GetMapping
    public List<String> findAll(){
        return this.categories;
    }
}
