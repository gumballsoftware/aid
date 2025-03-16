package org.gumball.ajug.devnexus.aid;

import org.gumball.ajug.devnexus.aid.service.DownloadService;
import org.gumball.ajug.devnexus.aid.service.IngestService;
import org.gumball.ajug.devnexus.aid.service.QueryService;
import org.springframework.ai.document.Document;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
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
public class AidApplication {
    public static void main(String[] args) {
        SpringApplication.run(AidApplication.class, args);
    }
}
