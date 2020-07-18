import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {

	
	@Test
	public void testConstructor(){
		
		boolean thrown = false;
		try {
			Queue q = new Queue(0);
		}catch(IllegalArgumentException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test
	public void testEnqueue1(){
		Queue q = new Queue(4);
		q.enqueue("Theo");
		q.enqueue("Theo");
		q.enqueue("Theo");
		q.enqueue("Theo");
		boolean thrown = false;
		try {
			q.enqueue("Theo");
		}catch(UnsupportedOperationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	
	@Test
	public void testEnqueue2(){
		Queue q = new Queue(4);
		q.enqueue("TheoS");
		q.enqueue("Theo");
		q.enqueue("Theo");
		q.enqueue("Theo");
		assertEquals(q.getFront(),"TheoS");
		q.dequeue();
		assertEquals(q.getFront(),"Theo");
	}
	
	@Test
	public void testEnqueue3(){
		Queue q = new Queue(4);
		boolean thrown = false;
		try {
			q.enqueue(null);
		}catch(IllegalArgumentException e) {
			thrown = true;
		}
	}
	
	@Test
	public void testDequeue1(){
		Queue q = new Queue(4);
		boolean thrown = false;
		try {
			q.dequeue();
		}catch(UnsupportedOperationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test
	public void testDequeue2(){
		Queue q = new Queue(4);
		q.enqueue(0);
		q.enqueue(1);
		q.enqueue(2);
		assertEquals(q.dequeue(), 0);
		assertEquals(q.dequeue(), 1);
		assertEquals(q.dequeue(), 2);
		
	}
	
	@Test
	public void testDequeue3(){
		Queue q = new Queue(4);
		boolean thrown = false;
		try {
			q.dequeue();
		}catch(UnsupportedOperationException e) {
			thrown = true;
		}
		assertTrue(thrown);
		q.enqueue(0);
		q.enqueue(1);
		q.enqueue(2);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		thrown = false;
		try {
			q.dequeue();
		}catch(UnsupportedOperationException e) {
			thrown = true;
		}

		
	}
	
	@Test
	public void testDequeue4(){
		Queue q = new Queue(5);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.enqueue(5);
		assertEquals(5, q.dequeue());
	}
	
	@Test
	public void testEnqueueDequeue1(){
		Queue q = new Queue(4);
		q.enqueue("Theo");
		q.enqueue("Theo");
		q.enqueue("Theo");
		q.enqueue("Theo");
		assertTrue(q.isFull());
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		assertTrue(q.isEmpty());
		assertEquals(q.getSize(),0);
		assertNull(q.getFront());
		
	}
	
	@Test
	public void testIsEmpty1(){
		Queue q = new Queue(4);
		q.enqueue("Theo");
		assertFalse(q.isEmpty());
		assertEquals(q.getSize(),1);
	}
	
	@Test
	public void testIsEmpty2(){
		Queue q = new Queue(4);
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void testIsFull1(){
		Queue q = new Queue(4);
		q.enqueue("Theo");
		assertFalse(q.isFull());
	}
	@Test
	public void testIsFull2(){
		Queue q = new Queue(1);
		q.enqueue("Theo");
		assertTrue(q.isFull());
	}
	
	@Test
	public void testIsFull3(){
		Queue q = new Queue(4);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		assertEquals(true, q.isFull());
		assertEquals(true, q.isFull());
		assertEquals(true, q.isFull());
	}
	
	@Test
	public void testgetSize(){
		Queue q = new Queue(4);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		assertEquals(4, q.getSize());
	}
	
	@Test
	public void testgetFront(){
		Queue q = new Queue(4);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		assertEquals(1, q.getFront());
		q.dequeue();
		assertEquals(2, q.getFront());
	}
	
	

}
