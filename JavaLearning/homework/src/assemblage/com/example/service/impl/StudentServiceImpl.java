package assemblage.com.example.service.impl;


import assemblage.com.example.entity.Student;
import assemblage.com.example.resource.Database;
import assemblage.com.example.service.StudentService;

import java.util.ArrayList;
import java.util.List;

public  class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> listStudents(){//记得要写成public类型
        Database stus =  new Database();
        return stus.getTpstus();//返回临时数据库中的全部学生
    }
    @Override
    public void addStudent(Student stu){
       Database.getTpstus().add(stu);//通过在database中定义静态方法 get 来获取对于的对象，然后使用对象的add方法 将学生信息传入
    }
    @Override
    public Student getStudent(int sid){
        Database stus =  new Database();
        stus.getTpstus();
        Student temp = new Student(0, "NULL");
        for (Student tp:stus.getTpstus()) {
            if (tp.getId()== sid) {
                System.out.println("找到了该学生：" );
                temp = tp;
                break;
            }
        }
        return temp;//返回查找到的学生
    }
    @Override
    public List<Student> listStudentsByYear(int year){
        List<Student> gardestus = new ArrayList<Student>();
        Database stus = new Database();//读取基本临时数据库
        String year_ = String.valueOf(year);
        for (Student tp:stus.getTpstus()) {
           String tempid = String.valueOf(tp.getId());
            //       System.out.println(tempid.substring(0,4)+" "+year_);
            if (tempid.substring(0,4).equals(year_)) {//记得使用equal方法！！ 不能用“==”直接比较！
            gardestus.add(tp);
            }
        }
        return gardestus;
    }
}
