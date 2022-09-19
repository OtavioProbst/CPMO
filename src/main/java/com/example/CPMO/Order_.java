package com.example.CPMO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

enum orderStatus{
    placed,
    approved,
    delivered
}

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order_ { // "Order" is a reserved keyword for H2 databases

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long petId;
    private  int quantity;
    private String shipDate; // format: date
    private orderStatus status;
    private boolean complete;
}
