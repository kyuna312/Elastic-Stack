package mn.demo.appservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfigs extends WebMvcConfigurerAdapter {
    @Bean
    public io.opentracing.Tracer initTracer() {
        io.jaegertracing.Configuration.SamplerConfiguration samplerConfig = new io.jaegertracing.Configuration.SamplerConfiguration().withType("const").withParam(1);
        io.jaegertracing.Configuration.ReporterConfiguration reporterConfig = io.jaegertracing.Configuration.ReporterConfiguration.fromEnv().withLogSpans(true);
        return io.jaegertracing.Configuration.fromEnv("registry").withSampler(samplerConfig).withReporter(reporterConfig).getTracer();
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/v1/file/d/**").addResourceLocations("file:/files/fintech/");
    }
}
