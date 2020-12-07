package exercises.challenges_section_12.StockListChallenge;

public class StockItem implements Comparable<StockItem>{
    private final String name;
    private double price;
    private int stock;
    private int reservedItem;

    public StockItem(String name, double price) {
        this(name, price, 0);
    }

    public StockItem(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.reservedItem = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void adjustReserved(int qty){
        this.reservedItem += qty;
    }

    public void resetReserved(){
        this.reservedItem = 0;
    }

    public int getStock() {
        return stock;
    }

    public int getReservedItem() {
        return reservedItem;
    }

    public void setPrice(double price){
        if(price > 0){
            this.price = price;
        }
    }

    public void addStock(int qty){
        if((this.stock + qty) >=0){
            this.stock += qty;
        }
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == this){
            return true;
        }
        if((obj == null) || (this.getClass() != obj.getClass())){
            return false;
        }
        StockItem item = (StockItem) obj;
        if(this.name.equals(((StockItem) obj).getName())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 31 + this.name.hashCode();
    }

    @Override
    public int compareTo(StockItem o) {
        if(this == o){
            return 0;
        }
        if(o != null) {
            return this.name.compareToIgnoreCase(o.getName());
        }
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " : price " + this.price;
    }
}
