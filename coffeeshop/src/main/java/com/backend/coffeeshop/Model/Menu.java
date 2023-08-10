package com.backend.coffeeshop.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "coffee_id")
    private int coffee_id;
    @Column(name = "coffee_name")
    private String coffee_name;
    @Column(name = "coffee_description")
    private String coffee_description;
    @Column(name = "coffee_image")
    private String coffee_image;
    @Column(name = "date_added")
    private Date  dateAdded;


}
