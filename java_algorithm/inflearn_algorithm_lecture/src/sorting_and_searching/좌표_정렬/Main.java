package sorting_and_searching.좌표_정렬;
import java.util.*;

class Chart implements Comparable<Chart> {
    int x;
    int y;

    Chart(int x, int y) {
        this.x =x;
        this.y =y;
    }


    @Override
    public String toString() {
        return x + " " + y;
    }

    @Override
    public int compareTo(Chart o) {
        if(x == o.x) {
            return ( y < o.y) ? -1 : 1;
        }

        return (x < o.x) ? -1 : 1;
    }
}


class Point implements Comparable<Point> {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    // tip! 오름차순이 되게 하려 하면 this -> compare object 순으로 뺴주기
    // 내림 차순을 하려고 하면 compare object - this 빼주기
    public int compareTo(Point p) {
        if(this.x == p.x) {
            return this.y - p.y; // 오름차순
        }
        return this.x - p.y;
    }
}
public class Main {

    private void mySolution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Chart> chartList = new ArrayList<>(n);

        for(int i = 0; i < n; i++) {
            chartList.add(new Chart(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(chartList);
        for(Chart x: chartList) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Point> arr = new ArrayList<>(n);
        for(int i = 0; i < n; i++) arr.add(new Point(sc.nextInt(), sc.nextInt()));
        Collections.sort(arr);

        for(Point o: arr) {
            System.out.println(o.x + " " + o.y);
        }


    }
}
