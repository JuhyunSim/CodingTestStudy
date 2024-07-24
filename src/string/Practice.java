package string;

// 두 문자열 s, t가 있다. s를 오른쪽으로 한칸씩 옮겨서 문자열 t가 나올 수 있는지 찾는 문제
// 맨 오른쪽 문자는 맨 왼쪽으로 오게 된다.

//public class Practice {
//    public boolean solution(String s, String t) {
//        if (s.length() != t.length()) return false;
//
//        for (int i = 0; i < s.length(); i++) {
//            if (s.substring(0, s.length() - i).equals(t.substring(i)) &&
//                    s.substring(s.length() - i).equals(t.substring(0, i))
//            ) {
//                return true;
//            }
//        }
//        return false;
//    }
//}
//시간초과

public class Practice {
    public boolean solution(String s, String t) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            boolean answer = true;
            for (int j = 0; j < n; j++) {
                if (s.charAt((i + j) % n) != t.charAt(j)) {
                    answer = false;
                    break;
                }
            }
            if (answer) {
                return true;
            }
        }
        return false;
    }
}

class Test {
    public static void main(String[] args) {
        String s = "abcdef", t = "efabcd";
        System.out.println(new test_19week.Solution().solution(s, t));
    }
}
