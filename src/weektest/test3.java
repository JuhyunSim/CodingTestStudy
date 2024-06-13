package weektest;

public class test3 {
    public String solution(String s, int k) {
        if (s.length() == k) {
            return "0";
        }
        int maxIdx = 0;
        //k 앞에 0이 있다면?(k포함)
        if (s.substring(0, k + 1).contains("0")) {
            int count = 0;
            int lastIdx = s.substring(0, k + 1).lastIndexOf('0');
            for (int i = 0; i < lastIdx; i++) {
                if (s.charAt(i) != '0') {
                    count++;
                }
            }
            s = s.substring(k);
            if (s.isEmpty()) return "0";
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < k - count; i++) {
                for(int j = 0; j < s.length(); j++) {
                    if(max < Character.getNumericValue(s.charAt(j))) {
                        max = Character.getNumericValue(s.charAt(j));
                        maxIdx = j;
                    }
                }
                s = s.substring(0, maxIdx) + s.substring(maxIdx + 1);
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '0') {
                    s = s.substring(i);
                    break;
                }
            }
            if (s.charAt(0) == '0' || s.isEmpty()) {
                return "0";
            }
            return s;
        }

        //k 앞에 0이 없다면?
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            for(int j = 0; j < s.length(); j++) {
                if(max < Character.getNumericValue(s.charAt(j))) {
                    max = Character.getNumericValue(s.charAt(j));
                    maxIdx = j;
                }
            }
            s = s.substring(0, maxIdx) + s.substring(maxIdx + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                s = s.substring(i);
                break;
            }
        }
        if (s.charAt(0) == '0') {
            return "0";
        }
        return s;
    }
}

class testMain3 {
    public static void main(String[] args) {
        int k = 3;
        String s = "1000";
        System.out.println(new test3().solution(s, k));
    }
}
