public class ClimbingStairs70 {

    // 70. 爬楼梯 https://leetcode-cn.com/problems/climbing-stairs/

    public int climbStairs(int n) {
        if (n < 3) return n;
        int first = 1;
        int second = 2;
        int third = 0;

        while (2 < n--) {
            third = first + second;
            first = second;
            second = third;
        }

        return third;
    }
}
