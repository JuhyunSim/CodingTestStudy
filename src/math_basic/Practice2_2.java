package math_basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * Practice2와 같은 문제
 * 최대 공약수를 나눌 수 있는 수를 찾기
 */

public class Practice2_2 {
    public int solution(int[] numsDivide, int[] numsDivided) {
        //중복제거
        Set<Integer> dividedSet =
                Arrays.stream(numsDivided).boxed().collect(Collectors.toSet());
        //dividedSet에서 최대공약수 찾기
        int gcd = dividedSet.stream().reduce(
                (x, y) -> gcd(x, y)
        ).get();
        //나누는 수들 중복제거 후 오름차순 정렬
        List<Integer> divisor = new ArrayList<>
                (Arrays.stream(numsDivide).boxed().collect(Collectors.toSet())
                );
        divisor.sort(Integer::compareTo);

        //최대공약수를 나눌 수 있는 수 중 가장 작은 값 반환
        for (Integer num : divisor) {
            if (gcd % num == 0) {
                return num;
            }
        }
        return -1;
    }

    int gcd(int n, int m) {
        if (m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }
}

class Test2_2 {
    public static void main(String[] args) {
        int[] numsDivide = {2, 9, 3, 6, 2, 4, 3};
        int[] numsDivided = {9, 18, 27, 9, 15};

        System.out.println(new Practice2().solution(numsDivide, numsDivided));
    }
}
