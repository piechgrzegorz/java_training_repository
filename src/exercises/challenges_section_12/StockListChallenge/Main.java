package exercises.challenges_section_12.StockListChallenge;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();
    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);
        temp = new StockItem("butter", 3.05, 20);
        stockList.addStock(temp);

        Basket basket1 = new Basket("1st Basket");

        buy(basket1, "bread", 51);
        buy(basket1, "butter", 7);
        System.out.println("Butter stock: " + stockList.getItem("butter").getStock());
        System.out.println("Butter reserved: " + stockList.getItem("butter").getReservedItem());

        buy(basket1, "bread", 51);
        System.out.println("Bread stock: " + stockList.getItem("bread").getStock());
        System.out.println("Bread reserved: " + stockList.getItem("bread").getReservedItem());
        buy(basket1, "bread", 9);
        printBasket(basket1);

        deleteFromBasket(basket1, "butter", 2);

        toCash(basket1);
        System.out.println("Bread stock: " + stockList.getItem("bread").getStock());
        System.out.println("Bread reserved: " + stockList.getItem("bread").getReservedItem());
        System.out.println("Butter stock: " + stockList.getItem("butter").getStock());
        System.out.println("Butter reserved: " + stockList.getItem("butter").getReservedItem());
    }

    public static boolean buy(Basket basket, String product, int qty){
        StockItem item = stockList.getItem(product);
        if(item == null){
            System.out.println("Product not available in our shop.");
            return false;
        }else if((qty + + stockList.getItem(product).getReservedItem())> stockList.getItem(product).getStock()){
            System.out.println("Requested quantity of " + product + " above our stock.");
            return false;
        }else{
            basket.addToBasket(item, qty);
            stockList.getItem(product).adjustReserved(qty);
            return true;
        }
    }
    public static boolean deleteFromBasket(Basket basket, String product, int qty){
        StockItem item = stockList.getItem(product);
        if(item == null){
            System.out.println("Product not in the basket");
            return false;
        }else{
            int result = basket.removeFromBasket(item, qty);

            if(result==0){
                System.out.println("Item " + product + " removed from the basket");
            }else{
                System.out.println(qty + " pcs of " + product + " removed from the basket.");
            }
            return true;
        }
    }
    // Below deletes product from basket completely
    public static boolean deleteFromBasket(Basket basket, String product){
        deleteFromBasket(basket, product, 9999);
        return true;
    }
    public static void toCash(Basket basket){
        System.out.println(basket.toString());
        for(Map.Entry<StockItem, Integer> line : basket.Items().entrySet()){
            stockList.sellStock(line.getKey().getName(), line.getValue());
        }
    }
    public static void printBasket(Basket basket){
        System.out.println("Contents of " + basket.getName() + ":");
        for(Map.Entry<StockItem, Integer> list : basket.getList().entrySet()){
            System.out.println(list.getKey().getName() + ": " + list.getValue() + " pcs.");
        }
    }
}
