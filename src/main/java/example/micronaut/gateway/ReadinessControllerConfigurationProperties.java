package example.micronaut.gateway;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.util.StringUtils;
import io.micronaut.http.HttpStatus;

import javax.annotation.Nullable;

/**
 * {@link ConfigurationProperties} implementation of {@link ReadinessControllerConfiguration}.
 */
@Requires(property = ReadinessControllerConfigurationProperties.PREFIX + ".enabled", notEquals = StringUtils.FALSE)
@ConfigurationProperties(ReadinessControllerConfigurationProperties.PREFIX)
public class ReadinessControllerConfigurationProperties implements ReadinessControllerConfiguration {

    public static final String PREFIX = "micronaut.readiness";

    public static final HttpStatus DEFAULT_READY_STATUS = HttpStatus.OK;
    public static final HttpStatus DEFAULT_NOT_READY_STATUS = HttpStatus.SERVICE_UNAVAILABLE;

    @Nullable
    private String path;

    private HttpStatus readyStatus = DEFAULT_READY_STATUS;

    private HttpStatus notReadyStatus = DEFAULT_NOT_READY_STATUS;

    @Override
    @Nullable
    public String getPath() {
        return this.path;
    }

    @Override
    public HttpStatus getReadyStatus() {
        return this.readyStatus;
    }

    @Override
    public HttpStatus getNotReadyStatus() {
        return this.notReadyStatus;
    }

    /**
     *
     * @param path {@link ReadinessController} path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     *
     * @param readyStatus HTTP Status returned if ready
     */
    public void setReadyStatus(HttpStatus readyStatus) {
        this.readyStatus = readyStatus;
    }

    /**
     *
     * @param notReadyStatus HTTP Status returned if not ready
     */
    public void setNotReadyStatus(HttpStatus notReadyStatus) {
        this.notReadyStatus = notReadyStatus;
    }
}
