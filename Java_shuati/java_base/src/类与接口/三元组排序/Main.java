package 类与接口.三元组排序;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Data[] datas = new Data[n];
        for (int i = 0; i < n; i ++ )
            datas[i] = new Data(sc.nextInt(), sc.nextDouble(), sc.next());

        Arrays.sort(datas);

        for (Data data: datas)
            System.out.printf("%d %.2f %s\n", data.x, data.y, data.z);

    }
}

class Data implements Comparable<Data> {
    int x;
    double y;
    String z;

    public Data(int x, double y, String z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int compareTo(Data o) {
        return x - o.x;
    }
}

