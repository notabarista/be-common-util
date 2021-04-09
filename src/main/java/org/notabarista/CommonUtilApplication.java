package org.notabarista;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@ComponentScan("org.notabarista")
@EntityScan
@EnableAsync
@EnableConfigurationProperties(LibraryProperties.class)
@EnableAutoConfiguration
public class CommonUtilApplication {

}
