package algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 활동 시간표 클래스
class Activity {
    String name;
    int start;
    int end;

    public Activity(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return String.format("{name='%s', start=%d, end=%d}", name, start, end);
    }

}

// 그리디 알고리즘
public class _Greedy {
    public static void canMaxActivities(List<Activity> activities) {
        Collections.sort(activities, (x1, x2) -> x1.end - x2.end);
        activities.forEach(System.out::println);

        int curTime = 0;
        ArrayList<Activity> result = new ArrayList<>();
        for(Activity item: activities){
            if(curTime <= item.start){
                curTime = item.end;
                result.add(item);
            }
        }

        for(Activity item: result){
            System.out.print(item.name + " ");
        }
    }

    public static void main() {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("A", 1, 5));
        activities.add(new Activity("B", 4, 5));
        activities.add(new Activity("C", 2, 3));
        activities.add(new Activity("D", 4, 7));
        activities.add(new Activity("E", 6, 10));

        _Greedy T = new _Greedy();

        T.canMaxActivities(activities);
    }
}
