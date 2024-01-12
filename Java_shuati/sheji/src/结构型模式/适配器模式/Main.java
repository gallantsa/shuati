package 结构型模式.适配器模式;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取连接次数
        int N = sc.nextInt();

        while (N-- > 0) {
            // 读取用户选择
            int choice = sc.nextInt();

            // 根据用户的选择创建相应对象
            if (choice == 1) {
                TypeC newComputer = new NewComputer();
                newComputer.chargeWithTypeC();
            } else if (choice == 2) {
                USB usbAdapter = new AdapterCharger();
                usbAdapter.charge();
            }
        }
        sc.close();
    }
}

// USB 接口
interface USB {
    void charge();
}

// TypeC 适配类
interface TypeC {
    void chargeWithTypeC();
}

// 适配器类
class TypeCAdapter implements USB {
    public TypeC typeC;

    public TypeCAdapter(TypeC typeC) {
        this.typeC = typeC;
    }

    @Override
    public void charge() {
        // 调用被适配者类的方法
        typeC.chargeWithTypeC();
    }
}

// 新电脑类, 使用 TypeC 接口
class NewComputer implements TypeC {
    @Override
    public void chargeWithTypeC() {
        System.out.println("TypeC");
    }
}

// 适配器充电器类, 使用 USB 接口
class AdapterCharger implements USB {
    @Override
    public void charge() {
        System.out.println("USB Adapter");
    }
}

