package arr;

import test.Solution;

import java.util.*;

public class Practice1_2 {
    public int[] solution(int[] nums, int k) {
        int[] answer = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if (map.get(o2) - map.get(o1) == 0) {
                    return o1 - o2;
                }
                return map.get(o2) - map.get(o1) > 0 ? 1 : -1;
            }
        });
        for (Integer i : map.keySet()) {
            pq.offer(i);
        }
        for (int i = 0; i < k; i++) {
            answer[i] = pq.poll();
        }

        return answer;
    }
}
class Test1_2{
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        int k = 3;
        System.out.println(Arrays.toString(new Solution().solution(nums, k)));
    }
}
