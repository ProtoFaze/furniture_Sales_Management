/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Aryssa
 */

import java.util.List;
import java.util.ArrayList;

public class SalesOrder {
    private String orderID;
    private String furniture;
    private int quantity;
    private double total;
    private String customer;
    private String status;
    private String generatedBy;
    private String approvedBy;
    private String quotationID;
    public static List<SalesOrder> salesOrders;
    public static int latestId;

    static {
        populateList();
        latestId  = Integer.parseInt(salesOrders.getLast().getId())+1;
    }

    public SalesOrder() {
      
    }
    // Getter and Setter

    public String getId() {
        return orderID;
    }

    public void setId(String id) {
        this.orderID = id;
    }

    public String getFurniture() {
        return furniture;
    }

    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getGeneratedBy() {
        return generatedBy;
    }

    // Setter
    public void setGeneratedBy(String generatedBy) {
        this.generatedBy = generatedBy;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getQuotation() {
        return quotationID;
    }

    public void setQuotation(String quotationID) {
        this.quotationID = quotationID;
    }
  

    // Constructor with default "Pending" status, for create
    public SalesOrder(String furniture, int quantity, double total, String generatedBy, String customer, String quotationID) {
        int newId = latestId++;
        this.orderID = String.valueOf(newId);
        this.furniture = furniture;
        this.quantity = quantity;
        this.total = total;
        this.generatedBy = generatedBy;
        this.approvedBy = "";
        this.customer = customer;
        this.status = "Pending";
        this.quotationID = quotationID;
    }
    // Constructor for read file
    public SalesOrder(String ID, String furniture, int quantity, double total, String generatedBy, String approvedBy, String customer, String status, String quotationID) {
     //   this.orderID = orderID;
        this.furniture = furniture;
        this.quantity = quantity;
        this.total = total;
        this.generatedBy = generatedBy;
        this.approvedBy = approvedBy;
        this.customer = customer;
        this.status = status;
        this.quotationID = quotationID;
    }
  
    public static void deleteWholeQuotation(String quotationID) {
        salesOrders.removeIf(order -> (order.getQuotation().equals(quotationID)));
        System.out.println("Sales Orders with ID " + quotationID + " deleted successfully!");
        File.write("salesOrder", salesOrders);
        populateList();
    }

    public static boolean isMyQuotation(String quotationID, String userId){
        for(SalesOrder order: SalesOrder.salesOrders){
            if(quotationID.equals(order.getQuotation()) && order.getGeneratedBy().equals(userId))
                return true;
        }
        return false;
    }
    
    public static void populateList() {
        salesOrders = File.read("salesOrder", SalesOrder.class);
    }
    
    
}
