package com.neu.movies.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Movies {
    private int m_id;
    private String m_infoLink;
    private String m_picLink;
    private String m_name;
    private double m_score;
    private  int m_rated;
    private String m_instruction;
    private String m_info;
}
