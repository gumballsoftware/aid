package org.gumball.ajug.devnexus.aid.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gumball.ajug.devnexus.aid.reader.EventReader;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class IngestService {
    private final EventReader eventReader;
    private final VectorStore vectorStore;

    public void ingest() throws IOException {
        List<Document> documentList = eventReader.read();
        vectorStore.accept(documentList);
    }
}
