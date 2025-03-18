package limitless;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        boolean isIntervalAdded = false;
        for(int i = 0; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if(isIntervalAdded){
                Interval previous = intervals.get(i-1);
                if(checkOverlap(previous, current)){
                    previous.end = current.end;
                    intervals.remove(i);
                    i=i-1;
                }
                else
                    break;
            }
            else{
                if (newInterval.end < current.start){
                    isIntervalAdded = true;
                    intervals.add(i, newInterval);
                    break;
                } else if (checkOverlap(current, newInterval)) {
                    isIntervalAdded = true;
                    current.start = Math.min(current.start, newInterval.start);
                    current.end = Math.max(current.end, newInterval.end);
                }
            }
        }
        if(!isIntervalAdded)
            intervals.add(newInterval);
        return intervals;
    }

    boolean checkOverlap(Interval i1, Interval i2){
        return (i2.start >= i1.start && i2.start <= i1.end) || (i2.end >= i1.start && i2.end <= i1.end);
    }




    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });

        for(int i = 1; i < intervals.size(); i++){
            Interval prev = intervals.get(i-1);
            Interval current = intervals.get(i);
            if((current.start >= prev.start && current.start <= prev.end )){
                prev.end = Math.max(current.end , prev.end);
                intervals.remove(i--);
            }
        }
        return intervals;
    }
}




class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}