package org.gumball.ajug.devnexus.aid.reader;

import org.springframework.ai.reader.JsonMetadataGenerator;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class EventMetadataGenerator implements JsonMetadataGenerator {
    String[] metadataKeys = {"id", "title", "room", "startsAt", "endsAt"};

    @Override
    public Map<String, Object> generate(Map<String, Object> jsonMap) {
        List speakers = (List) jsonMap.get("speakers");
        List speakerNames = (List) speakers.stream().map(this::getSpeakerName).collect(Collectors.toList());
        Map retval = Arrays.stream(metadataKeys).collect(Collectors.toMap(key -> key, jsonMap::get));
        retval.put("speakers", speakerNames);
        retval.put("description", getDescription(jsonMap));

        return retval;
    }

    private String getDescription(Object o) {
        var result = (String)((Map)o).get("description");
        return result==null?"":result;
    }

    private String getSpeakerName(Object o) {
        return (String)((Map)o).get("name");
    }
}
