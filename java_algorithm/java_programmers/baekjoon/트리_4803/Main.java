package baekjoon.트리_4803;

import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private boolean dfs(ArrayList<ArrayList<Integer>> graph, ArrayList<Boolean> visited, int current) {
        // 종료 조건
        if (visited.get(current)) {
            return false;
        }

        visited.set(current, true);
        for(Integer injectVertex: graph.get(current)) {
           return dfs(graph, visited, injectVertex);
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        Main solution = new Main();
        Scanner sc = new Scanner(System.in);

        while (true) {
            int totalVertex = sc.nextInt();
            int totalEdge = sc.nextInt();
            if (totalVertex == 0) {
                break;
            }

            if(totalEdge == 0) {
                System.out.println("Case 2: There is one tree.");
                continue;
            }
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>(totalVertex + 1);
            ArrayList<Boolean> visited = new ArrayList<>(totalVertex + 1);
            int treeCount = 0;
            for(int loop = 0; loop < totalVertex + 1; loop++) {
                graph.add(new ArrayList<>());
                visited.add(false);
            }

            for (int loop = 0; loop < totalEdge; loop++) {

                int vertex = sc.nextInt();
                int edge = sc.nextInt();

                graph.get(vertex).add(edge);
                graph.get(edge).add(vertex);
            }


            for (int i = 1; i < visited.size(); i++) {
                if(visited.get(i)) {
                    continue;
                }
                if(graph.get(i).size() == 0) {
                    continue;
                }
                if(solution.dfs(graph, visited, i)) {
                    treeCount++;
                }
            }

            if(treeCount == 0) {
                System.out.println("Case 3: No trees.");
            }else if (treeCount == 1) {
                System.out.println("Case 2: There is one tree.");
            }else {
                System.out.println("Case 1: A forest of " + treeCount + " trees.");
            }

        }

     }
}
