import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        /**
         * 2
         * 36
         * 37
         */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t != 0) {
            int n = in.nextInt();
            for (int i = 0; i <= n; i++) {
                if (((float) n / i )% 1 == 0) {
                    if (i * i > n) {
                        System.out.println(i);
                        break;
                    }
                }
            }
            t--;
        }
    }
}
