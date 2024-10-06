package org.gumball.ajug.devnexus.aid;

import org.gumball.ajug.devnexus.aid.reader.EventReader;
import org.gumball.ajug.devnexus.aid.service.IngestService;
import org.springframework.ai.ollama.api.OllamaModel;
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
    IngestService ingestService;

    @Autowired
    EventReader eventReader;

    public static void main(String[] args) {
        new SpringApplicationBuilder(AidApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Override
    public void run(String... args) throws IOException {
        System.err.println("EXECUTING : command line runner");
        System.err.println(Arrays.toString(OllamaModel.values()));
        ingestService.download();
        eventReader.read();
    }


}
