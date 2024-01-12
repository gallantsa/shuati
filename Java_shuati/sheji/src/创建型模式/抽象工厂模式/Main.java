package 创建型模式.抽象工厂模式;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取订单数量
        int N = sc.nextInt();

        // 处理每个订单
        while (N-- > 0) {
            // 读取家具类型
            String furnitureType = sc.next();

            // 创建相应风格的家具工厂
            FurnitureFactory factory = null;
            if (furnitureType.equals("modern")) {
                factory = new ModernFurnitureFactory();
            } else if (furnitureType.equals("classical")) {
                factory = new ClassicalFurnitureFactory();
            }

            // 根据工厂生产椅子和沙发
            Chair chair = factory.createChair();
            Sofa sofa = factory.createSofa();

            // 输出家具信息
            chair.showInfo();
            sofa.displayInfo();
        }
    }
}

// 抽象椅子接口
interface Chair {
    void showInfo();
}

// 具体现代风格椅子
class ModelChair implements Chair {
    @Override
    public void showInfo() {
        System.out.println("modern chair");
    }
}

// 具体古典风格椅子
class ClassicalChair implements Chair {
    @Override
    public void showInfo() {
        System.out.println("classical chair");
    }
}

// 抽象沙发接口
interface Sofa {
    void displayInfo();
}

// 具体现代风格沙发
class ModelSofa implements Sofa{
    @Override
    public void displayInfo() {
        System.out.println("modern sofa");
    }
}

// 具体古典风格
class ClassicalSofa implements Sofa{
    @Override
    public void displayInfo() {
        System.out.println("classical sofa");
    }
}

// 抽象家具工厂接口
interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
}

// 具体现代风格家具工厂
class ModernFurnitureFactory implements FurnitureFactory {

    @Override
    public Chair createChair() {
        return new ModelChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModelSofa();
    }
}

// 具体古典风格家具工厂
class ClassicalFurnitureFactory implements FurnitureFactory {

    @Override
    public Chair createChair() {
        return new ClassicalChair();
    }

    @Override
    public Sofa createSofa() {
        return new ClassicalSofa();
    }
}