package net.nvsoftware.iProductService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//connect to JPA database
@Entity
//use lombok
@Data
//create constructor
@AllArgsConstructor
//create constructor without arguments
@NoArgsConstructor
//create builder pattern: for easier access to given data or valued data: long box annotation
@Builder

public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //think about whats in a product
    private long productId;
    //change names
    //@Column(name="Name")
    private String productName;
    private long productPrice;
    private long ProductQuantity;



}
