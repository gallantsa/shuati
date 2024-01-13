package 行为型模式.状态模式;

import java.util.Scanner;

// 状态接口
interface State {
    String handle(); // // 处理状态的方法
}

// 具体状态类
class OnState implements State {
    @Override
    public String handle() {
        return "Light is ON";
    }
}

class OffState implements State {
    @Override
    public String handle() {
        return "Light is OFF";
    }
}

class BlinkState implements State {
    @Override
    public String handle() {
        return "Light is Blinking";
    }
}

// 上下文类
class Light {
    private State state; // 当前状态

    public Light() {
        this.state = new OffState(); // 初始状态为关闭
    }

    public void setState(State state) { // 设置新的状态
        this.state = state;
    }

    public String performOperation() { // 执行当前状态的操作
        return state.handle();
    }
}

public class Main {
    public static void main(String[] args) {
        // 创建一个Scanner对象以读取用户输入
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine(); 

        Light light = new Light();
		// 处理用户输入
        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine().trim();
			// 根据输入修改灯的状态
            switch (command) {
                case "ON":
                    light.setState(new OnState());
                    break;
                case "OFF":
                    light.setState(new OffState());
                    break;
                case "BLINK":
                    light.setState(new BlinkState());
                    break;
                default:
                    System.out.println("Invalid command: " + command);
                    break;
            }
			// 显示灯的当前状态
            System.out.println(light.performOperation());
        }
    }
}