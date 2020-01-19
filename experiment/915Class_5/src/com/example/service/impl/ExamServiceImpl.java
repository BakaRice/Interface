package com.example.service.impl;

import com.example.resource.Database;
import com.example.service.ExamService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import com.example.entity.*;

import java.util.*;
import java.util.stream.Collectors;

public class ExamServiceImpl implements ExamService {

    private static final LocalDate BASE_DATE = LocalDate.of(2019, 2, 25);

    @Override
    public int getWeeks(LocalDate date){
        return (int) (BASE_DATE.until(date, ChronoUnit.WEEKS));
        /**   LEARIN!!!
         * public enum ChronoUnit
         * extends Enum<ChronoUnit>
         * implements TemporalUnit
         *
         */
    }

    public List<Exam> listExams(LocalDate startDate){
        return Database.getExams()
                .stream()
                .filter(e -> (e.getDate().isEqual(startDate)))
                .collect(Collectors.toList());
        /**
         * To find out the different between the
         * LocalDateTime
         * LocalDate
         * LocalTime
         */
    }
    public List<Exam> listExams(LocalDateTime startDateTime){
        return Database.getExams()
                .stream()
                .filter(e-> startDateTime.isEqual(LocalDateTime.of(e.getDate(), e.getStartTime())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Exam> listExams(int durationMinutes){
        return Database.getExams()
                .stream()
                .filter(e -> e.getStartTime().plusMinutes(durationMinutes)
                              .equals(e.getEndTime()))
                .collect(Collectors.toList());
    }

}
