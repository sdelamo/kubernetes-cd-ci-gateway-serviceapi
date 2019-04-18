package example.micronaut.gateway;

import io.micronaut.retry.annotation.Fallback;
import io.reactivex.Single;
import java.util.List;
import java.util.Collections;

@Fallback
public class BookClientFallback implements BooksFetcher {
    @Override
    public Single<List<Book>> index() {
        return Single.just(Collections.emptyList());
    }
}
