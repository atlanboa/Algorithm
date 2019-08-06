import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o2 - o1;
			}
		});
		
		pq.offer(1);
		pq.offer(5);
		pq.offer(2);
		pq.offer(4);
		pq.offer(3);
		
//		Iterator<Integer> it = pq.iterator();
//		
//		while(it.hasNext()) System.out.println(it.next());
		
		while(pq.size() != 0) {
			System.out.println(pq.poll());
		}
		
	}
}
