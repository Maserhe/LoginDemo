package com.xencio.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.xencio.service")
@MapperScan("com.xencio.mapper")
@PropertySource("classpath:jdbc.properties")
@ComponentScan("com.xencio.controller")
@EnableWebMvc
@Import({JdbcConfig.class,MybatisConfig.class})
public class SpringConfig {
}

