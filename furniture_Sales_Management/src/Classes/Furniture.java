package Classes;

import java.util.List;

/**
 *
 * @author damonng
 */
public class Furniture {
    private String id,name,category,sellableOnline,link,shortDescription,designer;
    private double price;
    private int depth,height,width;
    public static List<Furniture> list;

    public Furniture(String id, String name, String category, double price, String sellableOnline, String link, String shortDescription, String designer, int depth, int height, int width) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.sellableOnline = sellableOnline;
        this.link = link;
        this.shortDescription = shortDescription;
        this.designer = designer;
        this.price = price;
        this.depth = depth;
        this.height = height;
        this.width = width;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getSellableOnline() {
        return sellableOnline;
    }

    public String getLink() {
        return link;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDesigner() {
        return designer;
    }

    public double getPrice() {
        return price;
    }

    public int getDepth() {
        return depth;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSellableOnline(String sellableOnline) {
        this.sellableOnline = sellableOnline;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    public static void populateList(){
       list = File.read("furniture", Furniture.class);
    }
}
