package 创建型模式.单例模式.懒汉式;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        ShoppingCartManager2 cart = ShoppingCartManager2.getInstance();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String itemName = sc.next();
            int quantity = sc.nextInt();

            cart.addToCart(itemName, quantity);
        }

        cart.viewCart();
    }
}

// 优化版
class ShoppingCartManager2 {
    public static ShoppingCartManager2 instance;

    private Map<String, Integer> cart;

    private ShoppingCartManager2() {
        cart = new LinkedHashMap<>();

    }

    // 双重检查锁定
    public static ShoppingCartManager2 getInstance() {
        if (instance == null) {
            synchronized (ShoppingCartManager2.class) {
                if (instance == null) {
                    instance = new ShoppingCartManager2();
                }
            }
        }
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