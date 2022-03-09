package com.neu.movies.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comments {
    private Integer ur_id;
    private Integer user_id;
    private String user_name;
    private Integer m_id;
    private String ur_comment;
    private Timestamp ur_date;
}
