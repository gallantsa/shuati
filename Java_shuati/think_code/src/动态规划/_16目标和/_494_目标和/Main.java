package 动态规划._16目标和._494_目标和;

public class Main {
}

class Solution {
    // 一维数组版本
    // 动态规划五部曲
    // 1. 确定dp[i]的含义: 填满容量为i的背包, 有dp[i]种方法
    // 2. 确定递推公式: dp[j] += dp[j - nums[i]]
    // 3. dp数组如何初始化: dp[0] = 1
    // 4. 确定遍历顺序: 先遍历物品, 再遍历背包
    // 5. 打印dp数组: 不需要打印
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
        // 保证left大于等于零（毕竟我们定义left大于right）
        if (target < 0 && sum < -target) return 0;
        // 如果所求的left数组和为小数，则作为整数数组的nums里的任何元素自然是没有办法凑出这个小数的
        if ((target + sum) % 2 != 0) return 0;
        // 本质是求nums中是否存在一个子集, 使得这个子集的和为(target + sum) / 2
        int size = (target + sum) / 2;
        if (size < 0) size = -size;
        int[] dp = new int[size + 1];
        dp[0] = 1;

        // 遍历物品
        for (int i = 0; i < nums.length; i++) {
            // 遍历背包
            for (int j = size; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[size];
    }

    // 易于理解的二维数组版本
    public int findTargetSumWays2(int[] nums, int target) {

        // 01背包应用之“有多少种不同的填满背包最大容量的方法“
        // 易于理解的二维数组解法及详细注释

        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        // 注意nums[i] >= 0的题目条件，意味着sum也是所有nums[i]的绝对值之和
        // 这里保证了sum + target一定是大于等于零的，也就是left大于等于零（毕竟我们定义left大于right）
        if(sum < Math.abs(target)){
            return 0;
        }

        // 利用二元一次方程组将left用target和sum表示出来（替换掉right组合），详见代码随想录对此题的分析
        // 如果所求的left数组和为小数，则作为整数数组的nums里的任何元素自然是没有办法凑出这个小数的
        if((sum + target) % 2 != 0) {
            return 0;
        }

        int left = (sum + target) / 2;

        // dp[i][j]：遍历到数组第i个数时， left为j时的能装满背包的方法总数
        int[][] dp = new int[nums.length][left + 1];

        // 初始化最上行（dp[0][j])，当nums[0] == j时（注意nums[0]和j都一定是大于等于零的，因此不需要判断等于-j时的情况），有唯一一种取法可取到j，dp[0][j]此时等于1
        // 其他情况dp[0][j] = 0
        // java整数数组默认初始值为0
        for(int j = 0; j <= left; j++) {
            if(nums[0] == j) {
                dp[0][j] = 1;
            }
        }

        // 初始化最左列（dp[i][0])
        // 当从nums数组的索引0到i的部分有n个0时（n > 0)，每个0可以取+/-，因此有2的n次方中可以取到j = 0的方案
        // n = 0说明当前遍历到的数组部分没有0全为正数，因此只有一种方案可以取到j = 0（就是所有数都不取）
        int numZeros = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                numZeros++;
            }
            dp[i][0] = (int) Math.pow(2, numZeros);

        }

        // 递推公式分析：
        // 当nums[i] > j时，这时候nums[i]一定不能取，所以是dp[i - 1][j]种方案数
        // nums[i] <= j时，num[i]可取可不取，因此方案数是dp[i - 1][j] + dp[i - 1][j - nums[i]]
        // 由递推公式可知，先遍历i或j都可
        for(int i = 1; i < nums.length; i++) {
            for(int j = 1; j <= left; j++) {
                if(nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                }
            }
        }

        // 打印dp数组
        // for(int i = 0; i < nums.length; i++) {
        //     for(int j = 0; j <= left; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println("");
        // }

        return dp[nums.length - 1][left];

    }
}