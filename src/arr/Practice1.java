package arr;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/*
배열 내에 있는 숫자들의 개수를 세고 개수를 기준으로 나열하기
개수가 같을 때는 작은 숫자가 앞으로 나오게 하기
Priority Queue 활용하여 문제 해결.
비교함수를 어떻게 넣는지 잘 기억해 둘 것
 */
public class Practice1 {
    public int[] solution(int[] nums, int k) {
         Map<Integer, Integer> map = Arrays.stream(nums).boxed()
                 .collect(Collectors.toMap(
                         x -> x,
                         x -> 1,
                         Integer::sum)
                 );

        PriorityQueue<Item> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getKey();
            int freq = entry.getValue();
            pq.offer(new Item(value, freq));
        }

        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = pq.poll().value;
        }


        return answer;
    }

    static class Item implements Comparable<Item> {
        Integer value;
        Integer frequency;

        public Item(Integer value, Integer frequency) {
            this.value = value;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Item o) {
            if (frequency == o.frequency) {
                return value - o.value;
            }
            return o.frequency - frequency;
        }
    }
}

class Test {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        int k = 3;
        System.out.println(Arrays.toString(new Practice1().solution(nums, k)));
    }
}
