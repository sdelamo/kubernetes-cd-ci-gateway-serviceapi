package example.micronaut.gateway;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

import java.util.List;

@Client("books")
public interface BooksClient extends BooksFetcher {

    @Override
    @Get("/books")
    Single<List<Book>> index();
}
