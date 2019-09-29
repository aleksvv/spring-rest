package it.discovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.util.List;

@SpringBootApplication
@EnableCaching
public class RestApplication implements WebMvcConfigurer {
	public static void main(String[] args) {
		SpringApplication.run(
				RestApplication.class, args);
	}

    @Autowired
    private List<HandlerInterceptorAdapter> inteceptors;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        inteceptors.forEach(registry::addInterceptor);
    }
}
