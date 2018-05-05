package cn.mybatis.mapper;

import cn.mybatis.po.Student;

import java.util.List;

public interface StudentMapper {

    //增加学生
    public void addStudent(Student student);
    //删除学生
    public void delStudentById(Student student);
    //修改学生
    public void updateStudentById(Student student);
    //id查询学生
    public Student selectStudentById(Student student);
    //根据姓名查询学生
    public List<Student> selectStudentByName(Student student);
}
