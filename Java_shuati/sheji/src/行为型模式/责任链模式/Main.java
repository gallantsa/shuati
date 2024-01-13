package 行为型模式.责任链模式;

import java.util.Scanner;
 
// 处理者：定义接口
interface LeaveHandler {
    void handleRequest(LeaveRequest request);
}
 
// 具体处理者：可以有多个，负责具体处理，这里分为 Supervisor、Manager、Director
class Supervisor implements LeaveHandler {
    private static final int MAX_DAYS_SUPERVISOR_CAN_APPROVE = 3;
    private LeaveHandler nextHandler;
 
    public Supervisor(LeaveHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
 
    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getDays() <= MAX_DAYS_SUPERVISOR_CAN_APPROVE) {
            System.out.println(request.getName() + " Approved by Supervisor.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println(request.getName() + " Denied by Supervisor.");
        }
    }
}
 
class Manager implements LeaveHandler {
    private static final int MAX_DAYS_MANAGER_CAN_APPROVE = 7;
    private LeaveHandler nextHandler;
 
    public Manager(LeaveHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
 
    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getDays() <= MAX_DAYS_MANAGER_CAN_APPROVE) {
            System.out.println(request.getName() + " Approved by Manager.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println(request.getName() + " Denied by Manager.");
        }
    }
}
 
class Director implements LeaveHandler {
    private static final int MAX_DAYS_DIRECTOR_CAN_APPROVE = 10;
 
    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getDays() <= MAX_DAYS_DIRECTOR_CAN_APPROVE) {
            System.out.println(request.getName() + " Approved by Director.");
        } else {
            System.out.println(request.getName() + " Denied by Director.");
        }
    }
}
 
// 请求类
class LeaveRequest {
    private String name;
    private int days;
 
    public LeaveRequest(String name, int days) {
        this.name = name;
        this.days = days;
    }
 
    public String getName() {
        return name;
    }
 
    public int getDays() {
        return days;
    }
}
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        int n = scanner.nextInt();
        scanner.nextLine();  
 		// 组装职责链
        LeaveHandler director = new Director();
        LeaveHandler manager = new Manager(director);
        LeaveHandler supervisor = new Supervisor(manager);
 
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (input.length == 2) {
                String name = input[0];
                int days = Integer.parseInt(input[1]);
                LeaveRequest request = new LeaveRequest(name, days);
                supervisor.handleRequest(request);
            } else {
                System.out.println("Invalid input");
                return;
            }
        }
    }
}