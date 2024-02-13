/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author damonng
 */
public class Invoice {
    private String id;
    private String generationDate;
    private double grandTotal;
    private String Customer;
    private boolean payment;
    private boolean production;
    private boolean delivery;
    public static List<Invoice> list;
    public static int latestId;
    
    static{
        populateList();
        latestId = Integer.parseInt(list.getLast().getId())+1;
    }

    /**
     * Constructor for reading from files
     * @param id
     * @param generationDate
     * @param grandTotal
     * @param Customer
     * @param payment
     * @param production
     * @param delivery
     */
    public Invoice(String id, String generationDate, double grandTotal, String Customer, boolean payment, boolean production, boolean delivery) {
        this.id = id;
        this.generationDate = generationDate;
        this.grandTotal = grandTotal;
        this.Customer = Customer;
        this.payment = payment;
        this.production = production;
        this.delivery = delivery;
    }
    
    public Invoice(String generationDate, double grandTotal, String Customer) {
        this.id = Integer.toString(latestId);
        this.generationDate = Verify.LocalDateToString(LocalDate.now());
        this.grandTotal = grandTotal;
        this.Customer = Customer;
        this.payment = false;
        this.production = false;
        this.delivery = false;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(String generationDate) {
        this.generationDate = generationDate;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String Customer) {
        this.Customer = Customer;
    }

    public boolean isPayed() {
        return payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    public boolean isProducted() {
        return production;
    }

    public void setProduction(boolean production) {
        this.production = production;
    }

    public boolean isDelivered() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }
    
    public static void populateList(){
        list = File.read("invoice",Invoice.class);
    }
    
}
