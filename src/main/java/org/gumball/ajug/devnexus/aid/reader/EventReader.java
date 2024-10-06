package org.gumball.ajug.devnexus.aid.reader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gumball.ajug.devnexus.aid.config.IngestProperties;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.JsonReader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class EventReader {
    private static final String[] KEYS = {"id", "title", "description", "startsAt", "endsAt", "roomId", "room"};

    private final IngestProperties ingestProperties;

    JsonReader reader;

    public void read() throws IOException {
        String eventsPath = ingestProperties.getEventsFileName();

        FileSystemResource file = new FileSystemResource(eventsPath);

        JsonReader loader = new JsonReader(file, KEYS);
        List<Document> documentList = loader.read();
        log.error(documentList.toString());
    }
}