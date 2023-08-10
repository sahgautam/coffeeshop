package com.backend.coffeeshop.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Users{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    private String user_name;
    private String user_email;
    private String user_contact;
    private String user_age;
    private String user_gender;
    private String user_password;
    private String user_type;
    private Date user_registration_date;
}
