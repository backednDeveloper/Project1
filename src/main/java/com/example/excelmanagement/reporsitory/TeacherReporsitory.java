package com.example.excelmanagement.reporsitory;

import com.example.excelmanagement.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Component
public class TeacherReporsitory {
    private static final Logger log = LoggerFactory.getLogger(TeacherReporsitory.class);
    private JdbcTemplate template;
    private static RowMapper<Teacher> rowMapper = (rs, rowNum) -> {
        Teacher teacher = new Teacher();
        teacher.setId(rs.getInt(1));
        teacher.setEmail(rs.getString(2));
        teacher.setPassword(rs.getString(3));
        teacher.setFirst_name(rs.getString(4));
        teacher.setLast_name(rs.getString(5));
        teacher.setPhone_number(rs.getString(6));
        teacher.setBirth_date(rs.getInt(7));
        teacher.setLast_login_date(rs.getInt(8));
        teacher.setStatus(rs.getInt(9));
        teacher.setLast_login_ip(rs.getString(10));
        teacher.setSalary(rs.getInt(11));
        return teacher;
    };

    public List<Teacher> getAllTeacher() {
        String sql = "select * from teacher";
        log.atInfo().log("Teachers retrieved from the database.");
        return template.query(sql, rowMapper);
    }
    public List<Teacher> getTeacherById(int id) {
        String sql = "SELECT * FROM teacher WHERE id = ?";
        List<Teacher> teachers = template.query(sql, new Object[]{id}, rowMapper);

        if (teachers.isEmpty()) {
            log.atInfo().log("Teacher has not been available");
        }
        return teachers;
    }


    public Teacher creatTeacher(Teacher teacher) {
        String sql = "INSERT INTO teacher(email,password,first_name,last_name,phone_number,birth_date,status,salary) VALUES(?,?,?,?,?,?,?,?)";
        int update = template.update(sql, teacher.getEmail(), teacher.getPassword(),
                teacher.getFirst_name(), teacher.getLast_name(),
                teacher.getPhone_number(), teacher.getBirth_date(),
                teacher.getStatus(), teacher.getSalary());
        if (update == 1) {
            log.atInfo().log("Teacher has been created");
        }
        return teacher;
    }

    public Teacher deleteGetById(int id) {
        String sql = "delete from teacher where id=?";
        int delete = template.update(sql,id);
        if (delete == 1) {
            log.atInfo().log("Account has been deleted" + id);
        }
        return null;
    }

    public Teacher updateById(Teacher teacher, int id) {
        String sql = "UPDATE teacher SET email=?, password=?, first_name=?,last_name=?,phone_number=?,birth_date=?,status=?,salary=? WHERE id=?";
        int update = template.update(sql, id);
        if (update == 1) {
            log.atInfo().log("Teacher has been update" + teacher.toString());
        }
        return teacher;
    }
}

