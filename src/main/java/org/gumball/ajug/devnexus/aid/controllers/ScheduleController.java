package org.gumball.ajug.devnexus.aid.controllers;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@CrossOrigin
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @RequestMapping("/period")
    public int findPeriod(@RequestParam(required = true) String at) {
        LocalDateTime dateTime = LocalDateTime.parse(at);
        int day = dateTime.getDayOfMonth();
        int hour = dateTime.getHour();
        if ((day < 3) || (day > 5))
            throw new IllegalArgumentException("Invalid day");
        if ((hour < 6) || (hour > 16))
            throw new IllegalArgumentException("Invalid hour");

        return (day - 3) * 10 + (hour - 5);
    }
}
