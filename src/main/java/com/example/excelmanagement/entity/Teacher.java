package com.example.excelmanagement.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Teacher {
    private String email;
    private String password;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String last_login_ip;
    private int id;
    private int birth_date;
    private int last_login_date;
    private int status;
    private int salary;

}
