package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//사전식 배열 문제

public class Practice1 {

    List<Integer> res;

    public int[] solution(int n) {
        res = new ArrayList<>();
        dfs(0, n);

        return res.stream().mapToInt(i -> i).toArray();
    }

    void dfs(int num, int n) {
        if (num > n) {
            return;
        }

        if (num > 0) {
            res.add(num);
        }

        for (int i = 0; i < 10; i++) {
            int newNum = 10 * num + i;
            if(newNum == 0) {
                continue;
            }
            dfs(newNum, n);
        }
    }
}

class Test2 {
    public static void main(String[] args) {
        int n = 500;
        System.out.println(Arrays.toString(new Practice1().solution(n)));
    }
}