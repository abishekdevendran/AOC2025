package work.abishek;

import org.junit.jupiter.api.Test;
import work.abishek.utils.InputReader;

import static org.assertj.core.api.Assertions.assertThat;

class Day01Test {
    @Test
    void p1_sample() {
        // Arrange
        var txt = InputReader.read("testcases/day01/p1_sample.txt");
        var soln = new Day01(txt).p1();
        assertThat(soln).isEqualTo(3);
    }

    @Test
    void p1_real() {
        // 1. Arrange: Read the big file
        // Ensure this path matches your src/main/resources folder structure EXACTLY
        var txt = InputReader.read("testcases/day01/p1.txt");

        // 2. Act: Calculate
        long ans = new Day01(txt).p1();

        // 3. Output: Print it so you can submit it
        System.out.println("Part 1 Answer: " + ans);

        assertThat(ans).isEqualTo(1011);
    }

    @Test
    void p2_sample() {
        // Arrange
        var txt = InputReader.read("testcases/day01/p1_sample.txt");
        var soln = new Day01(txt).p2();
        assertThat(soln).isEqualTo(6);
    }

    @Test
    void p2_real() {
        // 1. Arrange: Read the big file
        // Ensure this path matches your src/main/resources folder structure EXACTLY
        var txt = InputReader.read("testcases/day01/p1.txt");

        // 2. Act: Calculate
        long ans = new Day01(txt).p2();

        // 3. Output: Print it so you can submit it
        System.out.println("Part 2 Answer: " + ans);

        assertThat(ans).isEqualTo(5937);
    }
}