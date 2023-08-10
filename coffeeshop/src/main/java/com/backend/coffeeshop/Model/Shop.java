package com.backend.coffeeshop.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shop")
public class Shop {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "shop_id")
    private int shop_id;
   @Column(name = "shop_name")
    private String shop_name;
   @Column(name = "shop_address")
    private String shop_address;
   @Column(name = "shop_picture")
    private String shop_picture;
   @Column(name = "shop_opening_date")
    private String shop_opening_date;

}
