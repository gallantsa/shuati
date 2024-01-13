package 结构型模式.桥接模式;

import java.util.Scanner;

// 步骤5: 客户端代码
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        while (N -- > 0) {
            String[] input = sc.nextLine().split(" ");
            int brand = Integer.parseInt(input[0]);
            int operation = Integer.parseInt(input[1]);

            TV tv = null;
            if (brand == 0) {
                tv = new SonyTV();
            } else {
                tv = new TCLTV();
            }

            RemoteControl remoteControl = null;
            if (operation == 2) {
                remoteControl = new PowerOperation(tv);
            } else if (operation == 3) {
                remoteControl = new OffOperation(tv);
            } else {
                remoteControl = new ChannelSwitchOperation(tv);
            }

            remoteControl.performOperation();
        }

        sc.close();
    }
}

// 步骤1: 创建实现化接口
interface TV {
    void turnOn();
    void turnOff();
    void switchChannel();
}

// 步骤2: 创建具体实现化类
class SonyTV implements TV {
    @Override
    public void turnOn() {
        System.out.println("Sony TV is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Sony TV is OFF");
    }

    @Override
    public void switchChannel() {
        System.out.println("Switching Sony TV channel");
    }
}

class TCLTV implements TV {
    @Override
    public void turnOn() {
        System.out.println("TCL TV is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("TCL TV is OFF");
    }

    @Override
    public void switchChannel() {
        System.out.println("Switching TCL TV channel");
    }
}

// 步骤3: 创建抽象化接口
abstract class RemoteControl {
    protected TV tv;

    public RemoteControl(TV tv) {
        this.tv = tv;
    }

    abstract void performOperation();
}

// 步骤4: 创建扩展抽象化类
class PowerOperation extends RemoteControl {
    public PowerOperation(TV tv) {
        super(tv);
    }

    @Override
    void performOperation() {
        tv.turnOn();
    }
}

class OffOperation extends RemoteControl {
    public OffOperation(TV tv) {
        super(tv);
    }

    @Override
    void performOperation() {
        tv.turnOff();
    }
}

class ChannelSwitchOperation extends RemoteControl {
    public ChannelSwitchOperation(TV tv) {
        super(tv);
    }

    @Override
    void performOperation() {
        tv.switchChannel();
    }
}