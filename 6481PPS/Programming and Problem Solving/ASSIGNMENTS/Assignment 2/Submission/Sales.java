
// ____________________________
// Assignment 2
// © Mukesh Kumar Angrish
// Written by: Mukesh Kumar Angrish (Student ID - 40203596)
// ____________________________

/*
 * This java program defines a Sales class Vaccine with different attributes corresponding to the information regarding a sale.
 * The Sales class also has multiple accessors and mutators in order to provide flexibility during object creation and modification.
 * There are also methods to convert object to string and to compare different Sales objects
 * */

import java.util.Date;
/**
 * This java program defines a Sales class with different attributes corresponding to the information regarding a sale.
 * @author Mukesh Kumar Angrish
 * The Sales class also has multiple accessors and mutators in order to provide flexibility during object creation and modification.
 * There are also methods to convert object to string and to compare different Sales objects
 */
public class Sales implements Comparable<Sales> {
    // Class has the following attributes:
    private String country;
    private String item_type;
    private char order_priority;
    private Date order_date;
    private long order_ID;
    private Date ship_date;
    private int units_sold;
    private float unit_price;
    private float unit_cost;
    private double revenue;
    private double total_cost;
    private double total_profit;
    
    /**
     * default constructor that calls corresponding mutators of the object for different attributes with default values
     */
    public Sales() {
        this.setCountry("");
        this.setItem_type("");
        this.setOrder_priority(' ');
        this.setOrder_date(new Date());
        this.setOrder_ID(0);
        this.setShip_date(new Date());
        this.setUnits_sold(0);
        this.setUnit_price(0);
        this.setUnit_cost(0);
        this.setRevenue(0);
        this.setTotal_cost(0);
        this.setTotal_profit(0);
    }

    /**
     * parameterized constructor that takes multiple attributes and called the corresponding mutators of the object
     * @param country name of the country
     * @param item_type the type of the item in the sale
     * @param order_priority the priority of item order
     * @param order_date the date of order of the item
     * @param order_ID the unique id of the order
     * @param ship_date the shipping date of the order
     * @param units_sold number of units sold of the item
     * @param unit_price price of one unit of item
     * @param unit_cost cost of one unit of item
     * @param revenue revenue from the sale
     * @param total_cost total cost of the sale
     * @param total_profit total profit from the sale
     */
    public Sales(String country, String item_type, char order_priority, Date order_date, long order_ID, Date ship_date, int units_sold, float unit_price, float unit_cost, double revenue, double total_cost, double total_profit) {
        this.setCountry(country);
        this.setItem_type(item_type);
        this.setOrder_priority(order_priority);
        this.setOrder_date(order_date);
        this.setOrder_ID(order_ID);
        this.setShip_date(ship_date);
        this.setUnits_sold(units_sold);
        this.setUnit_price(unit_price);
        this.setUnit_cost(unit_cost);
        this.setRevenue(revenue);
        this.setTotal_cost(total_cost);
        this.setTotal_profit(total_profit);
    }

    /**
     * Copy constructor that takes a previously created Sales object as input and copies its attributes to the current Sales object
     * @param s previously created Sales object
     */
    public Sales(Sales s) {
        // use mutator methods to set the attributes
        this.setCountry(s.getCountry());
        this.setItem_type(s.getItem_type());
        this.setOrder_priority(s.getOrder_priority());
        this.setOrder_date(s.getOrder_date());
        this.setOrder_ID(s.getOrder_ID());
        this.setShip_date(s.getShip_date());
        this.setUnits_sold(s.getUnits_sold());
        this.setUnit_price(s.getUnit_price());
        this.setUnit_cost(s.getUnit_cost());
        this.setRevenue(s.getRevenue());
        this.setTotal_cost(s.getTotal_cost());
        this.setTotal_profit(s.getTotal_profit());
    }

    /**
     * returns the country of sale
     * @return country of sale
     */
    public String getCountry() {
        return country;
    }
    
    /**
     * modifies the country of sale
     * @param country the new country to be set
     */
    public void setCountry(String country) {
        this.country = country;
    }
    
    /**
     * returns the type of item in sale
     * @return the type of item in sale
     */
    public String getItem_type() {
        return item_type;
    }
    
