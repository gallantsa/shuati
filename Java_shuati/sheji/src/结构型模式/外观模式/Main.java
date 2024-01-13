package 结构型模式.外观模式;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取输入
        int n = sc.nextInt();
        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        // 创建电源总开关外观
        PowerSwitchFacade powerSwitch = new PowerSwitchFacade();

        // 执行操作
        for (int i = 0; i < n; i++) {
            powerSwitch.turnOffDevice(input[i]);
        }
    }
}

class AirConditioner {
    public void off() {
        System.out.println("Air Conditioner is turned off.");
    }
}

class DeskLamp {
    public void off() {
        System.out.println("Desk Lamp is turned off.");
    }
}

class Television {
    public void off() {
        System.out.println("Television is turned off.");
    }
}

class PowerSwitchFacade {
    private AirConditioner airConditioner;
    private DeskLamp deskLamp;
    private Television television;

    public PowerSwitchFacade() {
        airConditioner = new AirConditioner();
        deskLamp = new DeskLamp();
        television = new Television();
    }

    public void turnOffDevice(int deviceCode) {
        switch (deviceCode) {
            case 1:
                airConditioner.off();
                break;
            case 2:
                deskLamp.off();
                break;
            case 3:
                television.off();
                break;
            case 4:
                System.out.println("All devices are off.");
                break;
            default:
                System.out.println("No such device.");
        }
    }
}