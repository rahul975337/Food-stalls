import java.util.ArrayList;
import java.util.Arrays;

class app {
    public static void main(String[] args) {
        int n = 1;
        int m = 1;
        // int[][] acceptanceMatrix = { { 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0,
        // 0, 0, 0, 0, 0, 1 } };
        int[][] acceptanceMatrix = { { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
        // m*10
        int[][] personMatrix = { { 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 } };// n*10
        int q = 1;// queries
        int[][] queries = { { 1, 1 } };// for each row(i,j) person i can eat at stall j then 1 else 0
        System.out.println("res is:" + coupons(n, m, acceptanceMatrix, personMatrix, q, queries));

    }

    static int coupons(int n, int m, int[][] acceptanceMatrix, int[][] personMatrix, int q, int[][] queries) {
        int res = 0;
        for (int i = 0; i < q; i++) {// for each query
            int p = queries[i][0];
            int s = queries[i][1];
            int personArray[] = personMatrix[p - 1];
            ArrayList<Integer> personIndexes = new ArrayList<>();
            int stallArray[] = acceptanceMatrix[s - 1];
            ArrayList<Integer> stallIndexes = new ArrayList<>();
            for (int j = 0; j < personArray.length; j++) {
                if (personArray[j] == 1)
                    personIndexes.add(j + 1);
                if (stallArray[j] == 1)
                    stallIndexes.add(j + 1);
            }

            System.out.println(personIndexes);
            System.out.println(stallIndexes);
            for (int j = 0; j < personIndexes.size(); j++) {
                if (stallIndexes.contains(personIndexes.get(j))) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
