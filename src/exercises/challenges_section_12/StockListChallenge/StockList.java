package exercises.challenges_section_12.StockListChallenge;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new TreeMap<>();
    }
    public int addStock(StockItem item){
        if(item!=null){
            StockItem inStock = list.getOrDefault(item.getName(), item);
            if(inStock!=item){
                item.addStock(inStock.getStock());
            }
            list.put(item.getName(), item);
            return item.getStock();
        }
        return 0;
    }

    public int sellStock(String item, int qty){
        StockItem inStock = list.getOrDefault(item, null);
        if((inStock!=null) && (inStock.getStock() >= 0) && (qty > 0)){
            inStock.addStock(-qty);
            inStock.resetReserved();
            return qty;
        }
        return 0;
    }

    public StockItem getItem(String item){
        return list.getOrDefault(item, null);
    }
    public Map<String, StockItem> Items(){
        return Collections.unmodifiableMap(list); // read-only view
    }

    @Override
    public String toString() {
        String s = "~~~~~~~~~~\nStock List\n";
        double totalCost=0.0;
        for(Map.Entry<String, StockItem> i: list.entrySet()){
            StockItem item = i.getValue();
            int val = item.getStock();
            s = s + item + " - " + (i.getValue().getReservedItem()>=0 ?(val - i.getValue().getReservedItem()):0) + " / " + val + "\n";
            totalCost += val;
        }
        return s + "TOTAL: " + String.format("%.2f", totalCost) + "\n~~~~~~~~~~";
    }
}
