/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // sort intervals by start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        // use a min heap to track the minimum end time of the sorted intervals
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.end - i2.end;
            }
        });

        // start with the first meeting
        heap.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // get the meeting room that finishes earliest
            Interval interval = heap.poll();

            if (intervals[i].start >= interval.end) {
                // if the current meeting starts right after, there is no need a meeting room
                // merge to the intervals
                interval.end = intervals[i].end;
            } else {
                // otherwise, this meeting need a meeting room, put it into heap
                heap.offer(intervals[i]);
            }
            // put the meeting room back
            heap.offer(interval);
        }
        return heap.size();
    }
}
