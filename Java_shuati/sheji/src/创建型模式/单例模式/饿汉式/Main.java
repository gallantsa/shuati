package 创建型模式.单例模式.饿汉式;

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

    // 饿汉模式单例
    public static final ShoppingCartManager instance = new ShoppingCartManager();

    // 购物车存储商品和数量映射
    private Map<String, Integer> cart;

    // 私有化构造方法
    private ShoppingCartManager() {
        cart = new LinkedHashMap<>();
    }

    // 获取购物车实例
    public static ShoppingCartManager getInstance() {
        return instance;
    }

    // 添加商品到购物车
    public void addToCart(String itemName, int quantity) {
        cart.put(itemName, cart.getOrDefault(itemName, 0) + quantity);
    }

    // 查看购物车
    public void viewCart() {
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + ' ' + entry.getValue());
        }
    }
}