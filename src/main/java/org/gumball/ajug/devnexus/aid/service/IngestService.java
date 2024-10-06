package org.gumball.ajug.devnexus.aid.service;

import lombok.RequiredArgsConstructor;
import org.gumball.ajug.devnexus.aid.config.IngestProperties;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
@RequiredArgsConstructor
public class IngestService {
//    @Value("classpath:/data/Employee_Handbook.pdf")
//    private Resource pdfResource;

    @Autowired
    private VectorStore vectorStore;

    private final IngestProperties ingestProperties;

    public void download() throws IOException {
        String schedulePath = ingestProperties.getScheduleFileName();
        String eventsPath = ingestProperties.getEventsFileName();
        String speakerPath = ingestProperties.getSpeakersFileName();

        Path scheduleFilePath = Paths.get(schedulePath);
        Files.createDirectories(scheduleFilePath.getParent());

        Path eventsFilePath = Paths.get(eventsPath);
        Files.createDirectories(eventsFilePath.getParent());

        Path speakerFilePath = Paths.get(speakerPath);
        Files.createDirectories(speakerFilePath.getParent());

        InputStream in = URI.create(ingestProperties.getScheduleURL()).toURL().openStream();
        Files.copy(in, scheduleFilePath, StandardCopyOption.REPLACE_EXISTING);
        in = URI.create(ingestProperties.getEventsURL()).toURL().openStream();
        Files.copy(in, eventsFilePath, StandardCopyOption.REPLACE_EXISTING);
        in = URI.create(ingestProperties.getSpeakersURL()).toURL().openStream();
        Files.copy(in, speakerFilePath, StandardCopyOption.REPLACE_EXISTING);
    }
}
