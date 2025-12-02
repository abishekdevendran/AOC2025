package work.abishek;

import org.junit.jupiter.api.Test;
import work.abishek.utils.InputReader;

import static org.assertj.core.api.Assertions.assertThat;

class Day02Test {
    @Test
    void getAllInvalids() {
        var ids = Day02.invalidsGenerator(new Day02.Range(10, 200));
        System.out.println(ids);
        var ids2 = Day02.invalidsGenerator(new Day02.Range(1000, 7000));
        System.out.println("Count: " + ids2.size());
        System.out.println("First: " + ids2.getFirst());
        System.out.println("Last: " + ids2.getLast());
    }

    @Test
    void getAllFullInvalids() {
        var ids = Day02.fullInvalidsGenerator(new Day02.Range(10, 200));
        System.out.println(ids);
        var ids2 = Day02.invalidsGenerator(new Day02.Range(1000, 7000));
        System.out.println(ids2);
    }


    @Test
    void p1_sample() {
        // 1. Arrange: Read the big file
        var txt = InputReader.read("testcases/day02/p1_sample.txt");

        // 2. Act: Calculate
        long ans = new Day02(txt).p1();

        // 3. Output: Print it so you can submit it
        System.out.println("Part 1 Answer: " + ans);

        assertThat(ans).isEqualTo(1227775554L);
    }

    @Test
    void p1_real() {
        // 1. Arrange: Read the big file
        var txt = InputReader.read("testcases/day02/p1.txt");

        // 2. Act: Calculate
        long ans = new Day02(txt).p1();

        // 3. Output: Print it so you can submit it
        System.out.println("Part 1 Answer: " + ans);

        assertThat(ans).isEqualTo(53420042388L);
    }

    @Test
    void p2_sample() {
        // 1. Arrange: Read the big file
        // Ensure this path matches your src/main/resources folder structure EXACTLY
        var txt = InputReader.read("testcases/day02/p1_sample.txt");

        // 2. Act: Calculate
        long ans = new Day02(txt).p2();

        // 3. Output: Print it so you can submit it
        System.out.println("Part 2 Answer: " + ans);

        assertThat(ans).isEqualTo(4174379265L);
    }

    @Test
    void p2_real() {
        // 1. Arrange: Read the big file
        // Ensure this path matches your src/main/resources folder structure EXACTLY
        var txt = InputReader.read("testcases/day02/p1.txt");

        // 2. Act: Calculate
        long ans = new Day02(txt).p2();

        // 3. Output: Print it so you can submit it
        System.out.println("Part 2 Answer: " + ans);

        assertThat(ans).isEqualTo(69553832684L);
    }
}