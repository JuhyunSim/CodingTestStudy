package weektest;

public class test1 {
    public int solution(int N, int M) {

        if (N == M) {
            return N;
        }

        if (N == 1) {
            return M;
        } else if (M == 1) {
            return N;
        }

        return N + M - 1;
    }
}
