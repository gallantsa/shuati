package 创建型模式.单例模式.懒汉式;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShoppingCartManager cart = ShoppingCartManager.getInstance();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String itemName = sc.next();
            int quantity = sc.nextInt();

            cart.addToCart(itemName, quantity);
        }

        cart.viewCart();
    }
}

class ShoppingCartManager {
    public static ShoppingCartManager instance;

    private Map<String, Integer> cart;

    private ShoppingCartManager() {
        cart = new LinkedHashMap<>();

    }

    public static synchronized ShoppingCartManager getInstance() {
        if (instance == null) instance = new ShoppingCartManager();
        return instance;
    }

    public void addToCart(String itemName, int quantity) {
        cart.put(itemName, cart.getOrDefault(itemName, 0) + quantity);
    }

    public void viewCart() {
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + ' ' + entry.getValue());
        }
    }
}