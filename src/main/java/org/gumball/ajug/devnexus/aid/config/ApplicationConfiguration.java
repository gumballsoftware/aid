package org.gumball.ajug.devnexus.aid.config;

import org.gumball.ajug.devnexus.aid.service.IngestService;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.PgVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@EnableConfigurationProperties({
        IngestProperties.class
})
public class ApplicationConfiguration {

    @Autowired
    IngestProperties ingestProperties;

    @Bean
    public IngestService ingestService() {
        return new IngestService(ingestProperties);
    }

    /*
    @Bean
    public VectorStore vectorStore(JdbcTemplate jdbcTemplate, EmbeddingModel embeddingModel) {
        return new PgVectorStore(jdbcTemplate, embeddingModel);
    }
     */
}

