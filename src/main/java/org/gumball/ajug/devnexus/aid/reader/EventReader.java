package org.gumball.ajug.devnexus.aid.reader;

import org.gumball.ajug.devnexus.aid.config.IngestProperties;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class EventReader {
    private static final String[] KEYS = {"title", "description"};

    private final IngestProperties ingestProperties;

    private final EventMetadataGenerator eventMetadataGenerator;

    public EventReader(IngestProperties ingestProperties, EventMetadataGenerator eventMetadataGenerator) {
        this.ingestProperties = ingestProperties;
        this.eventMetadataGenerator = eventMetadataGenerator;
    }

    public List<Document> read() throws IOException {
        String eventsPath = ingestProperties.getEventsFileName();

        FileSystemResource file = new FileSystemResource(eventsPath);

        JsonReader loader = new JsonReader(file, eventMetadataGenerator, KEYS);

        List<Document> documents = loader.get("/0/sessions");
        return documents;
    }
}