package org.gumball.ajug.devnexus.aid.preferences;

import java.nio.file.FileSystems;

public class Constants {
    static final String rootNode = "devnexus";
    static final String downloadNodeName = "download";
    static final String defaultDownload = System.getProperty("java.io.tmpdir") +
            FileSystems.getDefault().getSeparator() +
            downloadNodeName;
}
