package 创建型模式.工厂方法模式;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BlockFactorySystem factorySystem = new BlockFactorySystem();

        int productionCount = sc.nextInt();
        sc.nextLine(); // 读取剩余的换行符或回车符

        for (int i = 0; i < productionCount; i++) {
            String[] productionInfo = sc.nextLine().split(" ");
            String blockType = productionInfo[0];
            int quantity = Integer.parseInt(productionInfo[1]);

            if (blockType.equals("Circle")) {
                factorySystem.produceBlocks(new CircleBlockFactory(), quantity);
            } else if (blockType.equals("Square")) {
                factorySystem.produceBlocks(new SquareBlockFactory(), quantity);
            }
        }
    }
}

// 抽象积木接口
interface Block {
    void produce();
}

// 具体圆形积木实现
class CircleBlock implements Block {
    @Override
    public void produce() {
        System.out.println("Circle Block");
    }
}

// 具体方形积木实现
class SquareBlock implements Block {
    @Override
    public void produce() {
        System.out.println("Square Block");
    }
}

// 抽象积木工厂接口
interface BlockFactory {
    Block createBlock();
}

// 具体圆形积木工厂实现
class CircleBlockFactory implements BlockFactory {
    @Override
    public Block createBlock() {
        return new CircleBlock();
    }
}

// 具体方形积木工厂实现
class SquareBlockFactory implements BlockFactory {
    @Override
    public Block createBlock() {
        return new SquareBlock();
    }
}

// 积木工厂系统
class BlockFactorySystem {
    private List<Block> blocks = new ArrayList<>();

    public void produceBlocks(BlockFactory factory, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Block block = factory.createBlock();
            blocks.add(block);
            block.produce();
        }
    }

    public List<Block> getBlocks() {
        return blocks;
    }
}