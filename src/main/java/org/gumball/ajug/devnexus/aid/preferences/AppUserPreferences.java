package org.gumball.ajug.devnexus.aid.preferences;

import org.springframework.stereotype.Component;

import java.util.prefs.Preferences;

@Component
public class AppUserPreferences {
    public String getDownloadDirectory() {
        Preferences prefs = Preferences.userRoot().node(Constants.rootNode);
        return prefs.get(Constants.downloadNodeName, Constants.defaultDownload);
    }
}
