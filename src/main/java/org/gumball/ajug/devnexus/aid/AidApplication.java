package org.gumball.ajug.devnexus.aid;

import org.gumball.ajug.devnexus.aid.service.DownloadService;
import org.gumball.ajug.devnexus.aid.service.IngestService;
import org.gumball.ajug.devnexus.aid.service.QueryService;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;
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
                .web(WebApplicationType.NONE)
                .run(args);
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
            queryService.query(query);

            query = console.readLine("%nEnter a query or enter nothing to exit\t");
        }
        System.exit(0);
    }
}
