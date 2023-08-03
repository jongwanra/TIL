package stack_and_queue.크레인_인형뽑기;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] board = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int moveCnt = sc.nextInt();
        int[] moves = new int[moveCnt];
        for(int i = 0; i < moveCnt; i++) {
            moves[i] = sc.nextInt();
        }

        System.out.println(m.mySolution(n, board, moveCnt, moves));
    }

    private int lectureSolution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for(int pos: moves) {
            for(int i = 0; i < board.length; i++) {
                if(board[i][pos - 1] != 0) {
                    int tmp = board[i][pos- 1];
                    board[i][pos - 1] = 0;

                    if(!stack.isEmpty() && tmp == stack.peek()) {
                        answer++;
                        stack.pop();
                    }else {
                        stack.push(tmp);
                    }
                    break;
                }
            }
        }
        return answer;
    }


    private int mySolution(int n, int[][] board, int moveCnt, int[] moves) {
        int answer = 0;
        LinkedList<Integer> stack = new LinkedList<>();

        for(int x: moves) {
            /* 해당 col에서 인형을 찾는다 밑에서부터 위로 */
            for(int row = 1; row <= n; row++) {
                int target = board[row][x];
                if(target != 0) {
                    int e = board[row][x];
                    board[row][x] = 0;
                    stack.push(e);

                    while(stack.size() >= 2) {
                        int tmp = stack.pop();
                        int tmp2 = stack.peek();

                        if(tmp != tmp2) {
                            stack.push(tmp);
                            break;
                        }
                        stack.pop();
                        answer += 2;
                    }
                    break;
                }
            }
        }
        return answer;
    }
}
