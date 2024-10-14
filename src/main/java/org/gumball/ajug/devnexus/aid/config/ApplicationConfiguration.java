package org.gumball.ajug.devnexus.aid.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        IngestProperties.class
})
public class ApplicationConfiguration {

    @Autowired
    IngestProperties ingestProperties;

}

