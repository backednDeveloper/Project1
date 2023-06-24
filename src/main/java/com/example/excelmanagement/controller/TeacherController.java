package com.example.excelmanagement.controller;

import com.example.excelmanagement.entity.Teacher;
import com.example.excelmanagement.servise.TeacherServise;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private static TeacherServise teacherservise ;
    @GetMapping()
    public List<Teacher> getAllTeacher(){
        return teacherservise.getAllTeacher();
    }
    @GetMapping("getTeacherById,{id}")
    public List<Teacher> getTeacherById(@PathVariable int id){
        return teacherservise.getTeacherById(id);
    }
    @PostMapping("/createTeacher")
    public Teacher creatTeacher(@RequestBody Teacher teacher){
        return teacherservise.creatTeacher(teacher);
    }
    @DeleteMapping("/deleteGetById,{id}")
    public Teacher deleteGetById(@PathVariable int id){
        return teacherservise.deleteGetById(id);
    }
    @PutMapping("/updateById,{id}")
    public Teacher updateById(@RequestBody Teacher teacher, @PathVariable int id){
        return teacherservise.updateById(teacher,id);
    }

}

