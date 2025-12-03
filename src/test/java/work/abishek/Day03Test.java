package work.abishek;

import org.junit.jupiter.api.Test;
import work.abishek.utils.InputReader;

import static org.assertj.core.api.Assertions.assertThat;

class Day03Test {
    @Test
    void joltage_p1_logic() {
        // Part 1: Select exactly 2 digits
        assertThat(Day03.joltage("987654321111111")).isEqualTo(98);
        assertThat(Day03.joltage("811111111111119")).isEqualTo(89);
        assertThat(Day03.joltage("234234234234278")).isEqualTo(78);
        assertThat(Day03.joltage("818181911112111")).isEqualTo(92);
    }

    @Test
    void joltage_p2_logic() {
        // Part 2: Select exactly 12 digits
        assertThat(Day03.joltage("987654321111111", 12)).isEqualTo(987654321111L);
        assertThat(Day03.joltage("811111111111119", 12)).isEqualTo(811111111119L);
        assertThat(Day03.joltage("234234234234278", 12)).isEqualTo(434234234278L);
        assertThat(Day03.joltage("818181911112111", 12)).isEqualTo(888911112111L);
    }

    @Test
    void p1_sample() {
        // Arrange
        var ipt = InputReader.read("testcases/day03/p1_sample.txt");

        // Act
        var soln = new Day03(ipt);
        var ans = soln.p1();

        // The problem states: 98 + 89 + 78 + 92 = 357
        assertThat(ans).isEqualTo(357);
    }

    @Test
    void p1_real() {
        // Arrange
        var ipt = InputReader.read("testcases/day03/p1.txt");

        // Act
        var soln = new Day03(ipt);
        var ans = soln.p1();

        // System.out for submitting answer
        System.out.println("Part 1 soln: " + ans);

        // Answer validated
        assertThat(ans).isEqualTo(17554L);
    }

    @Test
    void p2_sample() {
        // Arrange
        var input = InputReader.read("testcases/day03/p1_sample.txt");

        // Act (Using 12 digits for P2)
        long ans = new Day03(input).p2();

        // Assert
        // 987654321111 + 811111111119 + 434234234278 + 888911112111
        assertThat(ans).isEqualTo(3121910778619L);
    }

    @Test
    void p2_real() {
        // Arrange
        var ipt = InputReader.read("testcases/day03/p1.txt");

        // Act
        var soln = new Day03(ipt);
        var ans = soln.p2();

        // System.out for submitting answer
        System.out.println("Part 2 soln: " + ans);

        // Answer validated
        assertThat(ans).isEqualTo(175053592950232L);
    }
}