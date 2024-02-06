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


public class SalesOrder {
    private String orderID;
    private String furnitureID;
    private int quantity;
    private double total;
    private String generatedBy;
    private String approvedBy;
    private String customer;
    private String status;
    public static List<SalesOrder> salesOrders;

    static {
        populateList();
    }

    // Getter and Setter

    public String getId() {
        return orderID;
    }

    public void setId(String id) {
        this.orderID = id;
    }

    public String getFurniture() {
        return furnitureID;
    }

    public void setFurniture(String furniture) {
        this.furnitureID = furniture;
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

    // Constructor with default "Pending" status
    public SalesOrder(String orderID, String furnitureID, int quantity, double total, String generatedBy, String approvedBy) {
        this.orderID = orderID;
        this.furnitureID = furnitureID;
        this.quantity = quantity;
        this.total = total;
        this.generatedBy = generatedBy;
        this.approvedBy = approvedBy;
        this.customer = "";
        this.status = "Pending";
    }
  

    public void createSalesOrder(String orderID, String furnitureID, int quantity, double total, String generatedBy, String approvedBy) {
        setId(orderID);
        setFurniture(furnitureID);
        setQuantity(quantity);
        setTotal(total);
        setGeneratedBy(generatedBy);
        setApprovedBy(approvedBy);

        salesOrders.add(this);
        System.out.println("record stored in index"+salesOrders.indexOf(this));
        System.out.println("Sales Order created successfully!");
    }

    public void modifySalesOrder(String orderId, String newFurniture, int newQuantity, double newTotal,
            String newGeneratedBy, String newApprovedBy, String newCustomer, String newStatus) {
        for (SalesOrder order : salesOrders) {
            if (order.getId().equals(orderId)) {
                order.setFurniture(newFurniture);
                order.setQuantity(newQuantity);
                order.setTotal(newTotal);
                order.setGeneratedBy(newGeneratedBy);
                order.setApprovedBy(newApprovedBy);
                order.setCustomer(newCustomer);
                order.setStatus(newStatus);

                System.out.println("Sales Order with ID " + orderId + " modified successfully!");
                return;
            }
        }
        System.out.println("Sales Order with ID " + orderId + " not found!!");
    }

    public void searchSalesOrder(String orderId) {
        for (SalesOrder order : salesOrders) {
            if (order.getId().equals(orderId)) {
                System.out.println("Sales Order found:\n" + order);
                return;
            }
        }
        System.out.println("Sales Order with ID " + orderId + " not found!!");
    }

    public void deleteSalesOrder(String orderId) {
        salesOrders.removeIf(order -> order.getId().equals(orderId));
        System.out.println("Sales Order with ID " + orderId + " deleted successfully!");
    }

    public static void populateList() {
        salesOrders = File.read("salesOrder", SalesOrder.class);
    }
}
