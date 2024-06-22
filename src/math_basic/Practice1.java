package math_basic;

/*
 * 직선을 그렸을 때 어떤 정사각형을 지나는지 파악하는 문제
 */

public class Practice1 {
    public int solution(int N, int M) {
        // 일반적으로 직선이 지나는 정사각형의 개수 = N + M
        // 정확히 모서리가 맞아서 직선을 지나지 않는 경우의 수 = N과 M의 최대공약수
        return N + M - gcd(N, M);
    }

    // 유클리드 호제법을 이용한 최대공약수
    int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}

class Test {
    public static void main(String[] args) {
        int N = 4;
        int M = 9;
        System.out.println(new Practice1().solution(N, M));
    }
}