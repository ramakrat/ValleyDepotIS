/* 
Author: Abishek T Ramakrishnan, Bridget Lamaina, Alex Rizzi, Adam Farnsworth
Date: 11/16/2018
Program: Valley Depot IS
Description: Constructors and Member Methods for Item (things being sold) objects
*/
package ValleyDepotIS;

public class Item {
//Instance objects of item class
    public static int itemID = 3;
    public int id;
    public static int itemCount = 0;
    public String itemName; 
    public double weight;
    public String description;
    public double vendorPrice;
    private double salePrice;
    public int quantAvail;
    public Vendor vendor;
    
    //Constructor 
    public Item(String itemName, double weight, String description, double vendorPrice, double salePrice, int quantAvail, Vendor vendor){
        this.itemName = itemName;
        this.weight = weight;
        this.description = description;
        this.vendorPrice = vendorPrice;
        this.salePrice = salePrice;
        this.quantAvail = quantAvail;
        this.vendor = vendor;
        
        itemID += 5;
        id = itemID ;
        itemCount++;
    }
    
    public Item(String itemName, double weight, String description, double vendorPrice, double salePrice, int quantAvail, int id, Vendor vendor){
        this.itemName = itemName;
        this.weight = weight;
        this.description = description;
        this.vendorPrice = vendorPrice;
        this.salePrice = salePrice;
        this.quantAvail = quantAvail;
        this.vendor = vendor;
        this.id = id;
    }
            
    
    public double getSalePrice()
    {
        return this.salePrice;
    }        
    
    public boolean setPrice(double newPrice)
    {
        if(newPrice > 0)
        {
            salePrice = newPrice;
            return true;
        }
        
        else
        {
            return false;
        }
    }
     
    @Override
    public String toString(){
        return("ID: " + this.id + ", Item Name: " + this.itemName + ", Quantity: " + this.quantAvail);
    }
}
