package org.gumball.ajug.devnexus.aid.controllers;

import org.gumball.ajug.devnexus.aid.service.QueryService;
import org.springframework.ai.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin // Add this for frontend-backend communication
@RestController
@RequestMapping("/api")
public class QueryController {

    @Autowired
    QueryService queryService;

    @PostMapping("/query")
    public List<ResponseDoc> handleQuery(@RequestBody String request) {
        List<Document> docs = queryService.query(request, 5);
        return docs.stream().map(ResponseDoc::new).toList();
    }

    public List<String> docToStringList(Document doc) {
        List<String> response = new ArrayList<>(doc.getMetadata().entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .toList());
        response.addFirst("Score: " + doc.getScore());

        return response;
    }

    static class ResponseDoc {
        public Double score;
        public String title;
        public String description;
        public String startsAt;
        public String endsAt;
        public String speakers;
        public String room;
        ResponseDoc(Document doc) {
            score = doc.getScore();
            Map<String, Object> metadata = doc.getMetadata();
            title = (String) metadata.get("title");
            description = (String) metadata.get("description");
            startsAt = (String) metadata.get("startsAt");
            endsAt = (String) metadata.get("endsAt");
            speakers = metadata.get("speakers").toString();
            room = (String) metadata.get("room");
        }
    }


}
