package org.gumball.ajug.devnexus.aid.service;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class QueryService {
    private final VectorStore vectorStore;

    public void query(String query) {
        SearchRequest searchRequest = SearchRequest.query(query).withTopK(5);
        var resp = vectorStore.similaritySearch(searchRequest);
        resp.forEach(document -> {
            System.err.println(" ");
                    System.err.println("********* title: " + document.getMetadata().get("title"));
                    System.err.println("********* room: " + document.getMetadata().get("room"));
                    System.err.println("********* starts: " + document.getMetadata().get("startsAt"));
                    System.err.println("********* ends: " + document.getMetadata().get("endsAt"));
            System.err.println(" ");
                }
        );
    }
}
