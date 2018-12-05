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
import javafx.collections.*;

public class FXApplication extends Application {

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
        Button btn4 = new Button("Print Sales Receipt");
        Label title4 = new Label("4.) ");
        Button btn5 = new Button("Manage Vendors");
        Label title5 = new Label("5.) ");
        Button btn6 = new Button("Print Report");
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
        
        //ERRROR STUFF DON'T  TOUCH
        Button btnError = new Button("OK");
        GridPane errorPane = new GridPane();
        Label lblError = new Label("Error: Incompatible data, please try again.");
        errorPane.add(lblError, 0 , 2);
        errorPane.add(btnError, 0, 3 );
        Scene errorScene = new Scene(errorPane, 400, 400);
        errorPane.setAlignment(Pos.CENTER);
        btnError.setOnAction(e -> {
                   primaryStage.setScene(primaryScene);
                   primaryStage.show();
                });
        
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
        Button home = new Button("Return to Main Menu");
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
        createCustPanel.add(home, 0, 10);
        home.setAlignment(Pos.CENTER);
        addCustomer.setAlignment(Pos.CENTER);
        Scene createCustomer = new Scene(createCustPanel, 400, 400);
        
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
         if(txtEmail.getText().contains("@") && txtPhone.getText().length() == 10 && txtFName.getText() != null 
                 && txtLName.getText() != null) {
                String FName = txtFName.getText();
                String LName = txtLName.getText();
                String Add = txtAdd.getText();
                String Phone = txtPhone.getText();
                String Email = txtEmail.getText();
                String Notes = txtNotes.getText();
                customer.add(new Customer(FName, LName, Add, Phone, Email, Notes));
                primaryStage.setScene(primaryScene);
                primaryStage.show();
            }
            else {
                primaryStage.setTitle("Error");
                primaryStage.setScene(errorScene);
                primaryStage.show();
                errorPane.setHgap(10);
                errorPane.setVgap(10);
                }
            
        
        }); 
         home.setOnAction(e -> {
              primaryStage.setScene(primaryScene);
              primaryStage.show();
         });
         
         //option for editing a customer
         //edit customer 
        ComboBox editCustomer = new ComboBox(customerList);
        Label combo = new Label("Select the customer to edit");
        GridPane editCustPanel = new GridPane();
        Button editCustomerInfo = new Button("Edit Customer");
        Label editCusFirst = new Label("First Name");
        Label editCusLast = new Label("Last Name");
        Label editCusAddress= new Label("Address");
        Label editCusPhone = new Label("Phone Number");
        Label editCusEmail = new Label("Email");
        Label editCusNotes = new Label("Additional Notes");
        TextField txtCusFirst = new TextField();
        TextField txtCusLast = new TextField();
        TextField txtCusAddress = new TextField();
        TextField txtCusPhone = new TextField();
        TextField txtCusEmail = new TextField();
        TextField txtCusNotes = new TextField();
        editCustPanel.add(editCustomer, 1 ,0);
        editCustPanel.add(combo, 0,0);
        editCustPanel.add(editCusFirst, 0, 1);
        editCustPanel.add(txtCusFirst, 1, 1);
        editCustPanel.add(editCusLast, 0, 2);
        editCustPanel.add(txtCusLast, 1, 2);
        editCustPanel.add(editCusAddress, 0, 3);
        editCustPanel.add(txtCusAddress, 1, 3);
        editCustPanel.add(editCusPhone, 0, 4);
        editCustPanel.add(txtCusPhone, 1, 4);
        editCustPanel.add(editCusEmail, 0, 5);
        editCustPanel.add(txtCusEmail, 1, 5);
        editCustPanel.add(editCusNotes, 0, 6);
        editCustPanel.add(txtCusNotes, 1, 6);
        editCustPanel.add(editCustomerInfo, 0, 8);
        editCustPanel.add(home, 0, 10);
        Scene editCustomerScene = new Scene(editCustPanel, 400, 400);
        
        editCust.setOnAction(e -> {
            txtCusFirst.setText(null);
            txtCusLast.setText(null);
            txtCusAddress.setText(null);
            txtCusPhone.setText(null);
            txtCusEmail.setText(null);
            txtCusNotes.setText(null);
            editCustomer.setValue(null);
            primaryStage.setTitle("Edit Customer Info");
            primaryStage.setScene(editCustomerScene);
            primaryStage.show();
            editCustPanel.setHgap(10);
            editCustPanel.setVgap(10);
        });
        
        editCustomerInfo.setOnAction(e -> {
             if(txtCusEmail.getText().contains("@") && txtCusPhone.getText().length() == 10 && txtCusFirst.getText() != null 
                 && txtCusLast.getText() != null) {
                String editCusF = txtCusFirst.getText();
                String editCusL = txtCusLast.getText();
                String editCusAdd = txtAdd.getText();
                String editCustomerPhone = txtPhone.getText();
                String editCustomerEmail = txtEmail.getText();
                String editCustomerNotes = txtNotes.getText();
                int editCustNum = editCustomer.getSelectionModel().getSelectedIndex();
                customer.set(editCustNum, new Customer(editCusF, editCusL, editCusAdd, editCustomerPhone, 
                        editCustomerEmail, editCustomerNotes, ((5 * editCustNum) + 1)));
                primaryStage.setScene(primaryScene);
                primaryStage.show();
             }
             else {
               primaryStage.setTitle("Error");
                primaryStage.setScene(errorScene);
                primaryStage.show();
                errorPane.setHgap(10);
                errorPane.setVgap(10);
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
            if(txtConEmail.getText().contains("@") && txtConPhone.getText().length() == 10 && txtConFirst.getText() != null 
                 && txtConLast.getText() != null) {
                    String conFirstName = txtConFirst.getText();
                    String conLastName = txtConLast.getText();
                    String conAddress = txtConAdd.getText();
                    String conPhoneNumber = txtConPhone.getText();
                    String conEmailAdd = txtConEmail.getText();
                    String contractorNotes = txtConNotes.getText();
                    String busAdd = txtConBusAdd.getText();
                    String busName = txtConBusName.getText();
                    contractor.add(new Contractor(conFirstName, conLastName, conAddress, conPhoneNumber, conEmailAdd, contractorNotes,
                        busAdd, busName));
                    primaryStage.setScene(primaryScene);
                    primaryStage.show();
            }
            else {
               primaryStage.setTitle("Error");
                primaryStage.setScene(errorScene);
                primaryStage.show();
                errorPane.setHgap(10);
                errorPane.setVgap(10);
                }
        });
        
         //edit contractor function
        ComboBox editContractor = new ComboBox(contractorList);
        Label comboCon = new Label("Select the Contractor to edit");
        GridPane editConPanel = new GridPane();
        Button editContractorInfo = new Button("Edit Contractor");
        Button confirmEdit = new Button("Edit Contractor");
        Label editConFirst = new Label("First Name");
        Label editConLast = new Label("Last Name");
        Label editConAdd = new Label("Address");
        Label editConPhone = new Label("Phone Number");
        Label editConEmail = new Label("Email");
        Label editConBusAdd = new Label("Business Address");
        Label editConBusName = new Label("BusinessName");
        Label editConNotes = new Label("Contractor Notes");
        TextField txtEditConFirst = new TextField();
        TextField txtEditConLast = new TextField();
        TextField txtEditConAdd = new TextField();
        TextField txtEditConPhone = new TextField();
        TextField txtEditConEmail = new TextField();
        TextField txtEditConNotes = new TextField();
        TextField txtEditConBusAdd = new TextField();
        TextField txtEditConBusName = new TextField();
        editConPanel.add(editContractor, 1, 9);
        editConPanel.add(comboCon, 0, 9);
        editConPanel.add(editConFirst, 0, 0);
        editConPanel.add(editConLast, 0, 1);
        editConPanel.add(editConAdd, 0, 2);
        editConPanel.add(editConPhone, 0, 3);
        editConPanel.add(editConEmail, 0, 4);
        editConPanel.add(editConBusAdd, 0, 6);
        editConPanel.add(editConBusName, 0, 7);
        editConPanel.add(txtEditConFirst, 1, 0);
        editConPanel.add(txtEditConLast, 1, 1);
        editConPanel.add(txtEditConAdd, 1, 2);
        editConPanel.add(txtEditConPhone, 1, 3);
        editConPanel.add(txtEditConEmail, 1, 4);
        editConPanel.add(txtEditConNotes, 1, 5);
        editConPanel.add(editConNotes, 0, 5);
        editConPanel.add(txtEditConBusAdd, 1, 6);
        editConPanel.add(txtEditConBusName, 1, 7);
        editConPanel.add(confirmEdit, 0, 11);
        confirmEdit.setAlignment(Pos.CENTER_RIGHT);
        Scene editContractorScene = new Scene(editConPanel, 400, 400);
        
        editCon.setOnAction(e -> {
            editContractor.setValue(null);
            txtEditConFirst.setText(null);
            txtEditConLast.setText(null);
            txtEditConAdd.setText(null);
            txtEditConPhone.setText(null);
            txtEditConEmail.setText(null);
            txtEditConNotes.setText(null);
            txtEditConBusAdd.setText(null);
            txtEditConBusName.setText(null);
            primaryStage.setTitle("Edit Contractor");
            primaryStage.setScene(editContractorScene);
            primaryStage.show();
            createConPanel.setHgap(10);
            createConPanel.setVgap(10);
        });    
         confirmEdit.setOnAction(e -> {
              if(txtEditConFirst.getText() != null && txtEditConLast.getText() != null && txtEditConBusName.getText() != null 
                    && txtEditConEmail.getText().contains("@")) {
                String editConsF = txtEditConFirst.getText(); 
                String editConsL = txtEditConLast.getText();
                String editConsAd = txtEditConAdd.getText();
                String editTele = txtEditConPhone.getText();
                String editEmai = txtEditConEmail.getText();
                String editNot = txtEditConNotes.getText();
                String editConBusAddy = txtEditConBusAdd.getText();
                String editConBusNam = txtEditConBusName.getText();
                int editConInfo = editContractor.getSelectionModel().getSelectedIndex();
                contractor.set(editConInfo, new Contractor(editConsF, editConsL, editConsAd, editTele, 
                        editEmai, editNot, editConBusAddy, editConBusNam, ((editConInfo * 5)+ 2)));
                primaryStage.setScene(primaryScene);
                primaryStage.show();
              }
               else {
                primaryStage.setTitle("Error");
                primaryStage.setScene(errorScene);
                primaryStage.show();
                errorPane.setHgap(10);
                errorPane.setVgap(10);
                }
              
        });
        
                //data fields for choosing customer or contractor sale 
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
        
        
        //create a sale button
        btn3.setOnAction(e -> {
            primaryStage.setTitle("Create Sale Item");
            primaryStage.setScene(scene2);
            primaryStage.show();
            salePane1.setHgap(10);
            salePane1.setVgap(10);
        });
        
        exit.setOnAction(e -> {
            primaryStage.setScene(primaryScene);
            primaryStage.show();
        });
        
        //data fields for customer sale data
        GridPane custSalePanel = new GridPane();
        Label lblChooseCust = new Label("Choose Customer");
        ComboBox chooseCust = new ComboBox(custList);
        Label lblChooseCustDate = new Label("Date");
        TextField custSaleDate = new TextField();
        Label custItem = new Label("Item");
        ComboBox custItemBox = new ComboBox(itemList);
        Label custQuant = new Label("Quantity Purchased");
        TextField custQuantE = new TextField();
        Button continueCustSale = new Button("Continue Sale");
        Button endCustSale = new Button("Finish Sale");
        custSalePanel.add(lblChooseCust, 0, 1);
        custSalePanel.add(chooseCust, 1, 1);
        custSalePanel.add(lblChooseCustDate, 0, 2);
        custSalePanel.add(custSaleDate, 1, 2);
        custSalePanel.add(custItem, 0, 3);
        custSalePanel.add(custItemBox, 1, 3);
        custSalePanel.add(custQuant, 0, 4);
        custSalePanel.add(custQuantE, 1, 4);
        custSalePanel.add(continueCustSale, 0, 5);
        custSalePanel.add(endCustSale, 1, 5);
        custSalePanel.setAlignment(Pos.CENTER);
        Scene custSaleScene = new Scene(custSalePanel, 400, 400);
        
        //enter all sale data
        createCusSale.setOnAction(e -> {
            chooseCust.setValue(null);
            custSaleDate.setText(null);
            custItemBox.setValue(null);
            custQuantE.setText(null);
            primaryStage.setTitle("Enter Customer Sale");
            primaryStage.setScene(custSaleScene);
            primaryStage.show();
            custSalePanel.setHgap(10);
            custSalePanel.setVgap(10);
        });
        
        //end current sale entry
        Alert errorAlertCustSale = new Alert(AlertType.ERROR);
        Alert successCustSale = new Alert(AlertType.INFORMATION);
        
        endCustSale.setOnAction(e -> {
            if(item.get(custItemBox.getSelectionModel().getSelectedIndex()).quantAvail -
                    Integer.parseInt(custQuantE.getText()) >= 0) {
                int custID = chooseCust.getSelectionModel().getSelectedIndex();
                String date = custSaleDate.getText();
                int itemID = custItemBox.getSelectionModel().getSelectedIndex();
                int quantity = Integer.parseInt(custQuantE.getText());
                sales.add(new ArrayList<>());
                sales.get(sales.size()-1).add(new Sale(item.get(itemID), quantity, date, customer.get(custID)));
                item.get(itemID).quantAvail -= quantity; 
                primaryStage.setScene(primaryScene);
                primaryStage.show();
                
                successCustSale.setHeaderText("Sale Created!");
                successCustSale.setContentText("Sale Added!");
                successCustSale.setResizable(true);
                successCustSale.getDialogPane().setPrefSize(400,400);
                successCustSale.showAndWait();
            }
            else {
                errorAlertCustSale.setHeaderText("Sale Error");
                errorAlertCustSale.setContentText("Quantity Requested Exceeds Quantity Available");
                errorAlertCustSale.setResizable(true);
                errorAlertCustSale.getDialogPane().setPrefSize(400, 400);
                errorAlertCustSale.showAndWait();
            } 
        });
        
        //add second sale
        GridPane addCustoPane = new GridPane();
        Label newItem = new Label("Item");
        ComboBox newItemA = new ComboBox(itemList);
        Label newQuant = new Label("Quantity");
        TextField newQuantA = new TextField();
        Button addCustoSale = new Button("Continue Sale");
        Button endCustoSale = new Button("Finish Sale");
        Label custName = new Label();
        Label custDate = new Label();
        addCustoPane.add(custName, 0, 1);
        addCustoPane.add(custDate, 0, 2);
        addCustoPane.add(newItem, 0, 3);
        addCustoPane.add(newItemA, 1, 3);
        addCustoPane.add(newQuant, 0, 4);
        addCustoPane.add(newQuantA, 1, 4);
        addCustoPane.add(addCustoSale, 0, 5);
        addCustoPane.add(endCustoSale, 1, 5);
        Scene custScene = new Scene(addCustoPane, 400, 400);
        
        continueCustSale.setOnAction(e -> {
           if(item.get(custItemBox.getSelectionModel().getSelectedIndex()).quantAvail -
                    Integer.parseInt(custQuantE.getText()) >= 0) {
                int custID = chooseCust.getSelectionModel().getSelectedIndex();
                String date = custSaleDate.getText();
                int itemID = custItemBox.getSelectionModel().getSelectedIndex();
                int quantity = Integer.parseInt(custQuantE.getText());
                sales.add(new ArrayList<>());
                sales.get(sales.size()-1).add(new Sale(item.get(itemID), quantity, date, customer.get(custID)));
                item.get(itemID).quantAvail -= quantity; 
                
                successCustSale.setHeaderText("Sale Created!");
                successCustSale.setContentText("Sale Added!");
                successCustSale.setResizable(true);
                successCustSale.getDialogPane().setPrefSize(400,400);
                successCustSale.showAndWait();
                
                custName.setText("" + customer.get(chooseCust.getSelectionModel().getSelectedIndex()).toString());
                custDate.setText(custSaleDate.getText());
                primaryStage.setTitle("Add Another Customer Sale");
                primaryStage.setScene(custScene);
                primaryStage.show();
            }
            else {
                errorAlertCustSale.setHeaderText("Sale Error");
                errorAlertCustSale.setContentText("Quantity Requested Exceeds Quantity Available");
                errorAlertCustSale.setResizable(true);
                errorAlertCustSale.getDialogPane().setPrefSize(400, 400);
                errorAlertCustSale.showAndWait();
            } 
        });
        
        addCustoSale.setOnAction(e -> {
           if(item.get(newItemA.getSelectionModel().getSelectedIndex()).quantAvail -
                    Integer.parseInt(newQuantA.getText()) >= 0) {
                int custID = chooseCust.getSelectionModel().getSelectedIndex();
                String date = custSaleDate.getText();
                int itemID = newItemA.getSelectionModel().getSelectedIndex();
                int quantity = Integer.parseInt(newQuantA.getText());
                sales.get(sales.size()-1).add(new Sale(item.get(itemID), quantity, date, customer.get(custID)));
                item.get(itemID).quantAvail -= quantity; 
                
                successCustSale.setHeaderText("Sale Created!");
                successCustSale.setContentText("Sale Added!");
                successCustSale.setResizable(true);
                successCustSale.getDialogPane().setPrefSize(400,400);
                successCustSale.showAndWait();
                
                newQuantA.setText(null);
                newItemA.setValue(null);
                
                custName.setText("" + customer.get(chooseCust.getSelectionModel().getSelectedIndex()).toString());
                custDate.setText(custSaleDate.getText());
                primaryStage.setTitle("Add Another Customer Sale");
                primaryStage.setScene(custScene);
                primaryStage.show();
            }
            else {
                errorAlertCustSale.setHeaderText("Sale Error");
                errorAlertCustSale.setContentText("Quantity Requested Exceeds Quantity Available");
                errorAlertCustSale.setResizable(true);
                errorAlertCustSale.getDialogPane().setPrefSize(400, 400);
                errorAlertCustSale.showAndWait();
            } 
        });
        
        endCustoSale.setOnAction(e -> {
            if(item.get(newItemA.getSelectionModel().getSelectedIndex()).quantAvail -
                    Integer.parseInt(custQuantE.getText()) >= 0) {
                int custID = chooseCust.getSelectionModel().getSelectedIndex();
                String date = custSaleDate.getText();
                int itemID = newItemA.getSelectionModel().getSelectedIndex();
                int quantity = Integer.parseInt(custQuantE.getText());
                sales.add(new ArrayList<>());
                sales.get(sales.size()-1).add(new Sale(item.get(itemID), quantity, date, customer.get(custID)));
                item.get(itemID).quantAvail -= quantity; 
                primaryStage.setScene(primaryScene);
                primaryStage.show();
                
                successCustSale.setHeaderText("Sale Created!");
                successCustSale.setContentText("Sale Added!");
                successCustSale.setResizable(true);
                successCustSale.getDialogPane().setPrefSize(400,400);
                successCustSale.showAndWait();
            }
            else {
                errorAlertCustSale.setHeaderText("Sale Error");
                errorAlertCustSale.setContentText("Quantity Requested Exceeds Quantity Available");
                errorAlertCustSale.setResizable(true);
                errorAlertCustSale.getDialogPane().setPrefSize(400, 400);
                errorAlertCustSale.showAndWait();
            } 
        });

  
        createConSale.setOnAction(e -> {
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
        TextField itemName = new TextField();
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
        TextField vendorID = new TextField();
        Label venID = new Label("Vendor ID");
        Button createInvItem = new Button("Add Inventory Item");
        ComboBox getVendor = new ComboBox(vendorList);
        inventoryPane1.add(getVendor, 1 , 7);
        inventoryPane1.add(createInvItem, 0, 8);
        inventoryPane1.add(inventoryLabel, 1, 0);
        inventoryPane1.add(inv1, 0, 1);
        inventoryPane1.add(itemName, 1, 1);
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
        inventoryPane1.add(venID, 0, 7);
        Scene scene3 = new Scene(inventoryPane1, 600, 400);

          //create a sale button
          btn2.setOnAction(e -> {
            primaryStage.setTitle("Item System");
            primaryStage.setScene(invScene);
            primaryStage.show();
            inventoryPane2.setHgap(10);
            inventoryPane2.setVgap(10);
        });
          
         //add an item button
         createItem.setOnAction(e -> {
           itemName.setText(null);
           weight.setText(null);
           description.setText(null);
           price.setText(null);
           forSale.setText(null);
           quantity.setText(null);
           primaryStage.setTitle("Add Item System");
           primaryStage.setScene(scene3);
           primaryStage.show();
           inventoryPane1.setHgap(10);
           inventoryPane1.setVgap(10);
           
         });
         createInvItem.setOnAction(e -> {
            
              if(itemName.getText() != null && weight.getText() != null && price.getText() != null 
                    && forSale.getText() != null) {
                String invName = itemName.getText(); 
                double itemWeight = Double.parseDouble(weight.getText());
                String itemDescription = description.getText();
                double itemPrice = Double.parseDouble(price.getText());
                double itemForSalePrice = Double.parseDouble(forSale.getText());
                int itemQuantity = Integer.parseInt(quantity.getText());
                int venNum = getVendor.getSelectionModel().getSelectedIndex();
                item.add(Item.itemCount, new Item(invName, itemWeight, itemDescription, itemPrice, 
                        itemForSalePrice, itemQuantity, vendor.get(venNum)));
                primaryStage.setScene(primaryScene);
                primaryStage.show();
              }
              else {
                primaryStage.setTitle("Error");
                primaryStage.setScene(errorScene);
                primaryStage.show();
                errorPane.setHgap(10);
                errorPane.setVgap(10);
                }
                   
         });
         // edit an inventory item
        Label editInventoryLabel = new Label("Manage Inventory System");
        GridPane editInventoryPane1 = new GridPane();
        Label editInv1 = new Label("Item Name ");
        TextField editItemName = new TextField();
        Label editInv2 = new Label("Item Weight");
        TextField editWeight = new TextField();
        Label editInv3 = new Label("Item Description");
        TextField editDescription = new TextField();
        Label editInv4 = new Label("Item Price");
        Label editInv5 = new Label("Item For-Sale Price");
        TextField editPrice = new TextField();
        TextField editForSale = new TextField();
        Label editInv6 = new Label("Quantity of Items Available");
        TextField editQuantity = new TextField();
        TextField editVendorID = new TextField();
        Label editVenID = new Label("Vendor that Item was purchased from");
        Label editItemID= new Label("Item you want to edit");
        Button completeEdit = new Button("Edit Item");
        ComboBox editGetVendor = new ComboBox(vendorList);
        ComboBox itemInfo = new ComboBox(itemList);
        editInventoryPane1.add(editGetVendor, 1 , 7);
        editInventoryPane1.add(completeEdit, 0, 9);
        editInventoryPane1.add(editInventoryLabel, 1, 0);
        editInventoryPane1.add(editInv1, 0, 1);
        editInventoryPane1.add(editItemName, 1, 1);
        editInventoryPane1.add(editInv2, 0, 2);
        editInventoryPane1.add(editWeight, 1, 2);
        editInventoryPane1.add(editInv3, 0, 3);
        editInventoryPane1.add(editDescription, 1, 3);
        editInventoryPane1.add(editInv4, 0, 4);
        editInventoryPane1.add(editPrice, 1, 4);
        editInventoryPane1.add(editInv5, 0, 5);
        editInventoryPane1.add(editForSale, 1, 5);
        editInventoryPane1.add(editInv6, 0, 6);
        editInventoryPane1.add(editQuantity, 1, 6);
        editInventoryPane1.add(editVenID, 0, 7);
        editInventoryPane1.add(editItemID, 0, 8);
        editInventoryPane1.add(itemInfo, 1, 8);
        Scene editScene3 = new Scene(editInventoryPane1, 600, 400);
        
        //button to initiate edit
        editItem.setOnAction(e -> {
           editItemName.setText(null);
           editWeight.setText(null);
           editDescription.setText(null);
           editPrice.setText(null);
           editForSale.setText(null);
           editQuantity.setText(null);
           editGetVendor.setValue(null);
           itemInfo.setValue(null);
           primaryStage.setTitle("Edit Inventory Item");
           primaryStage.setScene(editScene3);
           primaryStage.show();
        });
        
        completeEdit.setOnAction(e -> {
              if(editItemName.getText() != null && editWeight.getText() != null && editPrice.getText() != null 
                    && editForSale.getText() != null) {
                String editnam = editItemName.getText(); 
                double editway = Double.parseDouble(editWeight.getText());
                String editdes = editDescription.getText();
                double editpri = Double.parseDouble(editPrice.getText());
                double editsp = Double.parseDouble(editForSale.getText());
                int editqt = Integer.parseInt(editQuantity.getText());
                int editVenNum = editGetVendor.getSelectionModel().getSelectedIndex();
                int editItemNum = itemInfo.getSelectionModel().getSelectedIndex();
                item.set(editItemNum, new Item(editnam, editway, editdes, editpri, 
                        editsp, editqt, ((editItemNum * 5) +3), vendor.get(editVenNum)));
                primaryStage.setScene(primaryScene);
                primaryStage.show();
              }
              else {
               primaryStage.setTitle("Error");
                primaryStage.setScene(errorScene);
                primaryStage.show();
                errorPane.setHgap(10);
                errorPane.setVgap(10);
                }
        });
        
         //button to return to main menu
          leave.setOnAction(e -> {
              primaryStage.setScene(primaryScene);
              primaryStage.show();
          });
          
        Label receiptLabel = new Label("Sales Report");
        GridPane receiptPane1 = new GridPane();
        Label Sale = new Label("Sale");
        ComboBox saleListBox = new ComboBox(saleList);
        Button selectSale = new Button("Select a Sale");
                   
        Scene scene4 = new Scene(receiptPane1, 400, 400);
        Button menu = new Button("Return to Main Menu");
           
        receiptPane1.add(Sale, 0, 0);
        receiptPane1.add(saleListBox, 1, 0);
        receiptPane1.add(selectSale, 1, 1);
        receiptPane1.add(menu, 0,4);
        menu.setAlignment(Pos.CENTER_RIGHT);
        GridPane selSale = new GridPane();
          
           
    
           //print sale receipt button
           btn4.setOnAction(e -> {
               primaryStage.setTitle("Sales Receipt");
               primaryStage.setScene(scene4);
               primaryStage.show();
               receiptPane1.setHgap(5);
               receiptPane1.setVgap(10);
           });
           // Select Sale button
           GridPane salePane = new GridPane();
           Label saleCol1 = new Label();
           Label saleCol2 = new Label();
           Label saleCol3 = new Label();
           Label saleCol4 = new Label();
           salePane.setPadding(new Insets(10));
           
           salePane.add(saleCol1, 0, 0);
           salePane.add(saleCol2, 1, 0);
           salePane.add(saleCol3, 2, 0);
           salePane.add(saleCol4, 3, 0);
           Scene saleScene = new Scene(salePane, 600, 600);
           
           selectSale.setOnAction(e -> {
               double total = 0;
               String tempStringCol1 = ("Item Name");
                      
               String tempStringCol2 = ("\tPrice");
               String tempStringCol3 = ("Quantity");
                     
               String tempStringCol4 = ("\tTotal Price");
                      
               
               for(int i = 0; i < sales.get(saleListBox.getSelectionModel().getSelectedIndex()).size(); i++) {
                    tempStringCol1 += "\n" + sales.get(saleListBox.getSelectionModel().getSelectedIndex()).get(i).itemSold.itemName; 
                    tempStringCol2 += "\n\t" + sales.get(saleListBox.getSelectionModel().getSelectedIndex()).get(i).itemSold.getSalePrice(); 
                    tempStringCol3 += "\n\t" + sales.get(saleListBox.getSelectionModel().getSelectedIndex()).get(i).quantity;
                    tempStringCol4 += "\n\t" + sales.get(saleListBox.getSelectionModel().getSelectedIndex()).get(i).itemSold.getSalePrice()                        
                           *  sales.get(saleListBox.getSelectionModel().getSelectedIndex()).get(i).quantity;
                    total +=  (sales.get(saleListBox.getSelectionModel().getSelectedIndex()).get(i).itemSold.getSalePrice() 
                           * sales.get(saleListBox.getSelectionModel().getSelectedIndex()).get(i).quantity);
                    }
               tempStringCol1 += "\nTotal Sales: ";
               tempStringCol4 += "\n\t" + total;
               saleCol1.setText(tempStringCol1);
               saleCol2.setText(tempStringCol2);
               saleCol3.setText(tempStringCol3);
               saleCol4.setText(tempStringCol4);
               primaryStage.setTitle("Sale Report");
               primaryStage.setScene(saleScene);
               primaryStage.show();
               salePane.setHgap(10);
               salePane.setVgap(10);
               
           
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
        TextField txtVenName = new TextField();
        TextField txtVenAddress = new TextField();
        TextField txtVenPhone2 = new TextField();
        vendorPane2.add(venName, 0, 1);
        vendorPane2.add(venAddress, 0, 2);
        vendorPane2.add(venPhone, 0, 3);
        vendorPane2.add(txtVenName, 1, 1);
        vendorPane2.add(txtVenAddress, 1,2);
        vendorPane2.add(txtVenPhone2, 1, 3);
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
            txtVenName.setText(null);
            txtVenAddress.setText(null);
            txtVenPhone2.setText(null);
            primaryStage.setTitle("Create a New Vendor");
            primaryStage.setScene(vendorScene);
            primaryStage.show();
            vendorPane2.setHgap(10);
            vendorPane2.setVgap(10);
        });
        //add vendor to array list button
        addVendor.setOnAction(e -> {
         if(txtVenName.getText() != null && txtVenPhone2.getText().length() == 10){
                String vendorName = txtVenName.getText();  
                String vendorAdd = txtVenAddress.getText();
                String vendorPhone = txtVenPhone2.getText();
                vendor.add(Vendor.venCount, new Vendor(vendorName, vendorAdd, vendorPhone));
                primaryStage.setScene(primaryScene);
                primaryStage.show();
            }
          else {
               primaryStage.setTitle("Error");
                primaryStage.setScene(errorScene);
                primaryStage.show();
                errorPane.setHgap(10);
                errorPane.setVgap(10);
                }       
        });
        //edit vendor
        ComboBox listOfVendors = new ComboBox(vendorList);
        GridPane vendorPane3 = new GridPane();
        Scene editVenScene = new Scene(vendorPane3, 400, 400);
        Label lblofVendors = new Label("Select Vendor to Edit");
        Label editVenName = new Label("Name");
        Label editVenAddress = new Label("Address");
        Label editVenPhone = new Label("Phone Number");
        TextField txtEditName = new TextField();
        TextField txtEditAddress = new TextField();
        TextField txtEditPhone = new TextField();
        Button comitVendorEdit = new Button("Edit Vendor");
        vendorPane3.add(lblofVendors, 0 , 0);
        vendorPane3.add(listOfVendors, 1 ,0);
        vendorPane3.add(editVenName, 0 , 1);
        vendorPane3.add(txtEditName, 1, 1);
        vendorPane3.add(editVenAddress, 0, 2);
        vendorPane3.add(txtEditAddress, 1, 2);
        vendorPane3.add(editVenPhone, 0, 3);
        vendorPane3.add(txtEditPhone, 1, 3);
        vendorPane3.add(comitVendorEdit, 0, 5);
        vendorPane3.setAlignment(Pos.CENTER_RIGHT);
        
        editVendor.setOnAction(e -> {
            txtEditName.setText(null);
            txtEditAddress.setText(null);
            txtEditPhone.setText(null);
            listOfVendors.setValue(null);
            primaryStage.setTitle("Edit Vendor");
            primaryStage.setScene(editVenScene);
            primaryStage.show();
            vendorPane2.setHgap(10);
            vendorPane2.setVgap(10);
        });
        
        //edit vendor button
        comitVendorEdit.setOnAction(e -> {
            if(txtEditName.getText() != null && txtEditPhone.getText().length() == 10){
                String venFName = txtEditName.getText();  
                String venEditAdd = txtEditAddress.getText();
                String venEditPhone = txtEditPhone.getText();
                int editVendorNum = listOfVendors.getSelectionModel().getSelectedIndex();
                vendor.set(editVendorNum, new Vendor(venFName, venEditAdd, venEditPhone, ((editVendorNum * 5) + 5)));
                primaryStage.setScene(primaryScene);
                primaryStage.show();
            }
            else {
                primaryStage.setTitle("Error");
                primaryStage.setScene(errorScene);
                primaryStage.show();
                errorPane.setHgap(10);
                errorPane.setVgap(10);
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
               
               
               
               
               
         //Creating new report Customer History
         //Creating controls
        GridPane customerHistory = new GridPane();
        Label custHistory = new Label("Select customer to view the purchase history of");
        Label viewAllHis = new Label();
        Button viewCustHistory = new Button("View History");
        Button exitCustHistory = new Button("Return to Main Menu");
        ComboBox comboHistory = new ComboBox(customerList);
        //adding controls 
        customerHistory.add(custHistory, 0, 0);
        customerHistory.add(comboHistory, 1, 0);
        customerHistory.add(viewCustHistory, 0 ,2);
        customerHistory.add(viewAllHis, 0, 10);
        customerHistory.add(exitCustHistory, 0, 12);
        exitCustHistory.setAlignment(Pos.BASELINE_LEFT);
        Scene customerHistoryInfo = new Scene(customerHistory, 600, 600);
    
        //Get into customer history pane
        createCusHis.setOnAction(e ->{
        comboHistory.setValue(null);
        primaryStage.setScene(customerHistoryInfo);
        primaryStage.show();
        });
    
        //Contractor History Report details 
        viewCustHistory.setOnAction(e -> {
            String tempString = ("Customer Purchase History:"
                    + "\nCustomer Name\t\tItem Sold\t\t quantity\t\t date\t\tSale price"
                    + "\n=====================================================");
             for(int i = 0; i < sales.get(comboHistory.getSelectionModel().getSelectedIndex()).size(); i++){
                tempString += "\n" + String.format(sales.get(comboHistory.getSelectionModel().getSelectedIndex()).get(i).customer.firstName 
                        + " " + sales.get(comboHistory.getSelectionModel().getSelectedIndex()).get(i).customer.lastName 
                         + "\t\t\t" + sales.get(comboHistory.getSelectionModel().getSelectedIndex()).get(i).itemSold.itemName 
                        +"\t\t" + sales.get(comboHistory.getSelectionModel().getSelectedIndex()).get(i).quantity + "\t\t" 
                           + sales.get(comboHistory.getSelectionModel().getSelectedIndex()).get(i).date + "\t\t" 
                        + sales.get(comboHistory.getSelectionModel().getSelectedIndex()).get(i).quantity 
                                * sales.get(comboHistory.getSelectionModel().getSelectedIndex()).get(i).itemSold.getSalePrice());
              viewAllHis.setText(tempString);
              
             }
             //showing pane
            primaryStage.setScene(customerHistoryInfo);
            primaryStage.show();
            reportPane1.setHgap(20);
            reportPane1.setVgap(20);
            
        });
        //back to main menu (end of customer print report)
        exitCustHistory.setOnAction(e -> {
              primaryStage.setScene(primaryScene);
              primaryStage.show();
          });
        
        //stuff to have new report
        GridPane inventoryLevel = new GridPane();
        Label itemTitle = new Label();
        Label itemNameR = new Label();
        Label levels = new Label();
        Button returnHome = new Button("Return to Main Menu");
        inventoryLevel.add(itemTitle, 0, 0);
        inventoryLevel.add(itemNameR, 0, 2);
        inventoryLevel.add(levels, 1, 2);
        inventoryLevel.add(returnHome, 0 , 12);
        returnHome.setAlignment(Pos.BASELINE_LEFT);
        Scene invLevel = new Scene(inventoryLevel, 400, 400);
        
        //inventory item levels reprot
        createInvLevel.setOnAction(e -> {
            String tempString = "Current Inventory Levels for All Items: \n";
            itemTitle.setText(tempString);
            String tempStringCol1 = ("Item Name"
                    + "\n====================");
            String tempStringCol2 = "Inventory Levels"
                    + "\n==============";
            for(int i = 0; i < item.size(); i++) {
                tempStringCol1 += ("\n" + item.get(i).itemName);
                tempStringCol2 += ("\n" + item.get(i).quantAvail);
                itemNameR.setText(tempStringCol1);
                levels.setText(tempStringCol2);
            }
            primaryStage.setTitle("Current Inventory Levels");
            primaryStage.setScene(invLevel);
            primaryStage.show();
        }); 
        
        returnHome.setOnAction(e -> {
           primaryStage.setScene(primaryScene);
              primaryStage.show(); 
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

