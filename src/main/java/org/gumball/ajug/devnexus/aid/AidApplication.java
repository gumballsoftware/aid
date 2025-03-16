package org.gumball.ajug.devnexus.aid;

import org.gumball.ajug.devnexus.aid.service.DownloadService;
import org.gumball.ajug.devnexus.aid.service.IngestService;
import org.gumball.ajug.devnexus.aid.service.QueryService;
import org.springframework.ai.document.Document;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.Console;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class AidApplication implements CommandLineRunner {
    @Autowired
    DownloadService downloadService;

    @Autowired
    IngestService ingestService;

    @Autowired
    VectorStore vectorStore;

    @Autowired
    QueryService queryService;

    public static void main(String[] args) {
        new SpringApplicationBuilder(AidApplication.class)
                .run(args);
    }
    void printResult( List<Document> resp) {
        resp.sort((o1, o2) -> o1.getScore().compareTo(o2.getScore()));
        resp.forEach(document -> {
                    System.err.println(" ");
                    System.err.println("********* score: " + document.getScore());
                    System.err.println("********* title: " + document.getMetadata().get("title"));
                    System.err.println("********* description: " + document.getMetadata().get("description"));
                    System.err.println("********* starts: " + document.getMetadata().get("startsAt"));
                    System.err.println("********* ends: " + document.getMetadata().get("endsAt"));
                    System.err.println("********* speaker(s): " + document.getMetadata().get("speakers"));
                    System.err.println("********* room: " + document.getMetadata().get("room"));
                    System.err.println(" ");
                }
        );
    }

    @Override
    public void run(String... args) throws IOException {
        Console console = System.console();

        console.printf("%nDownloading...%n");
        downloadService.download();

        console.printf("Ingesting...%n");
        ingestService.ingest();

        String query = console.readLine("%nEnter a query or enter nothing to exit\t");

        while (!query.isEmpty()) {
            printResult(queryService.query(query));

            query = console.readLine("%nEnter a query or enter nothing to exit\t");
        }
        System.exit(0);
    }
}
