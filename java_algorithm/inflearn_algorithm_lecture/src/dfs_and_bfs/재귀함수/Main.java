package dfs_and_bfs.재귀함수;

public class Main {
    public void dfs(int n) {
        if(n == 0) {
            return;
        }
        dfs(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.dfs(3);
    }

}
