package org.gumball.ajug.devnexus.aid;

import org.gumball.ajug.devnexus.aid.service.DownloadService;
import org.gumball.ajug.devnexus.aid.service.IngestService;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication
public class AidApplication implements CommandLineRunner {
    @Autowired
    DownloadService downloadService;

    @Autowired
    IngestService ingestService;

    @Autowired
    VectorStore vectorStore;

    public static void main(String[] args) {
        new SpringApplicationBuilder(AidApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Override
    public void run(String... args) throws IOException {
        System.err.println("STARTED : command line args are:");
        for(String arg:args) {
            System.out.println(arg);
        }
        if (Arrays.asList(args).contains("-d")) {
            downloadService.download();
        }
        if (Arrays.asList(args).contains("-i")) {
            ingestService.ingest();
        }
        if (Arrays.asList(args).contains("-x")) {
            System.err.println("Ollama models are:");
            System.err.println(Arrays.toString(OllamaModel.values()));
        }
    }
}
