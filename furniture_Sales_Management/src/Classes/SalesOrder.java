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
    public String getquotation() {
        return quotationID;
    }

    public void setquotation(String quotationID) {
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
        this.approvedBy = " ";
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
  

    
    public void createSalesOrder(String orderID, String furniture, int quantity, double total, String customer, String status, String generatedBy, String approvedBy) {
    setId(orderID);
    setFurniture(furniture);
    setQuantity(quantity);
    setTotal(total);
    setCustomer(customer);
    setStatus(status);  // Use the value passed as an argument
    setGeneratedBy(generatedBy);  // Use the value passed as an argument
    setApprovedBy(approvedBy);  // Use the value passed as an argument
    

    salesOrders.add(this);
    System.out.println("Sales Order created successfully!");

    printSalesOrders();
}

    
    
    public static void printSalesOrders() {
        System.out.println("Current Sales Orders:");
        for (SalesOrder order : salesOrders) {
            System.out.println(order);
        }
        
    }
    public String toString() {
    return "SalesOrder{" +
            "orderID='" + orderID + '\'' +
            ", furniture='" + furniture + '\'' +
            ", quantity=" + quantity +
            ", total=" + total +
            ", customer='" + customer + '\'' +
            ", status='" + status + '\'' +
            ", generatedBy='" + generatedBy + '\'' +
            ", approvedBy='" + approvedBy + '\'' +
            '}';
}
    public void modifySalesOrder(String orderId, String newFurniture, int newQuantity, double newTotal,
            String newGeneratedBy, String newApprovedBy, String newCustomer, String newStatus) {
        for (SalesOrder order : salesOrders) {
            if (order.getId().equals(orderId)) {
                order.setFurniture(newFurniture);
                order.setQuantity(newQuantity);
                order.setTotal(newTotal);           
                order.setCustomer(newCustomer);
                order.setStatus("Pending");
                order.setGeneratedBy(newGeneratedBy);
                order.setApprovedBy(newApprovedBy);

                System.out.println("Sales Order with ID " + orderId + " modified successfully!");
                return;
            }
        }
        System.out.println("Sales Order with ID " + orderId + " not found!!");
    }

    //return list of salesorder with matching criteria
    public static List<SalesOrder> searchOrders(String searchString, String byAttribute) {
        List<SalesOrder> returnRecord = new ArrayList<>();
        for(SalesOrder sales:salesOrders){
            String recordValue;
            switch(byAttribute.toLowerCase()){
                case "orderid" -> recordValue = sales.getId();
                case "furniture" -> recordValue = sales.getFurniture();
                case "quantity" -> recordValue = String.valueOf(sales.getQuantity());
                case "total" -> recordValue = String.valueOf(sales.getTotal());
                case "customer" -> recordValue = sales.getCustomer();
                case "status" -> recordValue = sales.getStatus();
                case "generatedby" -> recordValue = sales.getGeneratedBy();
                case "approvedby" -> recordValue = sales.getApprovedBy();
                case "quotationid" -> recordValue = sales.getquotation();
                default -> {
                    System.out.println("Invalid search attribute");
                    return null;
                }
            }
            if (recordValue.equals(searchString))
                returnRecord.add(sales);
        }
        if(returnRecord.isEmpty()){
            System.out.println("Sales Order with "+byAttribute+" " + searchString + " not found!!");
            return null;
        }else{
            return returnRecord;
        }
    }

    public void deleteSalesOrder(String orderId) {
        salesOrders.removeIf(order -> order.getId().equals(orderId));
        System.out.println("Sales Order with ID " + orderId + " deleted successfully!");
        File.write("salesOrder", salesOrders);
        populateList();
    }

    public static void populateList() {
        salesOrders = File.read("salesOrder", SalesOrder.class);
    }
    

}
