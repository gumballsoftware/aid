package org.gumball.ajug.devnexus.aid.config;

import lombok.Data;
import lombok.Getter;
import org.gumball.ajug.devnexus.aid.preferences.AppUserPreferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.nio.file.FileSystems;

@Data
@ConfigurationProperties("ingest")
public class IngestProperties {

    @Autowired
    AppUserPreferences appUserPreferences;

    @Getter
    private String scheduleURL;
    private String scheduleFileName;

    @Getter
    private String eventsURL;
    private String eventsFileName;

    @Getter
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
