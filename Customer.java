/* 
Author: Abishek T Ramakrishnan, Bridget Lamaina, Alex Rizzi, Adam Farnsworth
Date: 11/16/2018
Program: Valley Depot IS
Description: Constructors and Member Methods for Customer (people buying items)Class
*/
package ValleyDepotIS;

public class Customer 
{
    //superclass for contractor
    //datafields
    public static int custID = 1;
    public int id;
    public static int custCount = 0;
    public String firstName;
    public String lastName;
    public String address;
    public String phoneNumber; 
    public String email;
    public String notes;
   
    public Customer(String firstName, String lastName, String address, String phoneNumber, String email, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.notes = notes;
        //only commenting id math here, so each class starts at a number 1-5
        //each time they increment, it is by 5 so they never overlap and this is infinitely scalable
        //can be applied if we switch our current process of arrays to arraylists
        custID += 5;
        id = custID;
        custCount++;
        }

    public Customer(String firstName, String lastName, String address, String phoneNumber, String email, String notes, int id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.notes = notes;
        this.id = id;
    }
    
    @Override
    public String toString(){
        return("ID: " + this.id + ", " + this.firstName + " " + this.lastName);
    }
}
