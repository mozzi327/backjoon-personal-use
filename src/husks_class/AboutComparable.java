package husks_class;


// 예제는 그리디 알고리즘 예시

import java.util.ArrayList;
import java.util.Collections;

public class AboutComparable {
    public static void main(String[] args) {
        ArrayList<Action> ls = new ArrayList<>();
        ls.add(new Action("A", 7, 8));
        ls.add(new Action("B", 5, 7));
        ls.add(new Action("C", 3, 6));
        ls.add(new Action("D", 1, 2));
        ls.add(new Action("E", 6, 9));
        ls.add(new Action("F", 10, 11));
        Collections.sort(ls);

        ArrayList<Action> ans = greedy(ls);
        for(Action act : ans) {
            System.out.print(act.name + ", ");
        }
    }

    private static ArrayList<Action> greedy(ArrayList<Action> list) {
        int time = 0;
        ArrayList<Action> ans = new ArrayList<>();

        for (Action act : list) {
            if(time <= act.startTime) {
                time = act.endTime;
                ans.add(act);
            }
        }
        return ans;
    }
}

// Commparable을 상속받는 Class 구현
// 구현 예제는 startTime과 endTime을 통해 종료 시간 기준 오름차순으로 정렬하는 compareTo 메서드
class Action implements Comparable<Action> {
    String name;
    int startTime;
    int endTime;
    public Action(String name, int startTime, int endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    // 종료시간을 기준으로 오름차순으로 정렬함
    @Override
    public int compareTo(Action o) {
        return this.endTime - o.endTime;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

