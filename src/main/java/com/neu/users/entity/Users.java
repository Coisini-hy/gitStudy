package com.neu.users.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Users {
    private int user_id;
    private String user_name;
    private String user_pwd;
    private String user_sex;
    private String user_phone;
    private String user_type;
    private String user_path;
}
