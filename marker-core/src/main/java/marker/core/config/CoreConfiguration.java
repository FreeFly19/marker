package marker.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by FreeFly on 02.11.2016.
 */
@Configuration
@ComponentScan(value = {
        "marker.core.config",
        "marker.persistence.dao",
        "marker.core.service"
})
public class CoreConfiguration {
}
