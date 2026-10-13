package org.gumball.ajug.devnexus.aid.config;

import org.gumball.ajug.devnexus.aid.preferences.AppUserPreferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.file.FileSystems;

@ConfigurationProperties("ingest-properties")
public class IngestProperties {
    private String scheduleURL;
    private String scheduleFileName;

    private String eventsURL;
    private String eventsFileName;

    private String speakersURL;
    private String speakersFileName;

    @Autowired
    private AppUserPreferences appUserPreferences;

    String getFilePrefix() {
        return appUserPreferences.getDownloadDirectory()
                + FileSystems.getDefault().getSeparator();
    }

    public String getScheduleFileName() {return getFilePrefix() + scheduleFileName;}

    public String getEventsFileName() {return getFilePrefix() + eventsFileName;}

    public String getSpeakersFileName() {return getFilePrefix() + speakersFileName;}

    public String getScheduleURL() {
        return scheduleURL;
    }

    public void setScheduleURL(String scheduleURL) {
        this.scheduleURL = scheduleURL;
    }

    public void setScheduleFileName(String scheduleFileName) {
        this.scheduleFileName = scheduleFileName;
    }

    public String getEventsURL() {
        return eventsURL;
    }

    public void setEventsURL(String eventsURL) {
        this.eventsURL = eventsURL;
    }

    public void setEventsFileName(String eventsFileName) {
        this.eventsFileName = eventsFileName;
    }

    public String getSpeakersURL() {
        return speakersURL;
    }

    public void setSpeakersURL(String speakersURL) {
        this.speakersURL = speakersURL;
    }

    public void setSpeakersFileName(String speakersFileName) {
        this.speakersFileName = speakersFileName;
    }

    public AppUserPreferences getAppUserPreferences() {
        return appUserPreferences;
    }

    public void setAppUserPreferences(AppUserPreferences appUserPreferences) {
        this.appUserPreferences = appUserPreferences;
    }
}
