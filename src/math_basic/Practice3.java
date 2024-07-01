package math_basic;

/*
 * 배열 nums가 주어진다.
 * nums의 길이는 3 * n
 * 배열 nums에서 길이 n의 배열만큼 원소를 제거한 뒤
 * 앞의 n 개의 원소를 더한 값 sumFirst
 * 뒤의 n 개의 원소를 더한 값 sumSecond
 * diff = sumFirst - sumSecond
 * diff의 최소값을 구하는 문제
 *
 * 각 위치에서 누적합을 구하여 경우의 수를 찾는다
 * 4부터 6까지의 누적합은 6까지의 누적합에서 3 까지의 누적합을 뺀 값과 같다는 원리를 활용한다.
 * 제거하는 배열을 슬라이딩윈도우처럼 옮겨가면서 케이스를 찾는 것?
 */

public class Practice3 {
    public int solution(int[] nums) {
        int[] cumSum = new int[nums.length];
        cumSum[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            cumSum[i] = nums[i - 1] + nums[i];
        }
        int n = nums.length / 3;
        int sumFirst = 0;
        int sumSecond = 0;
        int minDiff = Integer.MAX_VALUE;

        sumSecond = cumSum[3 * n - 1] - cumSum[2 * n - 1];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sumFirst = cumSum[2 * n - 1] - cumSum[n - 1];
            } else {
                sumFirst = cumSum[i - 1] + cumSum[2 * n - 1] - cumSum[n + i - 1];
            }
            int diff = sumFirst - sumSecond;
            minDiff = Math.min(diff, minDiff);
        }

        sumFirst = cumSum[n - 1];
        for (int i = 0; i < n + 1; i++) {
            if (i == 0) {
                sumSecond = cumSum[2 * n - 1] - cumSum[n - 1];
            } else {
                sumSecond =
                        cumSum[2 * n - 1 - i] - cumSum[n - 1] + cumSum[3 * n - 1] - cumSum[3 * n - 1 - i];
            }
            int diff = sumFirst - sumSecond;
            minDiff = Math.min(diff, minDiff);
        }
        return minDiff;
    }
}

class Test3 {
    public static void main(String[] args) {
        int[] nums = {7, 9, 5, 8, 1, 3};
        System.out.println(new Practice3().solution(nums));
    }
}
