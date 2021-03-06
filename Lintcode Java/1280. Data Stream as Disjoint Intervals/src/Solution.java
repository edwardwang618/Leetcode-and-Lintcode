import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Solution {
    
    private TreeSet<Interval> set = new TreeSet<>((i1, i2) -> Integer.compare(i1.start, i2.start));
    
    {
        set.add(new Interval(Integer.MIN_VALUE, Integer.MIN_VALUE));
        set.add(new Interval(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }
    
    /**
     * @param val: An integer.
     * @return: nothing
     */
    public void addNum(int val) {
        // write your code here
        Interval interval = new Interval(val, val);
        Interval floor = set.floor(interval), ceiling = set.ceiling(interval);
        if (floor.end < val - 1 && ceiling.start > val + 1) {
            set.add(new Interval(val, val));
            return;
        }
        
        set.remove(floor);
        set.remove(ceiling);
        if (floor.end == val - 1 && ceiling.start == val + 1) {
            floor.end = ceiling.end;
            set.add(floor);
        } else if (floor.end == val - 1) {
            floor.end = val;
            set.add(floor);
            set.add(ceiling);
        } else if (ceiling.start == val + 1) {
            ceiling.start = val;
            set.add(ceiling);
            set.add(floor);
        }
    }
    
    /**
     * @return: A list of intervals.
     */
    public List<Interval> getIntervals() {
        // write your code here
        return new ArrayList<>(set).subList(1, set.size() - 1);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.addNum(1);
        System.out.println(sol.getIntervals());
        // sol.addNum(4);
        // sol.addNum(3);
        // sol.addNum(2);
        //
        // System.out.println(sol.getIntervals());
        // System.out.println(sol.getIntervals());
        //
        // sol.addNum(0);
        // System.out.println(sol.getIntervals());
        //
        // sol.addNum(3);
        // System.out.println(sol.getIntervals());
    }
}

class Interval {
    int start, end;
    
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}