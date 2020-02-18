package scratches.boot.apm.monitoring;

import co.elastic.apm.attach.ElasticApmAttacher;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Rashidi Zin
 */
@Component
@AllArgsConstructor
public class MonitoringRunner implements CommandLineRunner {

    private static final String APPLICATION_PACKAGE = "scratches.boot.apm";

    private final Environment env;

    @Override
    public void run(String... args) {
        var serviceName = env.getRequiredProperty("spring.application.name");
        var serverUrl = env.getProperty("application.monitoring.url", "http://localhost:8200");

        Map<String, String> configurations = Map.of(
                "service_name", serviceName,
                "application_packages", APPLICATION_PACKAGE,
                "server_urls", serverUrl
        );

        ElasticApmAttacher.attach(configurations);
    }
}
