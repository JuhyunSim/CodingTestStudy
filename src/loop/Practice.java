package loop;

import java.util.*;

//프로그래머스 영어 끝말잇기 level 1

public class Practice {
    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(Arrays.toString(new Solution2().solution(n, words)));
    }
}

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Map<String, Integer> map = new HashMap<>();

        int idx = 0;
        map.put(words[0], 1);
        for (int i = 1; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            // 앞 단어의 뒷자리로 시작되는가?
            if(words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
                idx = i;
                break;
            }
            // 이전에 나왔던 단어인가?
            if(map.get(words[i]) > 1) {
                idx = i;
                break;
            }
        }
        //누구의 몇 번째 답변?
        if (idx == 0) {
            return new int[] {0, 0};
        }
        answer[0] = idx % n + 1;
        answer[1] = idx / n + 1;

        return answer;
    }
}

class Solution2 {

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        char end = words[0].charAt(words[0].length() - 1);
        System.out.println(end);
        for (int i = 1; i < words.length; i++) {
            char start = words[i].charAt(0);
            System.out.println(start);
            if (start != end || !set.add(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                return answer;
            }
            end = words[i].charAt(words[i].length() - 1);
            System.out.println(end);
        }

        return answer;
    }



}
