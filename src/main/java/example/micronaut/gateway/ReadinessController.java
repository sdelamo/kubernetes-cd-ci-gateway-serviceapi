package example.micronaut.gateway;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.core.util.StringUtils;
import io.micronaut.discovery.event.ServiceStartedEvent;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.annotation.security.PermitAll;

/**
 * Controller to be used as a readiness probe of the application start.
 */
@Requires(property = ReadinessControllerConfigurationProperties.PREFIX + ".enabled", notEquals = StringUtils.FALSE)
@Controller("${" + ReadinessControllerConfigurationProperties.PREFIX + ".path:/ready}")
@PermitAll
public class ReadinessController implements ApplicationEventListener<ServiceStartedEvent> {

    private boolean ready;

    private final ReadinessControllerConfiguration readinessControllerConfiguration;

    /**
     *
     * @param readinessControllerConfiguration ReadinessController configuration
     */
    public ReadinessController(ReadinessControllerConfiguration readinessControllerConfiguration) {
        this.readinessControllerConfiguration = readinessControllerConfiguration;
    }

    @Override
    public void onApplicationEvent(ServiceStartedEvent event) {
        ready = true;
    }

    /**
     *
     * @return an HTTP Status
     */
    @Get
    public HttpStatus index() {
        return ready ? readinessControllerConfiguration.getReadyStatus() :
                readinessControllerConfiguration.getNotReadyStatus();
    }
}
