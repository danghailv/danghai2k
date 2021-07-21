package com.example.restfull_api_demo1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Component
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User  {
    private int userid;
    private String username;
    private String email;
    private int  groupid;

}
