package work.abishek.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputReaderTest {
    @Test
    void shouldReadFile() {
        // Act
        List<String> lines = InputReader.read("testcases/day01/p1_sample.txt");

        // Assert
        assertThat(lines).hasSize(3);
        assertThat(lines.getFirst()).isEqualTo("1000");
    }
}