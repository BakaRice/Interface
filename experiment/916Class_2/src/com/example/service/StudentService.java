package com.example.service;

import com.example.entity.Student;
import com.example.resource.DatabaseUtils;

    public class StudentService {

        public static void printStudentInfo(){
            Student[] students = DatabaseUtils.getStudents();
            for (Student s:students) {
                //s.printInfo();
                System.out.println("姓名:" + s.getName() + "，成绩: " + s.getResults());
            }
        }

        public static Student getStudentForNumber(int number){
            Student[] students = DatabaseUtils.getStudents();
            for(Student s:students){
                if(number == s.getNumber()){
                    return s;
                }
            }
            return null;
        }

        public static float jsAverage(int classNo){
            Student[] students = DatabaseUtils.getStudents();
            float total = 0F;
            int count = 0;
            for(Student s : students){
                if(s.getClassNo() == classNo){
                    count ++;
                    total += s.getResults();
                }
            }
            return count == 0 ? 0 : total / count;
        }
    }
