package com.example;

import com.example.entity.Exam;
import com.example.resource.Database;
import com.example.service.impl.ExamServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ExamServiceImpl ExamImp = new ExamServiceImpl();
        formatTest();
        System.out.println("****统计考试时长为90mimn的考试***");
        printLis(ExamImp.listExams(90));
        System.out.println();
        System.out.println("****统计在22日的考试***");
        printLis(ExamImp.listExams(LocalDate.of(2019, 5, 6)));
        printLis(ExamImp.listExams(LocalDateTime.of(2019, 6, 22, 8, 0)));
    }
    
    public static void printLis(List<Exam> list){
        for (Exam e:list) {
            System.out.println("考试科目"+e.getCourseName()+"/考试时间:"+e.getDate()+"/"+e.getStartTime()
                                                                        +"-"+e.getEndTime());
        }
    }

    private static void formatTest() {
        LocalDateTime dateTime = LocalDateTime.of(2019, 6, 22, 8, 0);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("E yyyy/MM/dd HH:mm");
        System.out.println(dateTime.format(df));
    }
}
