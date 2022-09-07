package com.company;

public class details {
    String orderDate;
    String region;
    String fname;
    String lname;
    String item;
    String units;
    String unitCost;
    String total;

    public details(String orderDate, String region, String fname, String lname, String item, String units, String unitCost, String total) {
        this.orderDate = orderDate;
        this.region = region;
        this.fname = fname;
        this.lname = lname;
        this.item = item;
        this.units = units;
        this.unitCost = unitCost;
        this.total = total;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(String unitCost) {
        this.unitCost = unitCost;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return
                orderDate + " " +
                region + " " +
                fname + " " +
                lname + " " +
                item + " " +
                units + " " +
                unitCost + " " +
                total;
    }



}
