package math_basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * numsdivided에 있는 숫자를 나눌 수 있는 수 중
 * numsdivide에서 가장 작은 수 구하기
 */

//numsDivided의 공약수 list 만들기
//numsDivide를 오름차순 정렬하고 앞에서부터 차례로 list에 포함되는 경우가 있으면 return
//numsDivided의 최소값을 나눌 수 있는 수를 공약수로 정리함(시간복잡도: O(numsDivided.min))
public class Practice2 {
    public int solution(int[] numsDivide, int[] numsDivided) {
        List<Integer> list = new ArrayList<>();
        boolean isDivided = true;
        //numsDivided에서 공약수 찾기 (list)
        int min = Arrays.stream(numsDivided).min().getAsInt();
        for (int i = 1; i < min / 2 + 1; i++) {
            for (int num : numsDivided) {
                if (num % i != 0) {
                    isDivided = false;
                    break;
                }
                isDivided = true;
            }
            if (isDivided) {
                list.add(i);
            }
        }

        Arrays.sort(numsDivide);
        //numsDivide에 포함되는 공약수 중 가장 작은 공약수
        for (int i = 0; i < numsDivide.length; i++) {
            if (list.contains(numsDivide[i])) {
                return i;
            }
        }

        return -1;
    }
}

class Test2 {
    public static void main(String[] args) {
        int[] numsDivide = {2, 9, 3, 6, 2, 4, 3};
        int[] numsDivided = {9, 18, 27, 9, 15};

        System.out.println(new Practice2().solution(numsDivide, numsDivided));
    }
}