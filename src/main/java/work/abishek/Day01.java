package work.abishek;

import java.util.List;

public class Day01 {
    private final List<String> lines;

    public Day01(List<String> lines) {
        this.lines = lines;
    }

    public long p1() {
        int curr = 50;
        long ans = 0;
        for (String line : lines) {
            var inst = new Instruction(line);
            if (inst.direction() == 'L') {
                curr -= inst.magnitude();
            } else {
                curr += inst.magnitude();
            }
            curr = Math.floorMod(curr, 100);
            if (curr == 0) {
                ans += 1;
            }
        }
        return ans;
    }

    public long p2() {
        int curr = 50;
        long ans = 0;
        for (String line : lines) {
            var inst = new Instruction(line);
            ans += inst.magnitude() / 100;
            var mag = inst.magnitude() % 100;
            if (inst.direction() == 'L') {
                if (curr > 0 && curr <= mag) {
                    ans += 1;
                }
                curr -= mag;
            } else {
                if (100 - curr <= mag) {
                    ans += 1;
                }
                curr += mag;
            }
            curr = Math.floorMod(curr, 100);
        }
        return ans;
    }
}

record Instruction(char direction, int magnitude) {
    public Instruction(String raw) {
        // "this(...)" calls the MAIN constructor defined above ^^
        this(raw.charAt(0), Integer.parseInt(raw.substring(1)));
    }
}
