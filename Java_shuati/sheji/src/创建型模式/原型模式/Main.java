package 创建型模式.原型模式;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取需要创建的矩形数量
        int N = sc.nextInt();

        // 读取每个举行的属性信息并创建矩形对象
        while (N-- > 0) {
            String color = sc.next();
            int width = sc.nextInt();
            int height = sc.nextInt();

            // 创建原型对象
            Prototype originalRectangle = new RectanglePrototype(color, width, height);

            // 克隆对象并输出详细信息
            Prototype clonedRectangle = originalRectangle.clone();
            System.out.println(clonedRectangle.getDetails());
        }
    }
}

// 抽象原型类
abstract class Prototype implements Cloneable {
    public abstract Prototype clone();
    public abstract String getDetails();

    // 公共的clone方法
    public Prototype clonePrototype() {
        try {
            return (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

// 具体矩形原型类
class RectanglePrototype extends Prototype {
    private String color;
    private int width;
    private int height;

    public RectanglePrototype(String color, int width, int height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }

    @Override
    public Prototype clone() {
        return clonePrototype();
    }

    @Override
    public String getDetails() {
        return "Color: " + color + ", Width: " + width + ", Height: " + height;
    }
}
