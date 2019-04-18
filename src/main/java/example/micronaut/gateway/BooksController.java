package example.micronaut.gateway;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

import java.util.List;

@Controller("/books")
public class BooksController {

    private final BooksFetcher booksFetcher;

    public BooksController(BooksFetcher booksFetcher) {
        this.booksFetcher = booksFetcher;
    }
    @Get
    Single<List<Book>> index() {
        return booksFetcher.index();
    }
}
