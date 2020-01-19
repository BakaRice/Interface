package com.example.resource;

import com.example.entity.Student;

/*需求+1
在com.example.resource下，创建DatabaseUtils工具类，通过静态方法对外提供服务
在类中创建一个私有静态学生数组变量，通过一个私有静态方法初始化数组，
再创建一个公共静态方法，外界通过该方法获取封装的学生数组对象。

*/
public class DatabaseUtils {

    private static Student[] students = initstudents();

    private  static  Student[] initstudents(){
        Student s1 = new Student(2017214317, "TAN", 99, 3);
        Student s2 = new Student(2017214316, "TA", 9, 3);
        Student s3 = new Student(2017214315, "TN", 9, 2);
        Student s4 = new Student(2017214314, "AN", 9, 2);
        Student[] students = {s1,s2,s3,s4};
        return  students;
    }

    public static Student[] getStudents() {
        return students;
    }

    public static void setStudents(Student[] students) {
        DatabaseUtils.students = students;
    }
/*
    public static float getStudentForNumber(int number){
        Student[] students =  DatabaseUtils.getStudents();
        for (Student s:students) {if (number == s.getNumber())
                 return s;
        }
    public static float jsAverage(int classNo){
            Student[] student = DatabaseUtils.getStudents();
            float total = 0F;
            int count = 0;
            for(Student s:student){
                if(s.getClassNo()==classNo){
                    count ++;
                    total += s.getResults();
                }
            }
            return  count == 0 ? 0 : total/count;
        }*/
    }

