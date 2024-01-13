package 结构型模式.享元模式;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShapeFactory factory = new ShapeFactory();

        while (scanner.hasNext()) {
            String command = scanner.nextLine();
            processCommand(factory, command);
        }
    }

    private static void processCommand(ShapeFactory factory, String command) {
        String[] parts = command.split(" ");
        ShapeType type = ShapeType.valueOf(parts[0]);
        int x = Integer.parseInt(parts[1]);
        int y = Integer.parseInt(parts[2]);

        Shape shape = factory.getShape(type);
        shape.draw(new Position(x, y));
        ((ConcreteShape) shape).setFirstTime(false);
    }
}

enum ShapeType {
    CIRCLE, RECTANGLE, TRIANGLE
}

class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

interface Shape {
    void draw(Position position);
}

class ConcreteShape implements Shape {
    private ShapeType shapeType;

    public ConcreteShape(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    @Override
    public void draw(Position position) {
        System.out.println(shapeType + (isFirstTime ? " drawn" : " shared") + " at (" + position.getX() + ", " + position.getY() + ")");
    }

    private boolean isFirstTime = true;

    public void setFirstTime(boolean firstTime) {
        isFirstTime = firstTime;
    }
}

class ShapeFactory {
    private Map<ShapeType, Shape> shapes = new HashMap<>();

    public Shape getShape(ShapeType type) {
        if (!shapes.containsKey(type)) {
            shapes.put(type, new ConcreteShape(type));
        }
        return shapes.get(type);
    }
}

