package com.sm2k4.httpcoffee.model;


import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trans_id;
    
    @OneToOne
    @JoinColumn(name = "user_transaction",nullable = false)
    private Users user;

    @OneToMany(mappedBy = "transaction")
    private Set<Coffees> purchased_coffees;


    public Transactions(){
        super();
    }

    public Transactions(Long trans_id,Set<Coffees> purchased_coffees){
        this.trans_id = trans_id;
        this.purchased_coffees = purchased_coffees;
    }

    public Long getTransId(){
        return this.trans_id;
    }

    public void setTransId(Long trans_id){
        this.trans_id = trans_id;
    }

    public Set<Coffees> getPurchasedCoffees(){
        return this.purchased_coffees;
    }

    public void setPurchasedCoffees(Set<Coffees> purchased_coffees){
        this.purchased_coffees = purchased_coffees;
    }


}
