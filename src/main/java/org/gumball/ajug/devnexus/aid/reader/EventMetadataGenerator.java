package org.gumball.ajug.devnexus.aid.reader;

import org.springframework.ai.reader.JsonMetadataGenerator;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class EventMetadataGenerator implements JsonMetadataGenerator {
    String[] metadataKeys = {"id", "title", "room", "speakers", "startsAt", "endsAt"};
    @Override
    public Map<String, Object> generate(Map<String, Object> jsonMap) {
        return Arrays.stream(metadataKeys).collect(Collectors.toMap(key -> key, jsonMap::get));
    }
}
