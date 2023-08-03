package Stack_Queue.응급실;

import java.util.*;

class Person {
    int id;
    int priority;

    Person(int id, int priority) {
        this.id = id;
        this.priority = priority;

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(main.mySolution2(n, k, arr));
    }

    private int lectureSolution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> Q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            Q.offer(new Person(i, arr[i]));
        }

        while(!Q.isEmpty()) {
            Person tmp = Q.poll();
            for(Person x: Q) {
                if(x.priority > tmp.priority) {
                    Q.offer(tmp);
                    tmp = null;
                    break;
                }
            }

            if(tmp != null) {
                answer++;
                if(tmp.id == m) {
                    return answer;
                }
            }
        }
        return answer;
    }
    private int mySolution(int n, int k, int[] arr) {
        int answer = 0;

        LinkedList<Integer> queue = new LinkedList<>();
        for (int x : arr) queue.offer(x);

        while (!queue.isEmpty()) {
            /* poll */
            int target = queue.poll();
            k--;

            if (queue.isEmpty()) {
                break;
            }

            /* 우선순위 체크 */
            boolean isPolled = true;
            for (int i = 0; i < queue.size(); i++) {
                if (queue.get(i) > target) {
                    queue.offer(target);
                    if (k == -1) {
                        k = queue.size() - 1;
                    }
                    isPolled = false;
                    break;
                }
            }
            /* 정말 진료받으러 빠진 경우 answer++*/
            if(isPolled) {
                answer++;
            }
            if(k == -1) {
                break;
            }
        }
        return answer;
    }


    private int mySolution2(int n, int k, int[] arr) {
        int answer = 0;

        LinkedList<Person> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) queue.offer(new Person(i, arr[i]));

        while(!queue.isEmpty()) {
            Person target = queue.poll();

            boolean isPolled = true;
            for(int i = 0; i < queue.size(); i++) {
                if(target.priority < queue.get(i).priority) {
                    queue.offer(target);
                    isPolled = false;
                    break;
                }
            }

            if(isPolled) {
                answer++;
                if(target.id == k) {
                    return answer;
                }
            }
        }
        return answer;
    }
}
