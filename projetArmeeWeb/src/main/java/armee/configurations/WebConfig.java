package armee.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import armee.config.JPAconfig;

@Configuration
@EnableWebMvc
@ComponentScan("armee.restcontrollers")
@Import(JPAconfig.class)
public class WebConfig {

}
