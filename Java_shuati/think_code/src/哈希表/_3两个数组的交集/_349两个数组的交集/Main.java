package 哈希表._3两个数组的交集._349两个数组的交集;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int num: nums1) {
            set1.add(num);
        }

        for(int num: nums2) {
            if (set1.contains(num)) set2.add(num);
        }

        return set2.stream().mapToInt(x -> x).toArray();
    }
}