package binarySearch;

import java.util.Arrays;

/*
 * 이분탐색 문제입니다.
 * bucket[]에 바구니 위치가 있음. m개의 농구공을 던짐
 * 바구니에 농구공을 넣고 농구공이 들어 있는 바구니 간의 거리 중 가장 가까이 있는 거리가
 * 최대가 되도록 할 것
 * 모든 공이 같은 간격으로 놓일 때가 최소거리가 최대가 되는 경우
 */

public class Practice {
    public int solution(int[] buckets, int m) {
        int answer = 0;
        Arrays.sort(buckets);
        int left = 0;
        int right = buckets[buckets.length - 1];

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 1개는 들어가 있는 상태
            int n = 1;
            int last = 0;
            for (int i = 1; i < buckets.length; i++) {
                //두 공 사이의 간격이 mid 이상
                if (buckets[i] - buckets[last] >= mid) {
                    n++;
                    last = i;
                }

                //mid 이상 거리로 공을 넣을 수 있는 바구니의 개수가 m을 넘으면 바로 탈출
                if (n >= m) {
                    break;
                }
            }

            //후보가 되는 경우라면, 더 넓게 간격을 둘 수 있는지 확인
            if (n >= m) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

}

class Test {
    public static void main(String[] args) {
        int[] buckets = {1, 4, 7, 18, 19, 20};
        int m = 3;
        System.out.println(new Practice().solution(buckets, m));
    }
}