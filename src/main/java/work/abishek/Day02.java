package work.abishek;

import java.util.*;

@SuppressWarnings("ClassCanBeRecord")
public class Day02 {
    private final List<Range> ranges;

    public Day02(List<String> lines) {
        this.ranges = Arrays.stream(lines.getFirst().split(",")).map(String::trim).map(Range::parse).toList();
    }

    static List<Long> invalidsGenerator(Range range) {
        List<Long> ans = new ArrayList<>();
        int maxDigits = (int) Math.log10(range.end()) + 1;
        // System.out.println("Max digits: " + maxDigits);
        for (int l = 2; l <= maxDigits; l += 2) {
            long halfLen = l / 2;
            long start = (long) Math.pow(10, halfLen - 1);
            long end = (long) Math.pow(10, halfLen) - 1;
            long multiplier = (long) Math.pow(10, halfLen) + 1;
            // System.out.println("Start: " + start + " End: " + end + " multiplier: " + multiplier);
            for (long half = start; half <= end; half += 1) {
                long el = half * multiplier;
                if (el > range.end()) {
                    break;
                }
                if (el < range.start()) {
                    continue;
                }
                ans.add(el);
            }
        }
        return ans;
    }

    static List<Long> fullInvalidsGenerator(Range range) {
        Set<Long> ans = new HashSet<>();
        // System.out.println("Max digits: " + maxDigits);
        for (long i = 1; ; i++) {
            int len = (int) Math.log10(i) + 1;
            long multiplier = (long) Math.pow(10, len);
            long curr = i * multiplier + i;
            while (true) {
                // System.out.println("Curr: " + curr);
                if (curr > range.end()) {
                    if (curr == i * multiplier + i) {
                        return ans.stream().toList();
                    }
                    break;
                }
                if (curr >= range.start()) {
                    ans.add(curr);
                }
                curr = curr * multiplier + i;
            }
        }

    }

    public long p1() {
        return this.ranges.stream().map(Day02::invalidsGenerator).flatMap(List::stream).mapToLong(Long::longValue).sum();
    }

    public long p2() {
        return this.ranges.stream().map(Day02::fullInvalidsGenerator).flatMap(List::stream).mapToLong(Long::longValue).sum();
    }

    record Range(long start, long end) {
        public static Range parse(String ipt) {
            var parts = ipt.split("-");
            return new Range(Long.parseLong(parts[0]), Long.parseLong(parts[1]));
        }
    }
}

