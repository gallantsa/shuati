package 行为型模式.解释器模式;

import java.util.Scanner;
import java.util.Stack;
// 抽象表达式接⼝
interface Expression {
    int interpret();
}
// 终结符表达式类 - 数字
class NumberExpression implements Expression {
    private int number;
    public NumberExpression(int number) {
        this.number = number;
    }
    @Override
    public int interpret() {
        return number;
    }
}
// ⾮终结符表达式类 - 加法
class AddExpression implements Expression {
    private Expression left;
    private Expression right;
    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}
// ⾮终结符表达式类 - 乘法
class MultiplyExpression implements Expression {
    private Expression left;
    private Expression right;
    public MultiplyExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public int interpret() {
        return left.interpret() * right.interpret();
    }
}
// 上下⽂类
class Context {
    private Stack<Expression> expressionStack = new Stack<>();
    public void pushExpression(Expression expression) {
        expressionStack.push(expression);
    }
    public Expression popExpression() {
        return expressionStack.pop();
    }
}
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Context context = new Context();
        // 处理⽤户输⼊的数学表达式
        while (scanner.hasNextLine()) {
            String userInput = scanner.nextLine();
            Expression expression = parseExpression(userInput);
            if (expression != null) {
                context.pushExpression(expression);
                System.out.println(expression.interpret());
            } else {
                System.out.println("Invalid expression.");
            }
        }

        scanner.close();
    }
    // 解析⽤户输⼊的数学表达式并返回相应的抽象表达式类
    private static Expression parseExpression(String userInput) {
        try {
            Stack<Expression> expressionStack = new Stack<>();
            char[] tokens = userInput.toCharArray();
            for (int i = 0; i < tokens.length; i++) {
                char token = tokens[i];
                if (Character.isDigit(token)) {
                    expressionStack.push(new
                            NumberExpression(Character.getNumericValue(token)));
                    // 如果下⼀个字符不是数字，且栈中有两个以上的元素，说明可以进⾏运算
                    if (i + 1 < tokens.length && !Character.isDigit(tokens[i + 1]) &&
                            expressionStack.size() >= 2) {
                        Expression right = expressionStack.pop();
                        Expression left = expressionStack.pop();
                        char operator = tokens[i + 1];
                        if (operator == '+') {
                            expressionStack.push(new AddExpression(left, right));
                        } else if (operator == '*') {
                            expressionStack.push(new MultiplyExpression(left, right));
                        }
                        i++; // 跳过下⼀个字符，因为已经处理过了
                    }
                } else {
                    return null; // Invalid token
                }
            }
            return expressionStack.pop();
        } catch (Exception e) {
            return null;
        }
    }
}