package com.sena.backend.usersapp.backendusersapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Esto aplica la configuración CORS a todas las rutas de tu API
                .allowedOrigins("http://localhost:5173") // Permite peticiones desde tu frontend de React
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos
                .allowedHeaders("*") // Permite todos los headers
                .allowCredentials(true) // Permite el envío de cookies o credenciales (si las usas)
                .maxAge(3600); // Duración en segundos que la pre-flight request puede ser cacheada
    }
}