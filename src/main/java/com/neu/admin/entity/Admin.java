package com.neu.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Admin {
    private int admin_id;
    private String admin_name;
    private String admin_pwd;
    private String admin_type;
}
