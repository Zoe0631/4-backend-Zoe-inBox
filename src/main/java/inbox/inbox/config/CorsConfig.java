package inbox.inbox.config;

import static inbox.inbox.utils.ConstantManager.FRONT_URL;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// cors config
@Configuration
@Component
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins(FRONT_URL)
            .allowedMethods(HttpMethod.GET.name(),HttpMethod.POST.name(),HttpMethod.OPTIONS.name())
            .allowCredentials(true).allowedHeaders("*").maxAge(86400);
    }
}