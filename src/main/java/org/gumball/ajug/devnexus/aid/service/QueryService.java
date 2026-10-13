package org.gumball.ajug.devnexus.aid.service;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryService {
    private final VectorStore vectorStore;

    public QueryService(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    public List<Document> query(String query) {
        SearchRequest searchRequest = SearchRequest.builder()
                .query(query)
//                .topK(154)
                .topK(6)
                .build();
        var resp = vectorStore.similaritySearch(searchRequest);
        assert resp != null;
        return resp;
    }
    public List<Document> query(String query, int topK) {
        SearchRequest searchRequest = SearchRequest.builder()
                .query(query)
                .topK(topK)
                .build();
        var resp = vectorStore.similaritySearch(searchRequest);
        assert resp != null;
        return resp;
    }



}
