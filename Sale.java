/* 
Author: Abishek T Ramakrishnan, Bridget Lamaina, Alex Rizzi, Adam Farnsworth
Date: 11/16/2018
Program: Valley Depot IS
Description: Constructors and Member Methods for Sale 
(when an item is sold and associated information) objects
*/
package ValleyDepotIS;

public class Sale {
// this class will allow you to record which Customer purchased which Items
    //at what quantities, and on a certain date. The class should allow you to print a
    //receipt for any sale. 
    public static int saleID = 4;
    public int id;
    public static int saleCount = 0;
    public Item itemSold;
    public int quantity;
    public String date;
    public Customer customer;
    public Contractor contractor;
    public boolean typeC;
    
    public Sale(Item itemSold, int quantity, String date, Customer customer){
        this.itemSold = itemSold;
        this.quantity = quantity;
        this.date = date;
        this.customer = customer;
        this.typeC = true;
        
        saleID += 5;
        id = saleID;
        saleCount++;
    }
    
    public Sale(Item itemSold, int quantity, String date, Contractor contractor){
        this.itemSold = itemSold;
        this.quantity = quantity;
        this.date = date;
        this.contractor = contractor;
        this.typeC = false;
        
        saleID += 5;
        id = saleID;
        saleCount++;
    }
    
    //memeber method
    @Override
    public String toString(){
       return ("Customer: " + customer.firstName + " " + customer.lastName + "\nItem Sold: " + itemSold.itemName + 
                   "\nPrice: $" + itemSold.getSalePrice() + "\nQuantity: " + quantity + 
                   "\nSale Total: $" + (quantity * itemSold.getSalePrice()) + "\n");
    }
}
