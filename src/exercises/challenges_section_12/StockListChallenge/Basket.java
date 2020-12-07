package exercises.challenges_section_12.StockListChallenge;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        list = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<StockItem, Integer> getList() {
        return list;
    }

    public int addToBasket(StockItem item, int qty){
        if((item != null) && (qty > 0)){
            int inBasket = list.getOrDefault(item, 0);// get qty from list or set 0 if no entry yet
            if((inBasket+qty) <= item.getStock()){ // here is an issue
                list.put(item, inBasket + qty);
                System.out.println("Added to basket " + qty + " pcs of " + item.getName());
                return inBasket;
            }else{
                System.out.println("ELSE");
                return 0;
            }
        }
        return 0;
    }

    public int removeFromBasket(StockItem item, int qty){
        int qtyInBasket = list.get(item);
        if((item != null) && (qty > 0)){
            if(qty<qtyInBasket){
                list.replace(item, qtyInBasket, qtyInBasket - qty);
                return 1;
            }else if(qty>=qtyInBasket){
                list.remove(item);
                return 0;
            }
        }
        return 0;
    }

    public Map<StockItem, Integer> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "Basket: \n";
        for(Map.Entry<StockItem, Integer> it : list.entrySet()){
            s = s + it.getKey() + " quantity: " + it.getValue() + " , price " + it.getKey().getPrice()*it.getValue()+"\n";
        }
        return s;
    }
}
