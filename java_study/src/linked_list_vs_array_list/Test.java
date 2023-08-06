package linked_list_vs_array_list;

public class Test {
    public static void main(String[] args) {
        int size = 10_000;
        int[][] matrix = new int [size][size];


        //  여기
        for(int i = 0; i < size; i++) {
            for(int j = 0;j < size; j++) {
                matrix[i][j] = 0;
            }
        }


        long beforeA = System.nanoTime();

        for(int i = 0; i < size; i++) {
            int a = matrix[i][0];
        }

        long afterA = System.nanoTime();

        System.out.println("A");
        System.out.println(afterA - beforeA);
        System.out.println("-------");


        long beforeB = System.nanoTime();

        for(int i = 0; i < size; i++) {
            int a = matrix[0][i];
        }

        long afterB = System.nanoTime();

        System.out.println("B");
        System.out.println(afterB - beforeB);
        System.out.println("-------");



    }
}
