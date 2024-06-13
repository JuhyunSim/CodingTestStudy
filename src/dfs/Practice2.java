package dfs;

import java.util.Arrays;

//문자열을 주어진 단어로 채울 수 있는가?

public class Practice2 {
    boolean result;
    String[] wordArray;
    boolean[] visited;
    public boolean solution(String s, String[] words) {
        result = false;
        wordArray = words.clone();
        visited = new boolean[wordArray.length];
        dfs(s);
        return result;

    }

    private void dfs(String s) {
        if (s.equals("")) {
            result = true;
            return;
        }

        if (result) {
            return;
        }

        for (int i = 0; i < wordArray.length; i++) {
            if (s.startsWith(wordArray[i])) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                dfs(s.substring(wordArray[i].length()));
            }
        }
        Arrays.fill(visited, false);
    }
}

class Test3 {
    public static void main(String[] args) {
        String s = "zerozero";
        String[] words = {"zero"};
        System.out.println(new Practice2().solution(s, words));
    }
}
