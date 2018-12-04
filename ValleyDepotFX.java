package ValleyDepotIS;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;

public class ValleyDepotFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        ArrayList<Contractor> contractor = new ArrayList<>();
        ArrayList<Customer> customer = new ArrayList<>();
        ArrayList<Item> item = new ArrayList<>();
        ArrayList<Vendor> vendor = new ArrayList<>();
        ArrayList<ArrayList<Sale>> sales = new ArrayList<>();
        
        //observable array lists
        ObservableList<Contractor> contractorList = FXCollections.observableList(contractor); 
        ObservableList<Customer> customerList = FXCollections.observableList(customer);
        ObservableList<Item> itemList = FXCollections.observableList(item); 
        ObservableList<Vendor> vendorList = FXCollections.observableList(vendor); 
        ObservableList<ArrayList<Sale>> saleList = FXCollections.observableList(sales); 
        
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
        
        Label title = new Label("Valley Depot System");
        Button btn1 = new Button("Manage Customers");
        Label title1 = new Label("1.) ");
        Button btn2 = new Button("Manage Inventory Items");
        Label title2 = new Label("2.) ");
        Button btn3 = new Button("Create a Sale");
        Label title3 = new Label("3.) ");
        Button btn4 = new Button("Print Sales Report");
        Label title4 = new Label("4.) ");
        Button btn5 = new Button("Manage Vendors");
        Label title5 = new Label("5.) ");
        Button btn6 = new Button("Print Reprot");
        Label title6 = new Label("6.) ");
        Button btn7 = new Button("Exit System");
        Label title7 = new Label("7.) ");
        
        //create 1st main menu window
        GridPane primaryPane = new GridPane();
        primaryPane.setAlignment(Pos.CENTER);
        primaryPane.add(title, 1, 0);
        primaryPane.add(title1, 0, 1);
        primaryPane.add(btn1, 1, 1);
        primaryPane.add(title2, 0, 2);
        primaryPane.add(btn2, 1, 2);
        primaryPane.add(title3, 0, 3);
        primaryPane.add(btn3, 1, 3);
        primaryPane.add(title4, 0, 4);
        primaryPane.add(btn4, 1, 4);
        primaryPane.add(title5, 0, 5);
        primaryPane.add(btn5, 1, 5);
        primaryPane.add(title6, 0, 6);
        primaryPane.add(btn6, 1, 6);
        primaryPane.add(title7, 0, 7);
        primaryPane.add(btn7, 1, 7);
        
        //create scenes
        Scene primaryScene = new Scene(primaryPane, 400, 400);
        
        //set the properties for your Stage, nest your scene within your stage
        //and cause your stage to appear. 
        primaryStage.setTitle("ValleyDepotSystem");
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        primaryPane.setHgap(10);
        primaryPane.setVgap(10);
        
        //objects for 1st window for manage customers
        Button createCust = new Button("Create New Customer");
        Button editCust = new Button("Edit Customer");
        Button createCon = new Button("Create New Contractor");
        Button editCon = new Button("Edit Contractor");
        Button main = new Button("Return to Main Menu");
        GridPane custPane1 = new GridPane();
        Label lbl = new Label("1.)");
        Label lbl2 = new Label("2.)");
        Label lbl3 = new Label("3.)");
        Label lbl4 = new Label("4.)");
        Label lbl5 = new Label("5.)");
        custPane1.add(createCust, 1, 0);
        custPane1.add(editCust, 1, 1);
        custPane1.add(createCon, 1, 2);
        custPane1.add(editCon, 1, 3);
        custPane1.add(main, 1, 4);
        custPane1.add(lbl, 0, 0);
        custPane1.add(lbl2, 0, 1);
        custPane1.add(lbl3, 0, 2);
        custPane1.add(lbl4, 0, 3);
        custPane1.add(lbl5, 0, 4);
        Scene scene1 = new Scene(custPane1, 400, 400);
        
        //manage customers button
        btn1.setOnAction(e -> {
            primaryStage.setTitle("Manage Customers");
            primaryStage.setScene(scene1);
            primaryStage.show();
            custPane1.setHgap(10);
            custPane1.setVgap(10);
        });
         
        main.setOnAction(e -> {
            primaryStage.setScene(primaryScene);
            primaryStage.show();
        });
        
        //objects for create customer window
        GridPane createCustPanel = new GridPane();
        Button addCustomer = new Button("Add Customer");
        Label lblFName = new Label("First Name");
        Label lblLName = new Label("Last Name");
        Label lblAdd = new Label("Address");
        Label lblPhone = new Label("Phone Number");
        Label lblEmail = new Label("Email");
        Label lblNotes = new Label("Additional Notes");
        TextField txtFName = new TextField();
        TextField txtLName = new TextField();
        TextField txtAdd = new TextField();
        TextField txtPhone = new TextField();
        TextField txtEmail = new TextField();
        TextField txtNotes = new TextField();
        Text success = new Text("Success. You have added a new customer.");
        createCustPanel.add(lblFName, 0, 0);
        createCustPanel.add(lblLName, 0, 1);
        createCustPanel.add(lblAdd, 0, 2);
        createCustPanel.add(lblPhone, 0, 3);
        createCustPanel.add(lblEmail, 0, 4);
        createCustPanel.add(lblNotes, 0, 5);
        createCustPanel.add(txtFName, 1, 0);
        createCustPanel.add(txtLName, 1, 1);
        createCustPanel.add(txtAdd, 1, 2);
        createCustPanel.add(txtPhone, 1, 3);
        createCustPanel.add(txtEmail, 1, 4);
        createCustPanel.add(txtNotes, 1, 5);
        createCustPanel.add(addCustomer, 0, 9);
        addCustomer.setAlignment(Pos.CENTER);
        Scene createCustomer = new Scene(createCustPanel, 400, 400);
        Alert errorAlert = new Alert(AlertType.ERROR);
        
        createCust.setOnAction(e -> {
            txtFName.setText(null);
            txtLName.setText(null);
            txtAdd.setText(null);
            txtPhone.setText(null);
            txtEmail.setText(null);
            txtNotes.setText(null);
            primaryStage.setTitle("Create Customer");
            primaryStage.setScene(createCustomer);
            primaryStage.show();
            createCustPanel.setHgap(10);
            createCustPanel.setVgap(10);
        });    
            
         addCustomer.setOnAction(e -> {
            String FName = txtFName.getText();
            String LName = txtLName.getText();
            String Add = txtAdd.getText();
            String Phone = txtPhone.getText();
            String Email = txtEmail.getText();
            String Notes = txtNotes.getText();
            
            if(Email.contains("@") && Phone.length() == 10 && !FName.isEmpty() && !LName.isEmpty()) {
                customer.add(new Customer(FName, LName, Add, Phone, Email, Notes));
                primaryStage.setScene(primaryScene);
                primaryStage.show();
            }
            else {
                errorAlert.setHeaderText("Input not valid");
                errorAlert.setContentText("Please Re-Enter Customer Information");
                errorAlert.setResizable(true);
                errorAlert.getDialogPane().setPrefSize(400, 400);
                errorAlert.showAndWait();
            }
        
        }); 
        
        //option for creating a new contractor
        GridPane createConPanel = new GridPane();
        Button addContractor = new Button("Add Contractor");
        Label conFirst = new Label("First Name");
        Label conLast = new Label("Last Name");
        Label conAdd = new Label("Address");
        Label conPhone = new Label("Phone Number");
        Label conEmail = new Label("Email");
        Label conBusAdd = new Label("Business Address");
        Label conBusName = new Label("BusinessName");
        Label conNotes = new Label("Contractor Notes");
        Text successCon = new Text("Success. You have added a new contractor.");
        TextField txtConFirst = new TextField();
        TextField txtConLast = new TextField();
        TextField txtConAdd = new TextField();
        TextField txtConPhone = new TextField();
        TextField txtConEmail = new TextField();
        TextField txtConNotes = new TextField();
        TextField txtConBusAdd = new TextField();
        TextField txtConBusName = new TextField();
        createConPanel.add(conFirst, 0, 0);
        createConPanel.add(conLast, 0, 1);
        createConPanel.add(conAdd, 0, 2);
        createConPanel.add(conPhone, 0, 3);
        createConPanel.add(conEmail, 0, 4);
        createConPanel.add(conBusAdd, 0, 6);
        createConPanel.add(conBusName, 0, 7);
        createConPanel.add(txtConFirst, 1, 0);
        createConPanel.add(txtConLast, 1, 1);
        createConPanel.add(txtConAdd, 1, 2);
        createConPanel.add(txtConPhone, 1, 3);
        createConPanel.add(txtConEmail, 1, 4);
        createConPanel.add(txtConNotes, 1, 5);
        createConPanel.add(conNotes, 0, 5);
        createConPanel.add(txtConBusAdd, 1, 6);
        createConPanel.add(txtConBusName, 1, 7);
        createConPanel.add(addContractor, 0, 9);
        addContractor.setAlignment(Pos.CENTER);
        Scene createContractor = new Scene(createConPanel, 400, 400);
        Alert errorAlertCon = new Alert(AlertType.ERROR);
        
        createCon.setOnAction(e -> {
            txtConFirst.setText(null);
            txtConLast.setText(null);
            txtConAdd.setText(null);
            txtConPhone.setText(null);
            txtConEmail.setText(null);
            txtConNotes.setText(null);
            txtConBusAdd.setText(null);
            txtConBusName.setText(null);
            primaryStage.setTitle("Create Contractor");
            primaryStage.setScene(createContractor);
            primaryStage.show();
            createConPanel.setHgap(10);
            createConPanel.setVgap(10);
        });    
        
        addContractor.setOnAction(e -> {
            String FName = txtConFirst.getText();
            String LName = txtConLast.getText();
            String Add = txtConAdd.getText();
            String Phone = txtConPhone.getText();
            String Email = txtConEmail.getText();
            String Notes = txtConNotes.getText();
            String busAdd = txtConBusAdd.getText();
            String busName = txtConBusName.getText();
            
            if(Email.contains("@") && Phone.length() == 10 && !FName.isEmpty() && !LName.isEmpty()) {
                contractor.add(new Contractor(FName, LName, Add, Phone, Email, Notes, busAdd, busName));
                primaryStage.setScene(primaryScene);
                primaryStage.show();
            }
            else {
                errorAlertCon.setHeaderText("Input not valid");
                errorAlertCon.setContentText("Please ReEnter Contractor Information");
                errorAlertCon.setResizable(true);
                errorAlertCon.getDialogPane().setPrefSize(400, 400);
                errorAlertCon.showAndWait();
            }
        });
        
         //manage sale 
        Label saleLabel = new Label("Create Sales System");
        Button createCusSale = new Button("Create new Customer Sale");
        Button createConSale = new Button("Create a new Contractor Sale");
        GridPane salePane1 = new GridPane();
        Label sale1 = new Label("1.)");
        Label sale2 = new Label("2.)");
        Label sale3 = new Label("3.)");
        Button exit = new Button("Return to Main Menu");
        salePane1.add(saleLabel, 1, 0);
        salePane1.add(createCusSale, 1, 1);
        salePane1.add(createConSale, 1, 2);
        salePane1.add(sale1, 0, 1);
        salePane1.add(sale2, 0, 2);
        salePane1.add(sale3, 0, 3);
        salePane1.add(exit, 1,3);
        Scene scene2 = new Scene(salePane1, 400, 400);
        
        
        //manage inventory button
        btn3.setOnAction(e -> {
            primaryStage.setTitle("Create Sale Item");
            primaryStage.setScene(scene2);
            primaryStage.show();
            salePane1.setHgap(10);
            salePane1.setVgap(10);
        });
        createCusSale.setOnAction(e -> {
            
        });
        
        createConSale.setOnAction(e -> {
            
        });
        
         exit.setOnAction(e -> {
              primaryStage.setScene(primaryScene);
              primaryStage.show();
          });
        
            //initial item menu options
            GridPane inventoryPane2 = new GridPane();
            Button createItem = new Button("Create new item");
            Button editItem = new Button("Edit existing item");
            Button leave = new Button("Return to Main Menu");
            Label num1 = new Label("1.)");
            Label num2 = new Label("2.)");
            Label num3 = new Label("3.)");
            inventoryPane2.add(createItem, 1, 1);
            inventoryPane2.add(editItem, 1, 2);
            inventoryPane2.add(num1, 0, 1);
            inventoryPane2.add(num2, 0, 2);
            inventoryPane2.add(num3, 0, 3);
            inventoryPane2.add(leave, 1, 3);
            leave.setAlignment(Pos.CENTER_RIGHT);
            Scene invScene = new Scene(inventoryPane2, 400,400);
          
        //create an inventory item
        Label inventoryLabel = new Label("Manage Inventory System");
        GridPane inventoryPane1 = new GridPane();
        Label inv1 = new Label("Item Name ");
        TextField name = new TextField();
        Label inv2 = new Label("Item Weight");
        TextField weight = new TextField();
        Label inv3 = new Label("Item Description");
        TextField description = new TextField();
        Label inv4 = new Label("Item Price");
        Label inv5 = new Label("Item For-Sale Price");
          TextField price = new TextField();
          TextField forSale = new TextField();
          Label inv6 = new Label("Quantity of Items Available");
          TextField quantity = new TextField();
          Button createInvItem = new Button("Add Inventory Item");
          inventoryPane1.add(createInvItem, 0, 7);
          inventoryPane1.add(inventoryLabel, 1, 0);
          inventoryPane1.add(inv1, 0, 1);
          inventoryPane1.add(name, 1, 1);
          inventoryPane1.add(inv2, 0, 2);
          inventoryPane1.add(weight, 1, 2);
          inventoryPane1.add(inv3, 0, 3);
          inventoryPane1.add(description, 1, 3);
          inventoryPane1.add(inv4, 0, 4);
          inventoryPane1.add(price, 1, 4);
          inventoryPane1.add(inv5, 0, 5);
          inventoryPane1.add(forSale, 1, 5);
          inventoryPane1.add(inv6, 0, 6);
          inventoryPane1.add(quantity, 1, 6);
          Scene scene3 = new Scene(inventoryPane1, 400, 400);
          //Alert error = new Alert(AlertType.ERROR);
          //create a sale button
          btn2.setOnAction(e -> {
            primaryStage.setTitle("Item System");
            primaryStage.setScene(invScene);
            primaryStage.show();
            inventoryPane2.setHgap(10);
            inventoryPane2.setVgap(10);
        });
          
         //add a sale button
         createItem.setOnAction(e -> {
           primaryStage.setTitle("Add Item System");
           primaryStage.setScene(scene3);
           primaryStage.show();
           inventoryPane1.setHgap(10);
           inventoryPane1.setVgap(10);
           
         });
         createInvItem.setOnAction(e -> {
             
         });
        
        
          //button to return to main menu
          leave.setOnAction(e -> {
              primaryStage.setScene(primaryScene);
              primaryStage.show();
          });
          
        //print a sale receipt
           Label receiptLabel = new Label("Sales Receipt");
           GridPane receiptPane1 = new GridPane();
           Button menu = new Button("Return to Main Menu");
           receiptPane1.add(menu, 0,8);
           menu.setAlignment(Pos.CENTER_RIGHT);
           Scene scene4 = new Scene(receiptPane1, 400, 400);

           //print sale receipt button
           btn4.setOnAction(e -> {
               primaryStage.setTitle("Sales Receipt");
               primaryStage.setScene(scene4);
               primaryStage.show();
               receiptPane1.setHgap(10);
               receiptPane1.setVgap(10);
           });
           
           //return to main menu button
           
            menu.setOnAction(e -> {
                 primaryStage.setScene(primaryScene);
                 primaryStage.show();
            });  
        //manage vendor items
        Label vendorLabel = new Label("Manage Vendors");
        Button createVendor = new Button("Create new Vendor");
        Button editVendor = new Button("Edit a Vendor");
        GridPane vendorPane1 = new GridPane();
        Label ven1 = new Label("1.)");
        Label ven2 = new Label("2.)");
        Label ven3 = new Label("3.)");
        Button dismiss = new Button("Return to Main Menu");
        vendorPane1.add(vendorLabel, 1, 0);
        vendorPane1.add(createVendor, 1, 1);
        vendorPane1.add(editVendor, 1, 2);
        vendorPane1.add(ven1, 0, 1);
        vendorPane1.add(ven2, 0, 2);
        vendorPane1.add(ven3, 0, 3);
        vendorPane1.add(dismiss, 1,3);
        Scene scene5 = new Scene(vendorPane1, 400, 400);
        
        //create new vendor button and window
        GridPane vendorPane2 = new GridPane();
        Label venName = new Label("Vendor's Name");
        Label venAddress = new Label("Vendor's Address");
        Label venPhone = new Label("Vendor's Phone Number");
        Button addVendor = new Button("Add Vendor");
        TextField txtName = new TextField();
        TextField txtAddress = new TextField();
        TextField txtPhone = new TextField();
        vendorPane2.add(venName, 0, 1);
        vendorPane2.add(venAddress, 0, 2);
        vendorPane2.add(venPhone, 0, 3);
        vendorPane2.add(txtName, 1, 1);
        vendorPane2.add(txtAddress, 1,2);
        vendorPane2.add(txtPhone, 1, 3);
        vendorPane2.add(addVendor, 0, 5);
        addVendor.setAlignment(Pos.CENTER_RIGHT);
        Scene vendorScene = new Scene(vendorPane2, 400, 400);
        
        
        //manage inventory button
        btn5.setOnAction(e -> {
            primaryStage.setTitle("Manage Inventory Items");
            primaryStage.setScene(scene5);
            primaryStage.show();
            vendorPane1.setHgap(10);
            vendorPane1.setVgap(10);
        });
        createVendor.setOnAction(e -> {
            txtName.setText(null);
            txtAddress.setText(null);
            txtPhone.setText(null);
            primaryStage.setTitle("Create a New Vendor");
            primaryStage.setScene(vendorScene);
            primaryStage.show();
            vendorPane2.setHgap(10);
            vendorPane2.setVgap(10);
        });
        //add vendor to array list button
        addVendor.setOnAction(e -> {
          String vendorName = txtName.getText();  
          String vendorAdd = txtAddress.getText();
          String vendorPhone = txtPhone.getText();
          if(!vendorName.isEmpty() && vendorPhone.length() == 10){
                vendor.add(Vendor.venCount, new Vendor(vendorName, vendorAdd, vendorPhone));
                primaryStage.setScene(primaryScene);
                primaryStage.show();
            }
          else {
                errorAlert.setHeaderText("Input not valid");
                errorAlert.setContentText("Please enter vendor information again");
                errorAlert.setResizable(true);
                errorAlert.getDialogPane().setPrefSize(400, 400);
                errorAlert.showAndWait();
                }
          
        });
        
        //return back to main menu from vendor
         dismiss.setOnAction(e -> {
              primaryStage.setScene(primaryScene);
              primaryStage.show();
          });
        
         //print report
        Label reportLabel = new Label("Print Report");
        Button createCusHis = new Button("Purchase History Of A Customer Report");
        Button createConHis = new Button("Purchase History Of A Contractor Report");
        Button createItemHis = new Button("Purchase History For Any Given Item Report");
        Button createInvLevel = new Button("Inventory Item Levels Report");
        GridPane reportPane1 = new GridPane();
        Label report1 = new Label("1.)");
        Label report2 = new Label("2.)");
        Label report3 = new Label("3.)");
        Label report4 = new Label("4.)");
        Label report5 = new Label("5.)");
        Button after = new Button("Return to Main Menu");
        reportPane1.add(reportLabel, 1, 0);
        reportPane1.add(createCusHis, 1, 1);
        reportPane1.add(createConHis, 1, 2);
        reportPane1.add(createItemHis, 1, 3);
        reportPane1.add(createInvLevel, 1, 4);
        reportPane1.add(report1, 0, 1);
        reportPane1.add(report2, 0, 2);
        reportPane1.add(report3, 0, 3);
        reportPane1.add(report4, 0, 4);
        reportPane1.add(report5, 0, 5);
        reportPane1.add(after, 1,5);
        Scene scene6 = new Scene(reportPane1, 400, 400);
        
        //manage vendor button
        btn6.setOnAction(e -> {
            primaryStage.setTitle("Print a Report");
            primaryStage.setScene(scene6);
            primaryStage.show();
            reportPane1.setHgap(10);
            reportPane1.setVgap(10);
        });
        
        //return to main menu button
         after.setOnAction(e -> {
              primaryStage.setScene(primaryScene);
              primaryStage.show();
          });
         
        //exit system
        btn7.setOnAction(e -> {
            System.out.println("Thank you for using The Valley Depot System!");
            primaryStage.close();
        });
         
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }
    
}
