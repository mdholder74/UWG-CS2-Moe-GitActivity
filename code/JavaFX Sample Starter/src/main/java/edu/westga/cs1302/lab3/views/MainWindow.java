package edu.westga.cs1302.lab3.views;

import edu.westga.cs1302.lab3.model.Bill;
import edu.westga.cs1302.lab3.model.BillItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


/**
 * Controller class for drawing various things to our canvas window.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
  private Bill bill;
  private BillView billView;
  

    @FXML
    private TextField amount;

    @FXML
    private TextField name;

    @FXML
    private TextArea output;

    @FXML
    void addItem(ActionEvent event) {
      String billName = this.name.getText();// get the name from the text field
      double billAmount = Double.parseDouble(this.amount.getText());// get the amount from the text field
      
      BillItem billItem = new BillItem(billName, billAmount);// create a new bill item object using the name and amount
      
      bill.addItem(billItem);// add the bill item (name and amount) to the bill object
      
      String billInfo = this.billView.getText(bill);// get the bill information, format it and display it in the text area
      this.output.setText(billInfo);// display the bill information in the text area
      

    }


    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
      this.bill = new Bill();// create a new bill object
      this.billView = new BillView();// create a new bill view object
    	
    }
    
    
    
    
}
