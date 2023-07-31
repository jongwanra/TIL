package level2.타켓넘버;

public class SolutionByDFS {
    private int dfs(int[] numbers, int depth, int sum, int target) {
        // 종료 조건
        if (numbers.length == depth) {
            return sum == target ? 1: 0;
        }

        return dfs(numbers, depth + 1, sum  + numbers[depth], target)
                + dfs(numbers, depth + 1, sum  + -numbers[depth], target);
    }
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }
    public static void main(String[] args) {
        SolutionByDFS solution = new SolutionByDFS();
        solution.solution(new int[]{4, 1, 2, 1}, 4);



    }
}
