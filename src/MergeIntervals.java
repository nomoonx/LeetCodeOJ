import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by noMoon on 2016-01-12.
 */
public class MergeIntervals {

    public static class Interval {
        int start;

        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args){
        List<Interval> intervals=new ArrayList<Interval>();
        intervals.add(new Interval(2,3));
        intervals.add(new Interval(2,2));
        intervals.add(new Interval(3,3));
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(5,7));
        intervals.add(new Interval(2,2));
        intervals.add(new Interval(4,6));
        List<Interval> result=merge(intervals);


    }

    public static List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()==0){
            return new ArrayList<Interval>();
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start==o2.start) return 0;
                else if(o1.start<o2.start) return -1;
                else return 1;
            }
        });
        List<Interval> result=new ArrayList<Interval>();
        result.add(intervals.get(0));
        for(int i=1;i<intervals.size();i++){
            Interval interval=intervals.get(i);
            int head=0,tail=result.size()-1;
            while(head<tail){
                int mid=(head+tail)/2;
                if(result.get(mid).start==interval.start){
                    head=mid;
                    break;
                }else if(result.get(mid).start<interval.start){
                    head=mid+1;
                }else{
                    tail=mid-1;
                }
            }
            if(result.get(head).start<=interval.start&&result.get(head).end>=interval.start){
                result.get(head).end=result.get(head).end>interval.end?result.get(head).end:interval.end;
            }else{
                result.add(interval);
            }
        }
        return result;
    }
}
