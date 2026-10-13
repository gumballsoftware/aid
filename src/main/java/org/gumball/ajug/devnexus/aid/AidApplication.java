package org.gumball.ajug.devnexus.aid;

import jakarta.annotation.PostConstruct;
import org.gumball.ajug.devnexus.aid.service.DownloadService;
import org.gumball.ajug.devnexus.aid.service.IngestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AidApplication {

    @Autowired
    private DownloadService downloadService;

    @Autowired
    private IngestService ingestService;


    public static void main(String[] args) {
        SpringApplication.run(AidApplication.class, args);
    }

    @PostConstruct
    public void init() throws IOException {
        System.err.println("W00t!");
        downloadService.download();
        ingestService.ingest();
    }
}
