package priorityQueue;

import java.util.PriorityQueue;

/*
 * 점수 배열이 주어짐
 * 한 번에 최대로 움직일 수 있는 범위는 k
 * 머무를 때마다 머문 인덱스의 배열값만큼 점수가 더해짐
 * 점수를 최대로 만들 수 있게 하기
 */

public class Practice {
    public int solution(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        //(x,y) : (누적점수, 인덱스)

        //초기값
        pq.offer(new int[] {arr[0], 0});

        //0부터 지나는 위치의 모든 값을 우선순위 큐에 넣어줌
        //누적된 합계 중 가장 큰 값에 현재 위치값을 더함
        //누적된 합계가 아무리 크더라도 k를 더해 현재 위치에 올 수 없다면 빼주어야 함(범위 밖의 값)
        for (int i = 1; i < arr.length; i++) {
            while (!pq.isEmpty() && pq.peek()[1] + k < i) {
                pq.poll();
            }
            pq.offer(new int[] {pq.peek()[0] + arr[i], i});
        }

        while (pq.peek()[1] != arr.length - 1) {
            pq.poll();
        }

        return pq.peek()[0];

    }
}

class Test {
    public static void main(String[] args) {
        int[] arr = {1, -1, -20, 4, -7, 5};
        int k = 2;
        System.out.println(new Practice().solution(arr, k));
    }
}

