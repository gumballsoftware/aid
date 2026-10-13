package org.gumball.ajug.devnexus.aid.service;

import org.gumball.ajug.devnexus.aid.reader.EventReader;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class IngestService {
    private final EventReader eventReader;
    private final VectorStore vectorStore;

    public IngestService(EventReader eventReader, VectorStore vectorStore) {
        this.eventReader = eventReader;
        this.vectorStore = vectorStore;
    }

    public void ingest() throws IOException {
        List<Document> documentList = eventReader.read();
        vectorStore.accept(documentList);
    }
}
