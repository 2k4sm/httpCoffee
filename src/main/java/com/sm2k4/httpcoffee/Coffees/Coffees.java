package com.sm2k4.httpcoffee.Coffees;

import java.sql.Date;

import com.sm2k4.httpcoffee.Transactions.Transactions;
import com.sm2k4.httpcoffee.Users.Users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "coffee")
public class Coffees {

    enum CoffeeType{
        Americano,
        BlackCoffee,
        Cappuccino,
        Espresso,
        Latte,
        Macchiato,
        Mocha,
        ColdCoffee,
        Affogato,
        ColdBrew,
        FrappuccinoAndFrappe,
        IcedCoffee,
        Mazagran,
        IcedLatte,
        NitroColdBrew,
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long coffee_id;
    private String coffee_name;
    private CoffeeType coffee_type;
    private String legend;
    private Date origin_dt;
    private String origin_place;
    private long times_ordered;
    private long revenue_generated;
    private long coffee_cost;

    @OneToOne
    @JoinColumn(name = "last_order")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "purchased_coffees",nullable = false)
    private Transactions transaction;


    public Coffees(){
        super();
    }

    public Coffees(Long coffee_id, CoffeeType coffee_type, String legend,Date origin_date,String origin_place,long times_ordered,long revenue_generated,long coffee_cost){
        super();
        this.coffee_id = coffee_id;
        this.coffee_type = coffee_type;
        this.legend = legend;
        this.origin_dt = origin_date;
        this.origin_place = origin_place;
        this.times_ordered = times_ordered;
        this.revenue_generated = revenue_generated;
        this.coffee_cost = coffee_cost;
    }

    public Long getCoffeeId(){
        return this.coffee_id;
    }

    public void setCoffeeId(Long coffee_id){
        this.coffee_id = coffee_id;
    }

    public String getCoffeeName(){
        return this.coffee_name;
    }
    
    public void setCoffeeName(String coffee_name){
        this.coffee_name = coffee_name;
    }

    public CoffeeType getCoffeeType(){
        return this.coffee_type;
    }

    public void setCoffeeType(CoffeeType coffee_type){
        this.coffee_type = coffee_type;
    }

    public String getLegend(){
        return this.legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }

    public Date getOriginDate(){
        return this.origin_dt;
    }

    public void setOriginDate(Date origin_dt){
        this.origin_dt = origin_dt;
    }

    public String getOriginPlace(){
        return this.origin_place;
    }

    public void setOriginPlace(String origin_place){
        this.origin_place = origin_place;
    }

    public Long getTimesOrdered(){
        return this.times_ordered;
    }

    public void setTimesOrdered(Long times_ordered){
        this.times_ordered = times_ordered;
    }

    public Long getRevenueGenerated(){
        return this.revenue_generated;
    }

    public void setRevenueGenerated(Long revenue_generated){
        this.revenue_generated = revenue_generated;
    }

    public Long getCoffeeCost(){
        return this.coffee_cost;
    }

    public void setCoffeeCost(Long coffee_cost){
        this.coffee_cost = coffee_cost;
    }
}
