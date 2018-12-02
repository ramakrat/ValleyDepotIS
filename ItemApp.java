/* 
Author: Abishek T Ramakrishnan, Bridget Lamaina, Alex Rizzi, Adam Farnsworth
Date: 11/16/2018
Program: Valley Depot IS
Description: Menu that lists opetions for Valley Depot IS: allows for options 
listed in the menu and links them together through the classes to display reports
*/
package ValleyDepotIS;
import java.util.*;

public class ItemApp 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int option = 0; 
        ArrayList<Contractor> contractor = new ArrayList<>();
        ArrayList<Customer> customer = new ArrayList<>();
        ArrayList<Item> item = new ArrayList<>();
        ArrayList<Vendor> vendor = new ArrayList<>();
        ArrayList<ArrayList<Sale>> sales = new ArrayList<>();
        
        //pre-population of objects
        
        customer.add(new Customer("Bob", "Smith", "8324 Newark Lane, Harrisonburg, VA, 22801", "5712239034", "smith.bob@gmail.com", ""));
        customer.add(new Customer("Colin", "Skipper", "8324 Newark Lane, Harrisonburg, VA, 22801", "5712239034", "Colin.Skip@gmail.com", ""));
        customer.add(new Customer("Adam", "Rodgers", "2 Rodestraat, Antwerp, Belgium", "3017286228", "adam.rodgers@gmail.com", ""));
        customer.add(new Customer("Sandy", "Smith", "32 Kingsville Drive, Huntingston, WV, 25701", "2403331023", "smithsvillesandy32@hotmail.com", ""));
        customer.add(new Customer("Megan", "Parks", "422 Devon Street, Harrisonburg, VA, 22801", "7032203901", "parks.megan@hotmail.com", ""));
        
        vendor.add(new Vendor("Prestige WorldWide", "10283 SpringField MA 01103", "4133252922"));
        vendor.add(new Vendor("Nike", "2484 Wembly St Houston TX 77036", "8323457634"));
        vendor.add(new Vendor("Burton", "2844 Irish Lane Madison WI 53718", "7156137491"));
        
        item.add(new Item("Shoe",4.5,"Off-Whites",40.5,50.6, 33, vendor.get(0)));
        item.add(new Item("Shirt", 1.5, "Polo", 30.5, 32.5, 200, vendor.get(1)));
        item.add(new Item("Computer", 4.5, "Off-Whites", 40.5, 50.6, 24, vendor.get(1)));
        item.add(new Item("Waterbottle", 1.0, "Dasani", 1.0, 2.3, 320, vendor.get(2)));
        item.add(new Item("Backpack", 2.7, "North Face", 50.5, 60.6, 45, vendor.get(2)));
        item.add(new Item("Chair", 12.5, "Luxury", 40.3, 38.5, 30, vendor.get(2)));
        item.add(new Item("Ovaltine", 4.5,"Delicious Drink", 3.5, 5.6, 1000, vendor.get(1)));
        item.add(new Item("CD", 2.1,"Great Music", 1.2, 1.5, 160, vendor.get(2)));
        item.add(new Item("Poster", 1.0,"Coca-Cola", 15.5, 13.5, 55, vendor.get(0)));
        item.add(new Item("ToothPaste", 1.0, "Minty Fresh", 1.2, 1.6, 75, vendor.get(1)));

        ArrayList<Sale> sales1 = new ArrayList<>();
        sales1.add(new Sale(item.get(0), 4, "4/12/2018", customer.get(0)));
        sales.add(sales1);
        item.get(0).quantAvail -= 4;
        
        ArrayList<Sale> sales2 = new ArrayList<>();
        sales2.add(new Sale(item.get(3), 6, "7/3/2018", customer.get(1)));
        sales.add(sales2);
        item.get(0).quantAvail -= 6;
        
        ArrayList<Sale> sales3 = new ArrayList<>();
        sales3.add(new Sale(item.get(2), 2, "4/21/2018", customer.get(2)));
        sales.add(sales3);
        item.get(0).quantAvail -= 2;
        
        ArrayList<Sale> sales4 = new ArrayList<>();
        sales4.add(new Sale(item.get(5), 7, "5/3/2018", customer.get(0)));
        sales.add(sales4);
        item.get(0).quantAvail -= 7;
        
        ArrayList<Sale> sales5 = new ArrayList<>();
        sales5.add(new Sale(item.get(4), 1, "1/4/2018", customer.get(3)));
        sales.add(sales5);
        item.get(0).quantAvail -= 1;
        
        while(true){
        System.out.println("\n\nValley Depot System");
        System.out.println("================================================");
        System.out.println("Option 1: Create a Customer.");
        System.out.println("Option 2: Edit an existing customers information.");
        System.out.println("Option 3: Create an inventory item.");
        System.out.println("Option 4: Edit an inventory item.");
        System.out.println("Option 5: Enter a sale.");
        System.out.println("Option 6: Print receipt of a sale.");
        System.out.println("Option 7: Create a vendor.");
        System.out.println("Option 8: Edit an existing vendor.");
        System.out.println("Option 9: Print a report.");
        System.out.println("Option 10: Exit the application.");
        System.out.print("\nPlease enter the number option you wish to perform: ");
        try //found on stack overflow to stop input mismatch errors
        {
            option = input.nextInt();
        }
        catch(InputMismatchException exception)
        {
            System.out.println("\nThis is not a valid input. Please try again!\n");
        }
        
       
       //if-else statements for options
       switch(option){
            case 1: 
                System.out.println("Option 1: Create a customer ");
		System.out.println("Option 2: Create a contractor");
		System.out.print("Enter which option you want to perform: ");
		int perform = 0;
                try //found on stack overflow to stop input mismatch errors
                {
                    perform = input.nextInt();
                }
                catch(InputMismatchException exception)
                {
                }
                input.nextLine();
                
                if(perform == 1) {
                    System.out.println("Enter customer’s first name: ");
                    String firstName = input.nextLine(); 
                    System.out.println("Enter customer’s last name: ");
                    String lastName = input.nextLine();
                    System.out.println("Enter customer’s address: ");
                    String address = input.nextLine();
                    System.out.println("Enter customer’s phone number: ");
                    String number = input.nextLine();
                    System.out.println("Enter customer's email address: ");
                    String email = input.nextLine();
                    System.out.println("Enter any notes about the customer: ");
                    String notes = input.nextLine();
                    
                   if(email.contains("@") && number.length() == 10 && !firstName.isEmpty() && !lastName.isEmpty()){
                      customer.add(new Customer(firstName, lastName, address, number, email, notes));
                   }
                   else
                       System.out.println("\nYou have entered incompatible data, please reenter");
                }
                else if (perform == 2) {
                    System.out.println("Enter contractor’s first name: ");
                    String firstName = input.nextLine();
                    System.out.println("Enter contractor’s last name: ");
                    String lastName = input.nextLine();
                    System.out.println("Enter contractor's personal address: ");
                    String address = input.nextLine();
                    System.out.println("Enter contractor's business phone number: ");
                    String number = input.nextLine();
                    System.out.println("Enter contractor's email address: ");
                    String email = input.nextLine();
                    System.out.println("Enter contractor's business address: ");
                    String businessAddress = input.nextLine();
                    System.out.println("Enter contractor's business name: ");
                    String businessName = input.nextLine();
                    System.out.println("Enter any notes about the contractor: ");
                    String notes = input.nextLine();
                    
                        //validation of data
                            if(email.contains("@") && number.length() == 10 && !firstName.isEmpty() && !lastName.isEmpty()
                                    && !businessName.isEmpty()){
                                contractor.add(new Contractor(firstName, lastName, address, number, 
                                    email, businessAddress, businessName, notes));
                            }
                       else
                           System.out.println("\nYou have entered incompatible data, please re-enter");
                }           
                else
                    System.out.println("\nThis is not a valid input. Please try again!");
                break;
            case 2:
                System.out.println("Option 1: Edit a customer");
		System.out.println("Option 2: Edit a contractor");
		System.out.print("Enter which option you want to perform: ");
		
                int action = 0; 
                try //found on stack overflow to stop input mismatch errors
                {
                    action = input.nextInt();
                }
                catch(InputMismatchException exception)
                {
                    System.out.println("\nThis is not a valid input. Please try again!");
                }
                input.nextLine();
                
                if(action == 1) {
                    if(customer.get(0) == null) {
                        System.out.print("There are currently no customers in the database. Please add customers!");
                        break;
                    }  
                        
                    System.out.println("Customers available to edit "
                            + "\nCustotmer ID\tCustomer Name"
                            + "\n===========================");
                        for(int i = 0; i < customer.size(); i++) {
                            System.out.print(customer.get(i).id + "\t\t" + customer.get(i).firstName + " " + customer.get(i).lastName + "\n");
                    }
                            
                    System.out.print("Enter the customer id you want to edit: ");
                    int con = 0;
                    try //found on stack overflow to stop input mismatch errors
                    {
                        con = input.nextInt();
                    }
                    catch(InputMismatchException exception)
                    {
                    }
                    input.nextLine();
                    con = ((con - 6) / 5);
                    System.out.println("Enter customer’s first name: ");
                    String firstName = input.nextLine(); 
                    System.out.println("Enter customer’s last name: ");
                    String lastName = input.nextLine();
                    System.out.println("Enter customer’s address: ");
                    String address = input.nextLine();
                    System.out.println("Enter customer’s phone number: ");
                    String number = input.nextLine();
                    System.out.println("Enter customer's email address: ");
                    String email = input.nextLine();
                    System.out.println("Enter any notes about the customer: ");
                    String notes = input.nextLine();
                    
                    ///validation of data
                    if(email.contains("@") && number.length() == 10 && !firstName.isEmpty() && !lastName.isEmpty()){
                        int id = customer.get(con).id; 
                        customer.set(con, new Customer(firstName, lastName, address, number, email, notes, id));
                    }
                    else
                        System.out.println("\nYou have entered incompatible data, please reenter");
                }
                else if (action == 2) {
                    if(contractor.get(0) == null)
                    {
                        System.out.print("There are currently no contractors in the database. Please add contractors!");
                        break;
                    }    
                    System.out.println("Contractors available to edit"
                            + "\nContractor ID\tContractor Name"
                            + "\n===========================");
                    for(int i = 0; i < contractor.size(); i++) {
                        if(contractor.get(i) != null) {
                            System.out.println(contractor.get(i).id + "\t\t" + contractor.get(i).firstName + " " + contractor.get(i).lastName + "\n");
                            }
                        }
                    System.out.println("Enter the contractor id you want to edit");
                    int con = input.nextInt();
                    input.nextLine();
                    con = ((con - 7) / 5);
                    System.out.println("Enter contractor’s first name: ");
                    String firstName = input.nextLine(); 
                    System.out.println("Enter contractor’s last name: ");
                    String lastName = input.nextLine();
                    System.out.println("Enter the contractor’s address: ");
                    String address = input.nextLine();
                    System.out.println("Enter contractors phone number: ");
                    String number = input.nextLine();
                    System.out.println("Enter contractors email address: ");
                    String email = input.nextLine();
                    System.out.println("Enter the business address: ");
                    String businessAddress = input.nextLine();
                    System.out.println("Enter the business name: ");
                    String businessName = input.nextLine();
                    System.out.println("Enter any notes about the contractor: ");
                    String notes = input.nextLine();
                    
                    //validation of data
                    if(email.contains("@") && number.length() == 10 && !firstName.isEmpty() && !lastName.isEmpty()
                            && !businessName.isEmpty()){
                        int id = contractor.get(con).id;
                        contractor.set(con, new Contractor(firstName, lastName, address, number, 
                        email, businessAddress, businessName, notes, id));
                    }
                    else
                        System.out.println("\nYou have entered incompatible data, please reenter");
                }
                else
                    System.out.println("Not a valid number");
                break;
            case 3: 
                //validation that vendors exist, because items can't exist without vendors
                if(vendor.get(0) == null) {
                    System.out.println("\nThere are no vendors selling items. Please add a vendor!");
                    break;
                }
                System.out.println("Enter the name of the item: ");
                input.nextLine();
                String itemName = input.nextLine();
                System.out.println("Enter the weight of the item: ");
                double weight = input.nextDouble();
                input.nextLine();
                System.out.println("Enter a description for this item: ");
                String description = input.nextLine();
                System.out.println("Enter the price paid for the item: ");
                double vendorPrice = input.nextDouble();
                input.nextLine();
                System.out.println("Enter the for-sale price of the item: ");
                double salePrice = input.nextDouble();
                input.nextLine();
                System.out.println("Enter quantity of items available: ");
                int quantAvail = input.nextInt();
                input.nextLine();
                
                System.out.println("Vendor ID\tVendor Name"
                        + "\n===========================");
                for(int i = 0; i < vendor.size(); i++) {
                    if(vendor.get(i) != null) {
                        System.out.println(vendor.get(i).id + "\t\t" + vendor.get(i).businessName);
                    }
                }
                
                System.out.println("Enter vendor ID, that item was purchased from: ");
                int vendorID = input.nextInt();
                input.nextLine();
                vendorID = ((vendorID-10)/5);
                
                //validation of data
                if(!itemName.isEmpty() && weight > 0 && vendorPrice > 0 && salePrice > 0){
                    item.add(Item.itemCount, new Item(itemName, weight, description, vendorPrice, salePrice, quantAvail, vendor.get(vendorID)));
                }
                else
                     System.out.println("\nYou have entered incompatible data, please reenter");

                
                
               break;
            case 4:
                //validation items exist in database
                System.out.println("");
                if(item.get(0) == null) {
                    System.out.print("There are currently no items in the database. Please add items!");
                    break;
                }
                
                System.out.println("Items Available to Edit"
                        + "\nItem ID\tItem Name");
                System.out.println("===========================");
                for(int i = 0; i < item.size(); i++) {
                    System.out.println(item.get(i).id + "\t" + item.get(i).itemName);
                }
                System.out.println("Enter the Item ID you would like to edit: ");
                int con = 0;
                try //found on stack overflow to stop input mismatch errors
                {
                    con = input.nextInt();
                }
                catch(InputMismatchException exception)
                {
                    System.out.println("\nThis is not a valid input. Please try again!");
                    break;
                }
                input.nextLine();
                con = ((con-8)/5);
                System.out.println("Enter the name of the item: ");
                String itemNa = input.nextLine();
                System.out.println("Enter the weight of the item (i.e. 5.5): ");
                double itemWeight = input.nextDouble();
                input.nextLine();
                System.out.println("Enter a description for this item: ");
                String desc = input.nextLine();
                System.out.println("Enter the price paid for the item (4.50): ");
                double venPrice = input.nextDouble();
                System.out.println("Enter the for-sale price of the item (4.50): ");
                double salp = input.nextDouble();
                System.out.println("Enter the quantity of item available: ");
                int quantAvailable = input.nextInt();
                input.nextLine();
                
                System.out.println("Vendor ID\tVendor Name\n===========================");
                for(int i = 0; i < vendor.size(); i++) {
                    if(vendor.get(i) != null) {
                        System.out.println(vendor.get(i).id + "\t\t" + vendor.get(i).businessName);
                    }
                }
                
                System.out.println("Enter vendor ID, that item was purchased from: ");
                int venID = input.nextInt();
                input.nextLine();
                venID = ((venID-10) / 5);
                
                //validation of data case 4
                if(!itemNa.isEmpty() && itemWeight > 0 &&  venPrice > 0 && salp > 0){
                    int id = item.get(con).id;
                    item.set(con, new Item(itemNa, itemWeight, desc, venPrice, salp, quantAvailable, id, vendor.get(venID)));
                }
                else
                    System.out.println("\nYou have entered incompatible data, please reenter");
                break;

            case 5:
                if(item.get(0) == null) {
                    System.out.print("There are currently no items for sale in the database. Please add items!");
                    break;
                }
                
                if(customer.get(0) == null) {
                    System.out.print("There are currently no customers in the database. Please add customers!");
                    break;
                } 
                
                int affirm = 1;
                int opt = 0;
                System.out.println("\nPress 1 to enter a customer's sale"
                        + "\nPress 2 to enter a contractor's sale"
                        + "\nPlease enter the option you would like to perform: ");
                opt = input.nextInt();
                input.nextLine();

                switch(opt) {
                    case 1:
                        System.out.println("Customer ID\tCustomer Name");
                        System.out.println("=============================");
                        for(int i = 0; i < customer.size(); i++) {
                            if(customer.get(i) != null) {
                                System.out.println(customer.get(i).id + "\t\t" + customer.get(i).firstName + " " + customer.get(i).lastName);
                            }
                        }

                        System.out.print("\nChoose customer id: ");
                        int custID = input.nextInt();
                        input.nextLine();
                        System.out.print("What is the date of the sale: ");
                        String date = input.nextLine();
                        ArrayList<Sale> sale = new ArrayList<>();
                        

                        do {
                            System.out.println("ItemID\tItem Name\tQuantity Available");
                            System.out.println("=======================================");
                            for(int i = 0; i < item.size(); i++) {
                                System.out.printf("\n%2s%-15s%-3d", item.get(i).id, "\t" + item.get(i).itemName, item.get(i).quantAvail);
                            }

                            System.out.println("\n\nChoose item ID: ");
                            int itemN = input.nextInt();
                            input.nextLine();

                            System.out.println("Enter quantity of " + item.get((itemN-8)/5).itemName + " being purchased: ");
                            int quant = input.nextInt();
                            input.nextLine();

                            if(item.get((itemN-8)/5).quantAvail - quant >= 0) {
                                sale.add(new Sale(item.get((itemN - 8)/5), quant, date, customer.get((custID - 6)/5)));
                                item.get((itemN - 8)/5).quantAvail -= quant;
                            }
                            else
                                System.out.println("There are not enough of this item available, please try purchasing less!");
                            System.out.println("Did the customer purchase another product? "
                                    + "\nEnter 1 for Yes"
                                    + "\nEnter 2 for No"
                                    + "\nPlease enter an option: ");
                            affirm = input.nextInt();
                            input.nextLine();
                        } while (affirm == 1);
                        sales.add(sale);
                        break;
                    case 2:
                        System.out.println("Contractor ID\tContractor Name"
                                + "\n===================================");
                        for(int i = 0; i < contractor.size(); i++) {
                                System.out.println(contractor.get(i).id + "\t\t" + contractor.get(i).firstName + " " + contractor.get(i).lastName);
                            }
                        

                        System.out.print("\nChoose contractor id: ");
                        int conID = input.nextInt();
                        input.nextLine();
                        System.out.print("What is the date of the sale: ");
                        String saleDate = input.nextLine();
                        ArrayList<Sale> saleCon = new ArrayList<>();
                        
                        do {
                            System.out.println("Item ID\tItem Name\tQuantity Available");
                            System.out.print("=======================================");
                            for(int i = 0; i < item.size(); i++) {
                                System.out.printf("\n%2s%-15s%-3d", item.get(i).id, "\t" + item.get(i).itemName, item.get(i).quantAvail);
                            }

                            System.out.println("\n\nChoose item ID: ");
                            int itemN = input.nextInt();
                            input.nextLine();

                            System.out.println("Enter quantity of " + item.get((itemN-8)/5).itemName + " being purchased: ");
                            int quant = input.nextInt();
                            input.nextLine();

                            if(item.get((itemN - 8)/5).quantAvail - quant >= 0) {
                                saleCon.add(new Sale(item.get((itemN - 8)/5), quant, saleDate, contractor.get((conID - 7)/5)));
                                item.get((itemN - 8)/5).quantAvail -= quant;
                            }
                            else
                                System.out.println("There are not enough of this item available, please try purchasing less!");
                            System.out.println("Did the contractor purchase another product? "
                                    + "\nEnter 1 for Yes"
                                    + "\nEnter 2 for No"
                                    + "\nPlease enter an option: ");
                            affirm = input.nextInt();
                            } while (affirm == 1);
                        
                        sales.add(saleCon);
                }
                break;
            case 6:
                System.out.println("Sales Occurred"
                        + "\nSale #\tCustomer Name\tDate"
                        + "\n==================================");
                for(int i = 0; i < sales.size(); i++) {
                    for(int j = 0; j<sales.get(i).size(); j++) {
                         //typeC is a boolean data field in the class that allows me to know what constructor I'm using
                    if(sales.get(i).get(0).typeC == true) {
                        System.out.println(sales.get(i).get(0).id + "\t" + sales.get(i).get(0).customer.firstName 
                                + " " + sales.get(i).get(0).customer.lastName + "\t" + sales.get(i).get(0).date);
                        }
                    else if(sales.get(i).get(0).typeC == false) {
                        System.out.println(sales.get(i).get(0).id + "\t" + sales.get(i).get(0).contractor.firstName 
                                + " " + sales.get(i).get(0).contractor.lastName + "\t" + sales.get(i).get(0).date);
                        }
                    }
                }

                System.out.print("Enter the Sale # to view: ");
                int saleNum = input.nextInt();
                saleNum = (saleNum - 9)/5;
                input.nextLine();
                
                System.out.printf("%4s\t\t%-5s\t%-8s\t%-11s", "Item", "Price", "Quantity", "Total Price");
                System.out.println("\n==================================================");
                double total = 0;
                
                for(int i = 0; i < sales.get(saleNum).size(); i++) {
                        System.out.printf("%s\t$%-5.2f\t%-4d\t\t$%-6.2f\n", sales.get(saleNum).get(i).itemSold.itemName
                                , sales.get(saleNum).get(i).itemSold.getSalePrice()
                                , sales.get(saleNum).get(i).quantity
                                , sales.get(saleNum).get(i).itemSold.getSalePrice() * sales.get(saleNum).get(i).quantity);
                        total += sales.get(saleNum).get(i).itemSold.getSalePrice() * sales.get(saleNum).get(i).quantity;
                }
                System.out.println("\nTotal Sales\t\t\t\t$" + total);
                break;
            case 7: 
                    input.nextLine();
                    System.out.println("Enter the vendors name: ");
                    String businessName = input.nextLine();
                    System.out.println("Enter the vendors business address:");
                    String businessAddress = input.nextLine();
                    System.out.println("Enter the vendor's phone number: ");
                    String phoneNumber = input.nextLine();
                    
                    if(!businessName.isEmpty() && phoneNumber.length() == 10){
                        vendor.add(Vendor.venCount, new Vendor(businessName, businessAddress, phoneNumber));
                    }
                    else
                        System.out.println("\nYou have entered incompatible data, please reenter");
               break;
            case 8:
                if(vendor.get(0) == null) {
                    System.out.println("There are no vendors. Please add vendors!");
                    break;
                }
                    
                System.out.println("Vendor's availble for edit");
                    System.out.println("Vendor ID\tVendor Name");
                    System.out.println("=============================");
                    for(int i = 0; i <= Vendor.venCount; i++){
                        if(vendor.get(i) != null) {
                        System.out.println(vendor.get(i).id + "\t\t\t" + vendor.get(i).businessName);                            
                        }

                    }
                    System.out.println("Enter the ID of the vendor you want to edit");
                    int number;
                    try //found on stack overflow to stop input mismatch errors
                    {
                        number = input.nextInt();
                        System.out.println();
                    }
                    catch(InputMismatchException exception)
                    {
                        System.out.println("\nThis is not a valid input. Please try again!\n");
                        break;
                    }
                    input.nextLine();
                    number = ((number - 10) / 5);
                    System.out.println("Enter the vendors name: ");
                    String vendorName = input.nextLine();
                    System.out.println("Enter the vendors business address:");
                    String vendorAddress = input.nextLine();
                    System.out.println("Enter the vendor's phone number: ");
                    String vendorNumber = input.nextLine();
                    
                    if(!vendorName.isEmpty() && vendorNumber.length() == 10){
                        int id = vendor.get(number).id;
                        vendor.set(number, new Vendor(vendorName, vendorAddress, vendorNumber, id));
                    }
                    else
                        System.out.println("\nYou have entered incompatible data, please reenter");
               break;

            case 9:
                System.out.println("\nOption 1: Print purchase history for any given customer"
                        + "\nOption 2: Print purchase history for any given item"
                        + "\nOption 3: Print currenty inventory levels for all items"
                        + "\nPlease enter the number option you wish to perform: ");
                
                int choice = input.nextInt();
                
                if(item.get(0) == null) {
                    System.out.print("There are currently no items in the database. Please add items!");
                    break;
                }  
                
                switch(choice){
                    case 1:
                        if(customer.get(0) == null) {
                            System.out.print("\nThere are currently no customers in the database. Please add customers!");
                            break;
                        } 
                        
                        System.out.println("\nPress 1 to view customer purchase history"
                            + "\nPress 2 to view contractor purchase history"
                            + "\nEnter your selection: ");
                        int optC = input.nextInt();
                        input.nextLine();
                        switch(optC) {
                            case 1:
                                System.out.println("Customer List");
                                System.out.println("====================");
                                for(int i = 0; i < customer.size(); i++){
                                    System.out.println(customer.get(i).id + "\t" + customer.get(i).firstName + " " + customer.get(i).lastName);
                                }
                                System.out.print("\nPlease enter the id of the customer you want to print the purchase history for: ");
                                int ph = input.nextInt();
                                input.nextLine();
                                System.out.println("Customer Name\tItemName\tQuantity\tDate\tPrice");
                                System.out.println("=============================================================");
                                for(int i = 0; i < sales.size(); i++){
                                    for(int j = 0; j < sales.get(i).size(); j++){
                                        if(sales.get(i).get(j) != null) {
                                            if(sales.get(i).get(j).typeC == true && ph == sales.get(i).get(j).customer.id) {
                                                System.out.println(sales.get(i).get(j).customer.firstName + " " + sales.get(i).get(j).customer.lastName 
                                                        + "\t" + sales.get(i).get(j).itemSold.itemName +"\t" + sales.get(i).get(j).quantity + "\t" 
                                                        + sales.get(i).get(j).date + "\t" + sales.get(i).get(j).quantity * sales.get(i).get(j).itemSold.getSalePrice());
                                            }
                                        }
                                    }
                                }    
                            break;
                            case 2:
                                if(contractor.get(0) == null) {
                                    System.out.print("There are currently no contractors in the database. Please add customers!");
                                    break;
                                } 
                                
                                System.out.println("Contractor List");
                                System.out.println("====================");
                                for(int i = 0; i < contractor.size(); i++){
                                    System.out.println(contractor.get(i).id + "\t" + contractor.get(i).firstName + " " + contractor.get(i).lastName);
                                }
                                
                                System.out.println("Please enter the id of the contractor you want to print the purchase history for: ");
                                int conID = input.nextInt();
                                input.nextLine();
                                System.out.println("Contractor Name\tItemName\tQuantity\tDate\tPrice");
                                System.out.println("=============================================================");
                                for(int i = 0; i < sales.size(); i++){
                                    for(int j = 0; j < sales.get(i).size(); j++){
                                        if(sales.get(i).get(j) != null) {
                                            if(sales.get(i).get(j).typeC == false && conID == sales.get(i).get(j).contractor.id){
                                            System.out.println(sales.get(i).get(j).contractor.firstName + " " + sales.get(i).get(j).contractor.lastName + "\t"
                                                    + sales.get(i).get(j).itemSold.itemName +"\t " + sales.get(i).get(j).quantity + "\t" 
                                                    + sales.get(i).get(j).date + "\t" + sales.get(i).get(j).quantity * sales.get(i).get(j).itemSold.getSalePrice());
                                            }
                                        }
                                    }
                                } 
                            }
                            break;
                    case 2:
                        System.out.println("\nItem History For A Given Item:");
                        System.out.println("Item ID \t Item Name");
                        System.out.println("=======================================");
                        
                        for (int i = 0;i < item.size(); i++)
                        {
                            System.out.println(item.get(i).id + "\t\t" + item.get(i).itemName);
                        }
                        
                        System.out.println("Enter an ItemID for the item you would like to view: ");
                        int itemId = input.nextInt();
                        input.nextLine();
                        
                        System.out.println("Item ID\tItem Name\tCustomer Name\tDate\tQuantity");
                        System.out.println("====================================================");
                        for(int i = 0; i < sales.size(); i++) {
                            if(sales.get(i).get(0) != null) {
                                for(int j = 0; j < sales.get(i).size(); j++){
                                    if (sales.get(i).get(j) != null && sales.get(i).get(j).itemSold.id == itemId) {
                                        if(sales.get(i).get(j).typeC == true) {
                                            System.out.println(sales.get(i).get(j).itemSold.id + "\t" 
                                                    + sales.get(i).get(j).itemSold.itemName + "\t"
                                                    + sales.get(i).get(j).customer.firstName + " " 
                                                    + sales.get(i).get(j).customer.lastName + "\t"
                                                    + sales.get(i).get(j).date + "\t"
                                                    + sales.get(i).get(j).quantity);                                            
                                        }
                                        else {
                                            System.out.println(sales.get(i).get(j).itemSold.id + "\t" 
                                                        + sales.get(i).get(j).itemSold.itemName + "\t"
                                                        + sales.get(i).get(j).contractor.firstName + " " 
                                                        + sales.get(i).get(j).contractor.lastName + "\t"
                                                        + sales.get(i).get(j).date + "\t"
                                                        + sales.get(i).get(j).quantity);    
                                        }
                                    }
                                }
                            }
                        }  
                        break;
                    case 3: 
                        System.out.println("Current Inventory Levels for All Items: ");
                        System.out.println("Item Name\t\tInventory Levels");
                        System.out.print("========================================");
                            for(int i = 0; i < Item.itemCount; i++){
                                System.out.printf("\n%-15s\t\t%-7d", item.get(i).itemName, item.get(i).quantAvail);
                            }
                        break;
                }
                break; 
            case 10:
                System.out.println("\nThank you for using Valley Depot System!");
                System.exit(0);
               
            default: System.out.println("\nYou have not entered an appropriate option number");
            }
        }
    }
}

    
