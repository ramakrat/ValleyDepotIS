package ValleyDepotIS;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ValleyDepotFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
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
        
        //objects for 1nd window for manage customers
        
        Label customerLabel = new Label("Manage Customers System");
        Button createCust = new Button("Create New Customer");
        Button editCust = new Button("Edit Customer");
        Button createCon = new Button("Create New Contractor");
        Button editCon = new Button("Edit Contractor");
        GridPane custpane1 = new GridPane();
        Label lbl = new Label("1.)");
        Label lbl2 = new Label("2.)");
        Label lbl3 = new Label("3.)");
        Label lbl4 = new Label("4.)");
        custpane1.add(customerLabel, 1, 0);
        custpane1.add(createCust, 1, 1);
        custpane1.add(editCust, 1, 2);
        custpane1.add(createCon, 1, 3);
        custpanel.add(editCon, 1, 4);
        custpane1.add(lbl, 0, 1);
        custpane1.add(lbl2, 0, 2);
        custpanel.add(lbl3, 0, 3);
        custpanel.add(lbl4, 0, 4);
        Scene scene1 = new Scene(custpane1, 400, 400);
        btn1.setOnAction(e -> {
            primaryStage.setTitle("Manage Customers");
            primaryStage.setScene(scene1);
            primaryStage.show();
            custpane1.setHgap(10);
            custpane1.setVgap(10);
        });
        
        Label lblFName = new Label("First Name");
        Label lblLName = new Label("Last Name");
        Label lblAddress = new Label("Address");
        Label lblPhone = new Label("Phone Number");
        Label lblEmail = new Label("E-mail");
        Label lblNotes = new Label("Notes");
        TextField txtFName = new TextField();
        TextField txtLName = new TextField();
        TextField txtAddress = new TextField();
        TextField txtPhone = new TextField();
        TextField txtEmail = new TextField();
        TextField txtNotes = new TextField();
        
        GridPane custpane2 = new GridPane();
        createCust.setOnAction(e -> {
            primaryStage.setTitle("Create Customer");
            
        
        Label inventoryLabel = new Label("Manage Inventory System");
        Button createInventory = new Button("Create new Inventory Item");
        Button editInventory = new Button("Edit an inventory Item");
        GridPane inventorypane1 = new GridPane();
        Label inv1 = new Label("1.)");
        Label inv2 = new Label("2.)");
        //inventorypane1 = inventoryLabel, 1, 0);
        
        
        
        
      
    }
    Label inventoryLabel = new Label("Manage Inventory System");
        Button createInventory = new Button("Create new Inventory Item");
        Button editInventory = new Button("Edit an inventory Item");
        GridPane inventoryPane1 = new GridPane();
        Label inv1 = new Label("1.)");
        Label inv2 = new Label("2.)");
        Label inv3 = new Label("3.)");
        Button exit = new Button("Return to Main Menu");
        inventoryPane1.add(inventoryLabel, 1, 0);
        inventoryPane1.add(createInventory, 1, 1);
        inventoryPane1.add(editInventory, 1, 2);
        inventoryPane1.add(inv1, 0, 1);
        inventoryPane1.add(inv2, 0, 2);
        inventoryPane1.add(inv3, 0, 3);
        inventoryPane1.add(exit, 1,3);
        Scene scene2 = new Scene(inventoryPane1, 400, 400);
        
        //manage inventory button
        btn2.setOnAction(e -> {
            primaryStage.setTitle("Manage Inventory Items");
            primaryStage.setScene(scene2);
            primaryStage.show();
            inventoryPane1.setHgap(10);
            inventoryPane1.setVgap(10);
        });
          
        //create a sale
          Label saleLabel = new Label("Create a Sale");
          GridPane salesPane1 = new GridPane();
          Label sale1 = new Label("Item Name ");
          TextField name = new TextField();
          Label sale2 = new Label("Item Weight");
          TextField weight = new TextField();
          Label sale3 = new Label("Item Description");
          TextField description = new TextField();
          Label sale4 = new Label("Item Price");
          Label sale5 = new Label("Item For-Sale Price");
          TextField price = new TextField();
          TextField forSale = new TextField();
          Label sale6 = new Label("Quantity of Items Available");
          TextField quantity = new TextField();
          Button leave = new Button("Return to Main Menu");
          salesPane1.add(saleLabel, 1, 0);
          salesPane1.add(sale1, 0, 1);
          salesPane1.add(name, 1, 1);
          salesPane1.add(sale2, 0, 2);
          salesPane1.add(weight, 1, 2);
          salesPane1.add(sale3, 0, 3);
          salesPane1.add(description, 1, 3);
          salesPane1.add(sale4, 0, 4);
          salesPane1.add(price, 1, 4);
          salesPane1.add(sale5, 0, 5);
          salesPane1.add(forSale, 1, 5);
          salesPane1.add(sale6, 0, 6);
          salesPane1.add(quantity, 1, 6);
          Scene scene3 = new Scene(salesPane1, 400, 400);
          
          //create a sale button
          btn3.setOnAction(e -> {
            primaryStage.setTitle("Create a Sale");
            primaryStage.setScene(scene3);
            primaryStage.show();
            inventoryPane1.setHgap(10);
            inventoryPane1.setVgap(10);
        });

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }
    
}
