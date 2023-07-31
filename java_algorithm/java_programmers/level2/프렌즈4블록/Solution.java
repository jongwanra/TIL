package level2.프렌즈4블록;
import java.lang.reflect.Array;
import java.util.Arrays;
// [1차] 프렌즈4블록
// https://school.programmers.co.kr/learn/courses/30/lessons/17679


// 접근 방법
// 1. 4개가 곂쳐있는 공간들을 찾아서 0으로 만든다
// 2. 다 밑으로 한칸 씩 내린다
// 실패..!!


// 재시도 접근 방법
// 1. 게임 시 사라질 친구들을 전부 체크한다.
// 2. 체크한 이후에 전부 카운팅
// 3. 비어진 공간을 전부 내린다
class Solution {

    private boolean checkFourBlock (char[][] board, int width, int height) {
        char target = board[height][width];

        if ( target == '/') {
            return  false;
        }
        if (target != board[height + 1][width]){
            return false;
        }
        if (target != board[height][width + 1]){
            return false;
        }
        if (target != board[height + 1][width + 1]){
            return false;
        }
        return true;
    }

    private int checkBlockAndGetCount(char[][] board, int width, int height ) {
        int count = 0;
        boolean[][] matrix = new boolean[height][width];

        // Block을 통해 사라질 요소들을 matrix에 true로 표시
        for (int h = 0;  h < height - 1; h++) {
            for(int w = 0; w < width - 1; w++) {
                if(checkFourBlock(board, w, h)){
                    matrix[h][w] = true;
                    matrix[h + 1][w] = true;
                    matrix[h][w + 1] = true;
                    matrix[h + 1][w + 1] = true;
                }
            }
        }

        // 이후에 board 업데이트
        for (int h = 0;  h < height; h++) {
           for (int w = 0; w < width; w++) {
                if (matrix[h][w]) {
                    count++;
                    board[h][w] = '/';
                }
            }
        }

        // 갯수 반환
        return count;
    }

    private void dropDownBlock(char[][] matrix) {
        // col 한개씩 우선적으로 전부 내리는 개념으로 들어가자. start Idx 잡고 endIdx 잡자
        int width = matrix[0].length;
        int height = matrix.length;

        for (int w = 0; w < width; w++) {
            int startIdx = -1;
            int endIdx = -1;
            for(int h = height - 1; h > 0; h--) {
                if ( matrix[h][w] == '/') {
                    startIdx = h;
                    endIdx = h - 1;
                    break;
                }
            }

            if ( startIdx == -1 || endIdx < 0) {
                continue;
            }

            for (int h = endIdx; h >= 0; h--) {
                if(matrix[startIdx][w] != '/') {
                    break;
                }
                // endIndex
                if(matrix[h][w] == '/') {
                    continue;
                }
                matrix[startIdx][w] = matrix[h][w];
                matrix[h][w] = '/';
                startIdx--;
            }

        }
    }
    public int solution(int m, int n, String[] board) {
        int height = m;
        int width = n;
        int answer = 0;

        char[][] newBoard = new char[height][width];

        // 초기 셋팅
        for(int h = 0; h < height; h++) {
            for(int w = 0; w < width; w++) {
                newBoard[h][w] = board[h].charAt(w);
            }
        }

        while(true) {
            // check하고 사라진 블록 갯수 반환
            int count = this.checkBlockAndGetCount(newBoard, width, height);
            // 사라진 블록 갯수가 없을 경우 게임 종료
            if( count == 0) {
                break;
            }
            answer += count;
            // 내려주기
            this.dropDownBlock(newBoard);
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] stringArray = new String[] { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        solution.solution(6, 6, stringArray);
    }
}
