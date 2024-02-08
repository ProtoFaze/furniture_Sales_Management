/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Aryssa
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class SalesOrder {
    private String orderID;
    private String furniture;
    private int quantity;
    private double total;
    private String customer;
    private String status;
    private String generatedBy;
    private String approvedBy;
    private String salesPersonId;
    public static List<SalesOrder> salesOrders;
    public static int latestId;

    static {
        populateList();
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

    // Constructor with default "Pending" status, for create
    public SalesOrder(String furniture, int quantity, double total, String generatedBy, String approvedBy) {
        this.orderID = String.valueOf(latestId+=1);
        this.furniture = furniture;
        this.quantity = quantity;
        this.total = total;
        this.generatedBy = generatedBy;
        this.approvedBy = approvedBy;
        this.customer = "";
        this.status = "Pending";
    }
    // Constructor for read file
    public SalesOrder(String orderID, String furniture, int quantity, double total, String generatedBy, String approvedBy, String customer, String status) {
        this.orderID = orderID;
        this.furniture = furniture;
        this.quantity = quantity;
        this.total = total;
        this.generatedBy = generatedBy;
        this.approvedBy = approvedBy;
        this.customer = customer;
        this.status = status;
        if(Integer.parseInt(orderID)>latestId){
            latestId = Integer.parseInt(orderID);
        }
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

    public void searchSalesOrder(String orderId) {
    try (BufferedReader br = new BufferedReader(new FileReader("salesOrder.txt"))) {
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            String orderIDFromFile = parts[0].trim(); 

            if (orderIDFromFile.equals(orderId)) {
                System.out.println("Sales Order found:\n" + line);
                return;
            }
        }

    } catch (IOException e) {
        e.printStackTrace(); // Handle the exception according to your needs
    }

    System.out.println("Sales Order with ID " + orderId + " not found!!");
}

       // for (SalesOrder order : salesOrders) {
        //    if (order.getId().equals(orderId)) {
          //      System.out.println("Sales Order found:\n" + order);

    public String searchOrderIDinFile(String orderIDsearch) {
    try (BufferedReader br = new BufferedReader(new FileReader("salesOrder.txt"))) {
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            String orderIDFromFile = parts[0].trim(); // Assuming order ID is the first value in each line
            if (orderIDFromFile.equals(orderIDsearch)) {
                System.out.println("Sales Order found:\n" + line);
                return line; // Return the details of the sales order
            }
        }

    } catch (IOException e) {
        e.printStackTrace(); // Handle the exception according to your needs
    }

    System.out.println("Sales Order with ID " + orderIDsearch + " not found!!");
    return null; // Order ID not found in the file or an error occurred
}


      //  System.out.println("Sales Order with ID " + orderId + " not found!!");
    //}

    public void deleteSalesOrder(String orderId) {
        salesOrders.removeIf(order -> order.getId().equals(orderId));
        System.out.println("Sales Order with ID " + orderId + " deleted successfully!");
        saveSalesOrdersToFile(); // Save the updated list to the file
    }

    private static void saveSalesOrdersToFile() {
        String filePath = "salesOrder.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (SalesOrder order : salesOrders) {
                writer.println(order.getId() + "," + order.getFurniture() + "," + order.getQuantity() +
                        "," + order.getTotal() + "," + order.getCustomer() + "," + order.getStatus() +
                        "," + order.getGeneratedBy() + "," + order.getApprovedBy());
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }

    public static void populateList() {
        salesOrders = File.read("salesOrder", SalesOrder.class);
    }
    
    public static void createSalesOrder2(String id, String furniture, int quantity, double total, String customer, String status,String generatedBy, String approvedBy) {
    String filePath = "salesOrder.txt";

    try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
        // Append the new sales order to the file
        writer.println(id + "," + furniture + "," + quantity + "," + total + "," + customer + "," + status + "," + generatedBy + "," + approvedBy );
        writer.flush();  // Ensure that any buffered data is written immediately
    } catch (IOException e) {
        e.printStackTrace(); // Handle the exception according to your needs
    }
}

}
