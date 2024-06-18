package dp;

//프로그래머스 3 * n 타일링
//dp
//모듈러 법칙
//규칙 찾는 것이 중요

public class Practice1 {
    public int solution(int n){
        if (n % 2 != 0) {
            return 0;
        }

        final int MOD = 1000000007;

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[2] = 3;
        dp[4] = 11;

        for (int i = 6; i < n + 1; i += 2) {
            dp[i] = dp[i - 2] *3;
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] += dp[j] * 2;
            }
            dp[i] %= MOD;
        }

        return (int) dp[n] % MOD;
    }
}

class Test {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(new Practice1().solution(n));
    }
}
