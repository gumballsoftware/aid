package org.gumball.ajug.devnexus.aid.controllers;

import lombok.SneakyThrows;
import org.gumball.ajug.devnexus.aid.service.DownloadService;
import org.gumball.ajug.devnexus.aid.service.IngestService;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/application")
public class ApplicationController {
    @Autowired
    DownloadService downloadService;

    @Autowired
    IngestService ingestService;

    @Autowired
    VectorStore vectorStore;

    @SneakyThrows
    @GetMapping("/ingest")
    public String ingest() {
        downloadService.download();
        ingestService.ingest();
        return "ready";
    }
}
