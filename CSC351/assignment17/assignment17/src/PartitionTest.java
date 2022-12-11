import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionTest {
    @Test
    void bookExampleRight() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayList<ArrayList<Integer>> expectedAnswer = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)),
                        new ArrayList<>(Arrays.asList(6, 7)),
                        new ArrayList<>(Arrays.asList(8, 9))));
        Partition p = new Partition();
        p.partition(array, 3);
        Assertions.assertEquals(expectedAnswer, p.getAnswerList());
    }

    @Test
    void bookExampleLeft() {
        int[] array = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        ArrayList<ArrayList<Integer>> expectedAnswer = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1, 1, 1)),
                        new ArrayList<>(Arrays.asList(1, 1, 1)),
                        new ArrayList<>(Arrays.asList(1, 1, 1))));
        Partition p = new Partition();
        p.partition(array, 3);
        Assertions.assertEquals(expectedAnswer, p.getAnswerList());
    }

    @Test
    void addTo1500WithTwoSplits() {
        int[] array = {10, 990, 100, 100, 100, 100, 100, 500, 200, 600, 200};
        ArrayList<ArrayList<Integer>> expectedAnswer = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(10, 990, 100, 100, 100, 100, 100)),
                        new ArrayList<>(Arrays.asList(500, 200, 600, 200))));
        Partition p = new Partition();
        p.partition(array, 2);
        Assertions.assertEquals(expectedAnswer, p.getAnswerList());
    }

    @Test
    void addTo200WithThreeSplits() {
        int[] array = {100, 100, 200, 50, 50, 50, 50};
        ArrayList<ArrayList<Integer>> expectedAnswer = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(100, 100)),
                        new ArrayList<>(List.of(200)),
                        new ArrayList<>(Arrays.asList(50, 50, 50, 50))));
        Partition p = new Partition();
        p.partition(array, 3);
        Assertions.assertEquals(expectedAnswer, p.getAnswerList());
    }

    @Test
    void addTo1000WithThreeSplits() {
        int[] array = {10, 990, 100, 100, 100, 100, 100, 500, 200, 600, 200};
        ArrayList<ArrayList<Integer>> expectedAnswer = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(10, 990)),
                        new ArrayList<>(Arrays.asList(100, 100, 100, 100, 100, 500)),
                        new ArrayList<>(Arrays.asList(200, 600, 200))));
        Partition p = new Partition();
        p.partition(array, 3);
        Assertions.assertEquals(expectedAnswer, p.getAnswerList());
    }
}
