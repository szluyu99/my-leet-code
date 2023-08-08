import java.util.PriorityQueue;
import java.util.Queue;

import javax.management.Query;

class SeatManager {
    Queue<Integer> q;

    public SeatManager(int n) {
        q = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) q.add(i);
    }
    
    public int reserve() {
        return q.poll();
    }
    
    public void unreserve(int seatNumber) {
        q.add(seatNumber);
    }
}