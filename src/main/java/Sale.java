
import java.util.ArrayList;
import java.lang.StringBuilder;

public class Sale {
    private ArrayList<Item> items;
    private int id;
    private double payment;
    
    public ArrayList<Item> getItems() {
        return this.items;
    }
    
    public Sale(int id) {
        this.items = new ArrayList<Item>();
        this.id = id;
        this.payment = 0;
    }
    
    public void add(Item item) {
        this.items.add(item);
    }
    
    public boolean contains(Item item) {
        return this.items.contains(item);
    }
    
    public boolean remove(Item item) {
        return this.items.remove(item);
    }
    
    /**
        Attempt to accept the amount of currency provided
    
        @return true if the payment >= required
                false if < required
    */
    public boolean pay(double payment) {
        boolean totalRequired = 0;
        for (Item i : items) {
            totalRequired += i.getPrice();
        }
        
        if (payment >= totalRequired) {
            this.payment = payment;
            return true;
        }
        return false;
    }
    
    /**
        Return a string representation of all of the items in this sale
    */
    public String look() {
        StringBuilder sb = new StringBuilder();
        for (Item i : items) {
            sb.append(i.getName());
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id:" + Integer.toString(id) + ", "
                  + "payment:" + Double.toString(payment)
                  + ", items[");
        for (Item i : items) {
            sb.append(i.getName() + ", ");
        }
        sb.setLength(sb.length() - 1);
        sb.append("]");
        
        return sb.toString();
    }
}
