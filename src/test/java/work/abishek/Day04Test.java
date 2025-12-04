package work.abishek;

import org.junit.jupiter.api.Test;
import work.abishek.utils.InputReader;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day04Test {

    @Test
    void testNeighborCountingLogic() {
        // Create a stateless manual grid for testing
        // @ . @
        // . @ .
        // @ @ @
        char[][] manualGrid = {
                {'@', '.', '@'},
                {'.', '@', '.'},
                {'@', '@', '@'}
        };

        // Create a dummy instance just to access the package-private method
        var solver = new Day04(List.of("..."));

        // 1. Top-Left (0,0) -> Neighbors: (0,1)='.', (1,0)='.', (1,1)='@'
        assertThat(solver.countNeighbors(manualGrid, 0, 0)).isEqualTo(1);

        // 2. Center (1,1) -> Surrounded by 5 '@' symbols
        assertThat(solver.countNeighbors(manualGrid, 1, 1)).isEqualTo(5);
    }

    @Test
    void p1_sample() {
        var input = InputReader.read("testcases/day04/p1_sample.txt");
        assertThat(new Day04(input).p1()).isEqualTo(13);
    }

    @Test
    void p1_real() {
        var input = InputReader.read("testcases/day04/p1.txt");
        var ans = new Day04(input).p1();
        System.out.println("Part 1 Answer: " + ans);
        assertThat(ans).isEqualTo(1533L);
    }

    @Test
    void p2_sample() {
        var input = InputReader.read("testcases/day04/p1_sample.txt");
        // From description: "In this example, a total of 43 rolls of paper can be removed."
        assertThat(new Day04(input).p2()).isEqualTo(43);
    }

    @Test
    void p2_real() {
        var input = InputReader.read("testcases/day04/p1.txt");
        var ans = new Day04(input).p2();
        System.out.println("Part 1 Answer: " + ans);
        assertThat(ans).isEqualTo(9206L);
    }
}