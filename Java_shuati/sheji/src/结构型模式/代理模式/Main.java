package 结构型模式.代理模式;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HomePurchase buyerProxy = new HomeAgentProxy();

        int n = sc.nextInt();
        while (n-- > 0) {
            int area = sc.nextInt();
            buyerProxy.requestPurchase(area);
        }

        sc.close();
    }
}

// 抽象主题
interface HomePurchase {
    void requestPurchase(int area);
}

// 真实主题
class HomeBuyer implements HomePurchase {
    @Override
    public void requestPurchase(int area) {
        System.out.println("YES");
    }
}

// 代理类
class HomeAgentProxy implements HomePurchase {
    private HomeBuyer homeBuyer = new HomeBuyer();

    @Override
    public void requestPurchase(int area) {
        if (area > 100) {
            homeBuyer.requestPurchase(area);
        } else {
            System.out.println("NO");
        }
    }
}

