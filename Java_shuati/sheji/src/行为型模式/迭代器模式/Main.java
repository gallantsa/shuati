package 行为型模式.迭代器模式;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 可迭代对象接口
interface StudentCollection {
    java.util.Iterator<Student> iterator();
}

// 具体可迭代对象
class ConcreteStudentCollection implements StudentCollection {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public java.util.Iterator<Student> iterator() {
        return new ConcreteStudentIterator(students);
    }
}

// 迭代器接口
interface Iterator<T> {
    boolean hasNext();

    T next();
}

// 具体迭代器
class ConcreteStudentIterator implements java.util.Iterator<Student> {
    private List<Student> students;
    private int currentIndex = 0;

    public ConcreteStudentIterator(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < students.size();
    }

    @Override
    public Student next() {
        if (hasNext()) {
            Student student = students.get(currentIndex);
            currentIndex++;
            return student;
        }
        return null;
    }
}

// 学生类
class Student {
    private String name;
    private String studentId;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取学生数量
        int n = scanner.nextInt();
        scanner.nextLine(); // 读取换行符

        // 创建具体可迭代对象
        ConcreteStudentCollection studentCollection = new ConcreteStudentCollection();

        // 读取学生信息并添加到集合
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (input.length == 2) {
                String name = input[0];
                String studentId = input[1];
                Student student = new Student(name, studentId);
                studentCollection.addStudent(student);
            } else {
                System.out.println("Invalid input");
                return;
            }
        }

        // 使用迭代器遍历学生集合
        java.util.Iterator<Student> iterator = studentCollection.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student.getName() + " " + student.getStudentId());
        }
    }
}

