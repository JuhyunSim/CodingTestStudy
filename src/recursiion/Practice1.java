package recursiion;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//<주요 포인트>
// 큰 숫자는 BigInteger 고려
// String으로 담으면 큰 숫자를 오버로딩 없이 사용 가능
// mod는 마지막에

public class Practice1 {
    public int solution(int n, int num) {
        if (num == 0) {
            return num;
        }


        String numString = String.valueOf(num);

        for (int i = 0; i < n; i++) {
            Set<Integer> numSet = new HashSet<>();

            for (char c : numString.toCharArray()) {
                numSet.add(Character.getNumericValue(c));
            }

            List<Integer> numList = numSet.stream().sorted().toList();
            StringBuilder sb = new StringBuilder();
            for (Integer e : numList) {
                long count = numString.chars().filter(c -> c == (char)(e + '0')).count();
                sb.append(e);
                sb.append(count);
            }
            numString = sb.toString();
        }

        BigInteger bigInteger = new BigInteger(numString);
        return bigInteger.mod(new BigInteger("10004")).intValue();
    }
}

class Test {

    public static void main(String[] args) {
        int n = 3;
        int num = 54223;
        System.out.println(new Practice1().solution(n, num));
    }

}
