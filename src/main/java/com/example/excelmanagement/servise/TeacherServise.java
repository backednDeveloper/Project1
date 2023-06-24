package com.example.excelmanagement.servise;

import com.example.excelmanagement.entity.Teacher;
import com.example.excelmanagement.reporsitory.TeacherReporsitory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServise {
    private static final TeacherReporsitory reporsitory = null;
    public List<Teacher> getAllTeacher(){
        return reporsitory.getAllTeacher();
    }
    public Teacher creatTeacher(Teacher teacher){
        return reporsitory.creatTeacher(teacher);
    }
    public Teacher deleteGetById(int id){
        return reporsitory.deleteGetById(id);
    }
    public Teacher updateById(Teacher teacher, int id){
        return reporsitory.updateById(teacher, id);
    }
    public List<Teacher> getTeacherById(int id){
        return reporsitory.getTeacherById(id);
    }
}

