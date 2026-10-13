package org.gumball.ajug.devnexus.aid.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        IngestProperties.class
})
public class ApplicationConfiguration {

    private final IngestProperties ingestProperties;


    public ApplicationConfiguration(IngestProperties ingestProperties) {
        this.ingestProperties = ingestProperties;
    }
}