    /**
     * modifies the type of item in sale
     * @param item_type the new type of item to be set
     */
    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }
    
    /**
     * returns the priority of item order
     * @return the priority of item order
     */
    public char getOrder_priority() {
        return order_priority;
    }
    
    /**
     * modifies the priority of item order in sale
     * @param order_priority the priority of item order to be set
     */
    public void setOrder_priority(char order_priority) {
        this.order_priority = order_priority;
    }
    
    /**
     * returns the order date of item in sale
     * @return the order date of item in sale
     */
    public Date getOrder_date() {
        return order_date;
    }
    
    /**
     * modifies the order date of item in sale
     * @param order_date order date of item to be set
     */
    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }
    
    /**
     * returns the unique id of order in sale
     * @return returns the order date of item in sale
     */
    public long getOrder_ID() {
        return order_ID;
    }
    
    /**
     * modifies the order id of item in sale
     * @param order_ID order id to be set
     */
    public void setOrder_ID(long order_ID) {
        this.order_ID = order_ID;
    }
    
    /**
     * returns the shipping date id of order in sale
     * @return the shipping date id of order in sale
     */
    public Date getShip_date() {
        return ship_date;
    }
    
    /**
     * modifies the shipping date of order in sale
     * @param ship_date shipping date of order to be set
     */
    public void setShip_date(Date ship_date) {
        this.ship_date = ship_date;
    }
    
    /**
     * returns the number of units sold in sale
     * @return the number of units sold in sale
     */
    public int getUnits_sold() {
        return units_sold;
    }
    
    /**
     * modifies the number of units sold in sale
     * @param units_sold the number of units sold to be set
     */
    public void setUnits_sold(int units_sold) {
        this.units_sold = units_sold;
    }
    
    /**
     * returns the price of units in sale
     * @return the price of units in sale
     */
    public float getUnit_price() {
        return unit_price;
    }
    
    /**
     * modifies the price of units in sale
     * @param unit_price the price of units to be set
     */
    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }
    
    /**
     * returns the cost of units in sale
     * @return the cost of units in sale
     */
    public float getUnit_cost() {
        return unit_cost;
    }
    
    /**
     * modifies the cost of units in sale
     * @param unit_cost the cost of units to be set
     */
    public void setUnit_cost(float unit_cost) {
        this.unit_cost = unit_cost;
    }
    
    /**
     * returns the revenue from sale
     * @return the revenue from sale
     */
    public double getRevenue() {
        return revenue;
    }
    
    /**
     * modifies the revenue from sale
     * @param revenue the revenue to be set
     */
    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
    
    /**
     * returns the total cost of sale
     * @return the total cost of sale
     */
    public double getTotal_cost() {
        return total_cost;
    }
    
    /**
     * modifies the total cost of sale
     * @param total_cost the total cost to be set
     */
    public void setTotal_cost(double total_cost) {
        this.total_cost = total_cost;
    }
    
    /**
     * returns the total profit from sale
     * @return the total profit from sale
     */
    public double getTotal_profit() {
        return total_profit;
    }
    
    /**
     * modifies the total profit from sale
     * @param total_profit the total profit to be set
     */
    public void setTotal_profit(double total_profit) {
        this.total_profit = total_profit;
    }
    
    /**
     * compares two sales objects
     * @param s the sale object to be compared to
     * @return an integer representing the comparison
     */
    @Override
    public int compareTo(Sales s) {
        if (this.order_ID < s.order_ID) {
            return -1;
        } else if (this.order_ID > s.order_ID) {
            return 1;
        } else {
            return 0;
        }
    }
    
    /**
     * converts the sales object to a string
     * @return the sales object as a string
     */
    @Override
    @SuppressWarnings("deprecation")
	public String toString() {
        // convert order_date to String of format dd/mm/yyyy
        String order_date_str = order_date.getDate() + "/" + (order_date.getMonth() + 1) + "/" + (order_date.getYear() + 1900);
        // convert ship_date to String of format dd/mm/yyyy
        String ship_date_str = ship_date.getDate() + "/" + (ship_date.getMonth() + 1) + "/" + (ship_date.getYear() + 1900);
        return country + "\t" + item_type + "\t" + order_priority + "\t" + order_date_str + "\t" + order_ID + "\t" + ship_date_str + "\t" + units_sold + "\t" + unit_price + "\t" + unit_cost + "\t" + revenue + "\t" + total_cost + "\t" + total_profit;
    }
}
