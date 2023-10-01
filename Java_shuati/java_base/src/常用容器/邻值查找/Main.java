package 常用容器.邻值查找;
// Todo 邻值查找
import java.io.*;
import java.util.*;;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] w = new int[n];
        String[] strs = br.readLine().split(" ");
        for (int i = 0; i < n; i ++ )
            w[i] = Integer.parseInt(strs[i]);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(w[0], 0);
        for (int i = 1; i < n; i ++ ) {
            Map.Entry<Integer, Integer> up = map.ceilingEntry(w[i]);
            Map.Entry<Integer, Integer> down = map.floorEntry(w[i]);

            int d = Integer.MAX_VALUE, pos = -1;
            if (up != null) {
                d = up.getKey() - w[i];
                pos = up.getValue();
            }
            if (down != null && w[i] - down.getKey() <= d) {
                d = w[i] - down.getKey();
                pos = down.getValue();
            }

            bw.write(d + " " + (pos + 1) + "\n");
            map.put(w[i], i);
        }

        bw.flush();
    }
}

