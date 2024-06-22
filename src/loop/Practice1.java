package loop;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * 다양한 조건을 만족하는지 체크하는 문제
 * 비밀번호 문자 규칙 설정(숫자, 소문자, 대문자, 특수문자 각 최소 1회
 * 연속 3회, 오름차순으로 연속 3회, 내림차순으로 연속 3회 제한
 * 문자 길이 6 ~ 20(include)
 */

public class Practice1 {
    public boolean solution(String s) {
        if (s.length() < 6 || s.length() > 20) {
            return false;
        }

        boolean lower = false, upper = false;
        boolean digit = false, special = false;

        Set<Character> specialSet = "!@#$%^&*()".chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        for(char c : s.toCharArray()) {
            if (specialSet.contains(c)) {
                special = true;
            }
            if (Character.isDigit(c)) {
                digit = true;
            }
            if (Character.isUpperCase(c)) {
                upper = true;
            }
            if (Character.isLowerCase(c)) {
                lower = true;
            }

            if (special && digit && upper && lower) {
                break;
            }
        }

        if (!(special && digit && upper && lower)) {
            return false;
        }

        int repeat = 0;
        int ascend = 0;
        int descend = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                repeat++;
                ascend = 0;
                descend = 0;
            } else if (s.charAt(i) - s.charAt(i - 1) == 1) {
                ascend++;
                repeat = 0;
                descend = 0;
            } else if (s.charAt(i) - s.charAt(i - 1) == -1) {
                descend++;
                repeat = 0;
                ascend = 0;
            } else {
                descend = 0;
                repeat = 0;
                ascend = 0;
            }

            if (repeat == 2 || ascend == 2 || descend == 2) {
                return false;
            }
        }
        return true;
    }
}

class Test {
    public static void main(String[] args) {
        // String s = "zeRoBase!423";
        // System.out.println(new Solution().solution(s));

        System.out.println(Character.isUpperCase('#'));
    }
}
