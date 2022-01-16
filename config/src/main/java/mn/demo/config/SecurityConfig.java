package mn.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/actuator/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic(); //config server-ээс тохиргоонуудын параметрыг авахын тулд baisic auth ашиглах config server-тэй холбогдоно

    }

    @Bean
    public io.opentracing.Tracer initTracer() {
        io.jaegertracing.Configuration.SamplerConfiguration samplerConfig = new io.jaegertracing.Configuration.SamplerConfiguration().withType("const").withParam(1);
        io.jaegertracing.Configuration.ReporterConfiguration reporterConfig = io.jaegertracing.Configuration.ReporterConfiguration.fromEnv().withLogSpans(true);
        return io.jaegertracing.Configuration.fromEnv("registry").withSampler(samplerConfig).withReporter(reporterConfig).getTracer();
    }
}
