package dynamicProgramming;

//코인을 최소로 바꾸기

import java.util.Arrays;

public class Dp_1 {
    public int solution(int money, int[] chips) {

        int[] dp = new int[money + 1];
        dp[0] = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i <= money; i++) {
            for (int j = 0; j < chips.length; j++) {
                if (i >= chips[j]) {
                    if (dp[i - chips[j]] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[i - chips[j]] + 1);
                    }
                }
            }
        }

        return dp[money];
    }
}

class Test {
    public static void main(String[] args) {
        int money = 3000;
        int[] chips = {1100, 500, 200, 150, 25};
        System.out.println(new Dp_1().solution(money, chips));
    }
}