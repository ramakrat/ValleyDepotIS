/* 
Author: Abishek T Ramakrishnan, Bridget Lamaina, Alex Rizzi, Adam Farnsworth
Date: 11/16/2018
Program: Valley Depot IS
Description: Constructors and Member Methods for Vendor (people selling items)objects
*/
package ValleyDepotIS;

public class Vendor {
    public static int vendorID = 5;
    public int id;
    public static int venCount = 0;
    public String businessName;
    public String businessAddress;
    public String phoneNumber;
    
    public Vendor(String businessName, String businessAddress, String phoneNumber){
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.phoneNumber = phoneNumber;
        
        id = vendorID;
        vendorID += 5;
        venCount++;
    }
    
    public Vendor(String businessName, String businessAddress, String phoneNumber, int id){
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }
    
    public String toString(){
        return ("ID: " + this.id + ", Vendor Name: " + this.businessName);
    }
}
