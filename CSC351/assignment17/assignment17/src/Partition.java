import java.util.ArrayList;
import java.util.Arrays;

public class Partition {
    private ArrayList<ArrayList<Integer>> answerList = new ArrayList<>();
    public Partition() {
    }

    public void partition(int[] array, int splits) {
        int n = array.length - 1;
        int maxN = n + 1;
        int maxSplits = splits + 1;
        int[][] valueTable = new int[maxN + 1][maxSplits + 1]; // m
        int[][] dividerTable = new int[maxN + 1][maxSplits + 1]; // d
        int[] prefixSums = new int[maxN + 1]; // p
        prefixSums[0] = 0;

        for (int i = 1; i <= n; i++) {
            prefixSums[i] = prefixSums[i - 1] + array[i];
        }

        for (int i = 1; i <= n; i++) {
            valueTable[i][1] = prefixSums[i];
        }
        for (int i = 1; i <= splits; i++) {
            valueTable[1][i] = array[1];
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= splits; j++) {
                valueTable[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= (i - 1); x++) {
                    int cost = max((valueTable[x][j - 1]), (prefixSums[i] - prefixSums[x]));
                    if (valueTable[i][j] > cost) {
                        valueTable[i][j] = cost;
                        dividerTable[i][j] = x;
                    }
                }
            }
        }
        reconstructPartition(array, dividerTable, n, splits);
    }

    private void reconstructPartition(int[] s, int[][] dividerTable, int n, int k) {
        if (k == 1) {
            printBooks(s, 0, n);
            // CHANGED 1 -> 0 THIS IS THE REASON IT WASN'T PRINTING RIGHT
        } else {
            reconstructPartition(s, dividerTable, dividerTable[n][k], k - 1);
            printBooks(s, ((dividerTable[n][k]) + 1), n);
        }
    }

    private void printBooks(int[] s, int start, int end) {
        ArrayList<Integer> answerRow = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            System.out.printf("%d ", s[i]);
            answerRow.add(s[i]);
        }
        System.out.println();
        answerList.add(answerRow);
    }

    private int max(int num1, int num2) {
        int max = num1;
        if (max < num2) {
            max = num2;
        }
        return max;
    }
    public ArrayList<ArrayList<Integer>> getAnswerList(){
        return answerList;
    }
}
