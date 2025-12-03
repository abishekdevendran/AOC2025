package work.abishek;

import java.util.List;

public final class Day03 {
    private final List<String> lines;

    public Day03(List<String> lines) {
        this.lines = lines;
    }

    // static long joltage(String l) {
    //     // Find the largest digit in length-1
    //     int len = l.length();
    //     int a = '0';
    //     int idx_a = -1;
    //     for (int i = 0; i < len - 1; i++) {
    //         if (l.charAt(i) > a) {
    //             idx_a = i;
    //             a = l.charAt(i);
    //         }
    //     }
    //     // Find second-largest digit in substring
    //     int b = '0';
    //     for (int i = idx_a + 1; i < len; i++) {
    //         if (l.charAt(i) > b) {
    //             b = l.charAt(i);
    //         }
    //     }
    //     return (a - '0') * 10 + (b - '0');
    // }

    static long joltage(String l, int MAX_DIGITS) {
        var ans = new StringBuilder();
        int n = l.length();
        int idx = -1;
        for (int i = 0; i < MAX_DIGITS; i++) {
            var digit = '0';
            // System.out.println("Iter from idx: " + (idx + 1) + " to " + (n - MAX_DIGITS + i));
            for (int j = idx + 1; j <= n - MAX_DIGITS + i; j++) {
                if (l.charAt(j) > digit) {
                    idx = j;
                    digit = l.charAt(j);
                    // Optimization, can't beat 9!
                    if (digit == '9') {
                        break;
                    }
                }
            }
            ans.append(digit);
        }
        return Long.parseLong(ans.toString());
    }

    static long joltage(String l) {
        return joltage(l, 2);
    }

    public long p1() {
        return lines.stream()
                .mapToLong(Day03::joltage)   // Returns primitive long
                .sum();                       // Pure primitive math (CPU friendly)
    }

    public long p2() {
        return lines.stream().mapToLong((el) -> joltage(el, 12)).sum();
    }
}
