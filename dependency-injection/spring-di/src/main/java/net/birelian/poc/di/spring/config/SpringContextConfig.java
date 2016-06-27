package net.birelian.poc.di.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Context Configuration class
 */
@Configuration
@ComponentScan({"net.birelian.poc.di.spring.service", "net.birelian.poc.di.spring.dao"})
public class SpringContextConfig {
}