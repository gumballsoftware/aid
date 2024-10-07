package org.gumball.ajug.devnexus.aid.config;

import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.gumball.ajug.devnexus.aid.preferences.AppUserPreferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.nio.file.FileSystems;

@Data
@Slf4j
@ConfigurationProperties("ingest")
public class IngestProperties {

    @Autowired
    AppUserPreferences appUserPreferences;

    private String scheduleURL;
    private String scheduleFileName;

    private String eventsURL;
    private String eventsFileName;

    private String speakersURL;
    private String speakersFileName;

    String getFilePrefix() {
        return appUserPreferences.getDownloadDirectory()
                + FileSystems.getDefault().getSeparator();
    }

    public String getScheduleFileName() {return getFilePrefix() + scheduleFileName;}

    public String getEventsFileName() {return getFilePrefix() + eventsFileName;}

    public String getSpeakersFileName() {return getFilePrefix() + speakersFileName;}
}
