package sorting_and_searching.뮤직비디오;
import java.util.*;

/*
* 못 푼 문제
* 문제 접근 어떻게 할지 모름..!
* */


/*
* 결정 알고리즘?!
* 답이 lt ~ rt까지 확실히 있을 경우 결정 알고리즘 사용 가능
* 1, 2, 3, 4, 5, 6, 7 ,8, 9라고 입력이 존재했을 경우
* 9 ~ 45
* */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i< n; i++) arr[i] = sc.nextInt();

//        System.out.println(main.lectureSolution(n, m, arr));
//        System.out.println(main.mySolutionAfterLecture(n, m, arr));

        System.out.println(main.retry230808(n, m, arr));
    }


    // 다시 시도: 23.08.08
    // 문제 접근
    // DVD의 용량은 최소값을 유지해야한다.
    // DVD 용량에 따른 최솟값과 최댓값을 구하자(lt: 9, rt: 토탈)
    // m개를 사용해서 제일 최소의 용량을 구해야하기 때문에
    // m개 >= count rt = mt - 1;
    // m개 < count lt = mt + 1

    private int getCount(final int capacity, final int[] arr) {
        int count = 1;
        int tmp = 0;
        for(int x: arr) {
            tmp += x;
            if(capacity < tmp) {
                count++;
                tmp = x;
            }
        }
        return count;
    }
    private int retry230808(final int n, final int m, final int[] arr) {
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        int answer = 0;

        while(lt <= rt) {
            int mt = (lt + rt) / 2;
            int count = getCount(mt, arr);

//            System.out.println("lt: " + lt + " rt: " + rt + " mt: " + mt + " count : " + count);
            if(m >= count) {
                answer = mt;
                rt = mt - 1;
            }else {
                lt = mt + 1;
            }
        }


        return answer;

    }



    public int count(int[] arr, int capacity) {
        int cnt = 1, sum = 0;
        for(int x: arr) {
            if(sum + x > capacity) {
                cnt++;
                sum = x;
            }
            else sum += x;
        }
        return cnt;
    }

    public int lectureSolution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while(lt <= rt) {
            // DVD 용량
            int mid = (lt + rt) / 2;

            if(count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            }else {
                lt = mid + 1;
            }

        }

        return answer;
    }

    private int mySolutionAfterLecture(int n, int m, int[] arr) {
        int lt = arr[arr.length - 1];
        int rt = 0;
        for(int x: arr) rt += x;
        int answer = 0;

        while(lt <= rt) {
            int mt = (lt + rt) / 2;

            int cnt = 0;
            int capacity = 0;
            for(int x: arr) {
                capacity += x;
                if(capacity <= mt) {
                    continue;
                }
                cnt++;
                capacity = x;
            }

            if(cnt < m) {
                answer = mt;
                rt = mt - 1;
            } else {
                lt = mt + 1;
            }
        }
        return answer;
    }




}
