package level2.프렌즈4블록;
// [1차] 프렌즈4블록
// https://school.programmers.co.kr/learn/courses/30/lessons/17679


import java.util.Arrays;

// 접근 방법
// 1. 4개가 곂쳐있는 공간들을 찾아서 0으로 만든다
// 2. 다 밑으로 한칸 씩 내린다
class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];

        for(int i = 0 ; i < m ; ++i) {
            map[i] = board[i].toCharArray();
        }

        while(true) {
            int cnt = checkBlock(m, n, map);
            if(cnt == 0) break;
            answer += cnt;

            dropBlock(m, n, map);
        }

        return answer;
    }

    private void dropBlock(int m, int n, char[][] map) {
        for(int c = 0 ; c < n ; ++c) {
            for(int r = m - 1 ; r >= 0 ; --r) {
                if(map[r][c] == '.') {
                    for(int nr = r - 1 ; nr >= 0 ; --nr) {
                        if(map[nr][c] != '.') {
                            map[r][c] = map[nr][c];
                            map[nr][c] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    private int checkBlock(int m, int n, char[][] map) {

        // 먼저 boolean 2차원 배열 생성 후에 전부 true처리를 한다.
        int cnt = 0;
        boolean[][] isChecked = new boolean[m][n];
        for(int i = 0 ; i < m - 1 ; ++i) {
            for(int j = 0 ; j < n - 1 ; ++j) {
                if(map[i][j] == '.') continue;
                checkFour(map, isChecked, i, j);
            }
        }

        // 한 이후에 전부 . 처리를 한다. => .처리를 하면서 cnt를 세어 준다
        for(int i = 0 ; i < m ; ++i) {
            for(int j = 0 ; j < n ; ++j) {
                if(isChecked[i][j]) {
                    cnt++;
                    map[i][j] = '.';
                }
            }
        }

        System.out.println("map = " + Arrays.deepToString(map));

        return cnt;
    }

    private void checkFour(char[][] map, boolean[][] isChecked, int i, int j) {
        char block = map[i][j];

        for(int r = i ; r < i + 2 ; ++r) {
            for(int c = j ; c < j + 2 ; ++c) {
                if(map[r][c] != block) return;
            }
        }

        for(int r = i ; r < i + 2 ; ++r) {
            for(int c = j ; c < j + 2 ; ++c) {
                isChecked[r][c] = true;
            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] stringArray = new String[] { "CCBDE", "AAADE", "AAABF", "CCBBF"};

        solution.solution(4, 5, stringArray);
    }
}
