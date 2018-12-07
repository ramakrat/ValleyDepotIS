/* 
Author: Abishek T Ramakrishnan, Bridget Lamaina, Alex Rizzi, Adam Farnsworth
Date: 11/16/2018
Program: Valley Depot IS
Description: Constructors and Member Methods for the Contractor 
(Customers that are related to a business)class 
*/
package ValleyDepotIS;

public class Contractor extends Customer {
    public static int conID = 2;
    public int id;
    public static int conCount = 0;
    public String businessAddress;
    public String businessName;
    public String notesReportCon = "";

    public Contractor (String firstName, String lastName, String address,String phoneNumber, 
            String email, String notes, String businessAddress,String businessName) {
        super(firstName, lastName, address, phoneNumber, email, notes);
        this.businessAddress = businessAddress;
        this.businessName = businessName;

        this.notesReportCon += notes + "\n";
        id = conID;
        conID += 5;
        conCount++;
        }

    public Contractor (String firstName, String lastName, String address, 
            String phoneNumber, String email, String notes, String businessAddress,String businessName, int id, String notesReportCon) {
        super(firstName, lastName, address, phoneNumber, email, notes);
        this.businessAddress = businessAddress;
        this.businessName = businessName;
        this.id = id;
        this.notesReportCon += notesReportCon + "\n" + notes + "\n";
    }
    
    @Override
    public String getNotesReport() {
        return notesReportCon;
    }

    @Override
    public String toString(){
       return("ID: " + this.id + ", Name: " + this.firstName + " " + this.lastName);
    }
}
