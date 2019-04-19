package example.micronaut.gateway;

import io.micronaut.core.util.Toggleable;
import io.micronaut.http.HttpStatus;

/**
 * {@link ReadinessController} configuration.
 */
public interface ReadinessControllerConfiguration extends Toggleable {

    /**
     *
     * @return Path where the {@link ReadinessController} listens.
     */
    String getPath();

    /**
     *
     * @return HTTP Status returned if ready
     */
    HttpStatus getReadyStatus();

    /**
     *
     * @return HTTP Status returned if not ready
     */
    HttpStatus getNotReadyStatus();
}
