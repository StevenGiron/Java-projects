package com.bolsadeideas.springboot.app.springboot.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:textos.properties")
})
public class TextosPropertiesConfig {
}
