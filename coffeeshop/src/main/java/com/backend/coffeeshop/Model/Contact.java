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
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ManyToOne
    private Users user_id;
    @Column(name = "user_message")
    private String message;
    @Column(name = "user_message_date")
    private Date  contact_date;
}
