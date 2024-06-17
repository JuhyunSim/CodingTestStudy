package bfs;

import java.util.*;

//프로그래머스 무인도 여행
//X로 막혀있는 구역(섬)의 숫자 합 더하기
//섬이 없다면 -1 반환
//dfs 풀이 가능

public class Practice2 {
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        int[][] visited = new int[maps.length][maps[0].length()];
        int[] directionI = {0, 0, 1, -1};
        int[] directionJ = {1, -1, 0, 0};

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (visited[i][j] >0 || maps[i].charAt(j) == 'X') {
                    continue;
                }
                list.add(sumMap(i, j, maps, directionI, directionJ, visited));
            }
        }
        if (list.isEmpty()) {
            return new int[] {-1};
        }
        Collections.sort(list);
        return list.stream().mapToInt(i -> i).toArray();
    }

    private int sumMap(int x, int y, String[] maps, int[] directionI, int[] directionJ, int[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        int sum = maps[x].charAt(y) - '0';
        visited[x][y] = 1;
        while (!q.isEmpty()){

            int[] newArr = q.poll();
            int i = newArr[0];
            int j = newArr[1];
            for (int l = 0; l < directionI.length; l++) {
                int newI = i + directionI[l];
                int newJ = j + directionJ[l];

                if (newI < 0 || newI >= maps.length || newJ < 0 || newJ >= maps[0].length()) {
                    continue;
                }

                if (maps[newI].charAt(newJ) == 'X' || visited[newI][newJ] > 0) {
                    continue;
                }

                visited[newI][newJ] += 1;
                q.offer(new int[]{newI, newJ});
                sum += maps[newI].charAt(newJ) - '0';
            }
        }
        return sum;
    }
}

class test {
    public static void main(String[] args) {
        String[] maps = {
                "X591X",
                "X1X5X",
                "X231X",
                "1XXX1"
        };
        System.out.println(Arrays.toString(new Practice2().solution(maps)));
    }
}
