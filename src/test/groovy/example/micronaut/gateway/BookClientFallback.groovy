package example.micronaut.gateway

import io.micronaut.retry.annotation.Fallback
import io.reactivex.Single

@Fallback
class BookClientFallback implements BooksFetcher {
    @Override
    Single<List<Book>> index() {
        Single.just(Collections.singletonList(new Book("Building Microservices", 100)))
    }
}
