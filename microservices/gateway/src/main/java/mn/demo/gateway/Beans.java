package mn.demo.gateway;

import io.jaegertracing.Configuration;
import org.springframework.context.annotation.Bean;

public class Beans {
    @Bean
    public io.opentracing.Tracer initTracer() {
        Configuration.SamplerConfiguration samplerConfig = new Configuration.SamplerConfiguration().withType("const").withParam(1);
        Configuration.ReporterConfiguration reporterConfig = Configuration.ReporterConfiguration.fromEnv().withLogSpans(true);
        return Configuration.fromEnv("registry").withSampler(samplerConfig).withReporter(reporterConfig).getTracer();
    }
}
