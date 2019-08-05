import java.util.Comparator;
import java.util.PriorityQueue;

public class QueueTest {

	public static void main(String[] args) {
//		SQueue q = new SQueue();
//		q.add('A');
//		q.add('C');
//		q.add('B');
//		q.add('D');
//		
//		SQueue.Node temp = q.getFront();
//		while(temp != null) {
//			System.out.print(temp.data+" ");
//			temp = temp.next;
//		}
//		PriorityQueue<Character> pq = new PriorityQueue<>();
		PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
			@Override
			public int compare(Character o1, Character o2) {
				
//				return -o1.compareTo(o2);
				return o2-o1;
			}
		});
		System.out.println(pq);
		pq.add('A');
		pq.add('C');
		pq.add('B');
		pq.add('D');
		
		while(!pq.isEmpty()) {
			System.out.print(pq.poll()+" ");
		}
		
	}

}
