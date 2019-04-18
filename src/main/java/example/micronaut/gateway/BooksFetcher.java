package example.micronaut.gateway;

import io.reactivex.Single;

import java.util.List;

public interface BooksFetcher {
    Single<List<Book>> index();
}
