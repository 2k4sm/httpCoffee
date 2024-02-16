package com.sm2k4.httpcoffee.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    private String user_name;
    private String user_email;

    @Temporal(TemporalType.DATE)
    private Date order_dt;

    @OneToOne(mappedBy = "user")
    private Coffees last_order;
    
    @OneToOne(mappedBy = "user")
    private Transactions user_transaction;

    public Users(){
        super();
    }

    public Users(Long user_id,String user_name,String user_email,Coffees last_order, Transactions user_Transaction){
        super();
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.last_order = last_order;
        java.util.Date utilDate = new java.util.Date();
        this.order_dt = new Date(utilDate.getTime());
        this.user_transaction = user_Transaction;
    }


    public Long getUserId(){
        return this.user_id;
    }

    public void setUserId(Long user_id){
        this.user_id = user_id;
    }


    public String getUserName(){
        return this.user_name;
    }

    public void setUserName(String user_name){
        this.user_name = user_name;
    }

    public String getUserEmail(){
        return this.user_email;
    }

    public void setUserEmail(String user_email){
        this.user_email = user_email;
    }

    public Date getOrderDate(){
        return this.order_dt;
    }

    public void setOrderDate(Date order_dt){
        this.order_dt = order_dt;
    }

    public Coffees getLastOrder(){
        return this.last_order;
    }

    public void setLastOrder(Coffees last_order){
        this.last_order = last_order;
    }

    public Transactions getUserTransactions(){
        return this.user_transaction;
    }

    public void setUserTransactions(Transactions user_Transaction){
        this.user_transaction = user_Transaction;
    }


}
