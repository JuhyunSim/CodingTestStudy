package bfs;

//bfs 기본문제
//미로 탈출하기
//세로 N, 가로 M 크기의 정수배열이 주어짐
//현재 위치는 0,0 / 도착지점은 N-1, M-1
//도착지점까직 갈 수 있는 최소거리 구하기(숫자 1은 이동할 수 없는 곳, 도착지에 도달할 수 없다면 -1 반환)

import java.util.LinkedList;
import java.util.Queue;

public class Practice1 {

    public int solution(int N, int M, int[][] maze) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0}); //현재위치
        //이동을 위한 배열(오른쪽, 왼쪽, 아래, 위 순으로 이동)
        int[] diArr = {0, 0, 1, -1};
        int[] djArr = {1, -1, 0, 0};

        int[][] visited = new int[N][M]; //방문여부, 이동횟수 기록

        while (!q.isEmpty()) {
            int[] ints = q.poll();
            int i = ints[0], j = ints[1];

            if (i == N - 1 && j == M - 1 ) {
                return visited[i][j];
            }

            for (int k = 0; k < diArr.length; k++) {
                int newI = i + diArr[k];
                int newJ = j + djArr[k];

                if (newI < 0 || newI >= N || newJ < 0 || newJ >= M) {
                    continue;
                }

                if (maze[newI][newJ] == 0 && visited[newI][newJ] == 0) {
                    q.offer(new int[]{newI, newJ});
                    visited[newI][newJ] = visited[i][j] + 1;
                }
            }
        }
        return -1;

    }
}

class Test {
    public static void main(String[] args) {
        int N = 6;
        int M = 6;
        int[][] maze = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0},
                {1, 1, 1, 0, 0, 0}
        };
        System.out.println(new Practice1().solution(N, M, maze));
    }
}
