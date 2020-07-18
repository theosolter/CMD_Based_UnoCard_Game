import static org.junit.Assert.assertEquals;

	import java.util.Arrays;

	import org.junit.Test;
	import static org.junit.Assert.*;
	
	
public class SinglyLinkedNodeTest {
			
		@Test
		public void testConstructor1(){
			SinglyLinkedNode n = new SinglyLinkedNode(1); 
			assertEquals(n.getData(),1);
			assertEquals(n.getNext(),null);
		}
		
		@Test
		public void testConstructor2(){
			boolean thrown = false;
			try {
				SinglyLinkedNode n = new SinglyLinkedNode(null); 
			}catch(IllegalArgumentException e) {
				thrown = true;
			}
		}
		
		@Test
		public void testGetData(){
			SinglyLinkedNode n = new SinglyLinkedNode("ASA"); 
			assertEquals(n.getData(),"ASA");
		}
		
		@Test
		public void testSetNext(){
			SinglyLinkedNode n = new SinglyLinkedNode("ASA"); 
			SinglyLinkedNode n2 = new SinglyLinkedNode(1); 
			n.setNext(n2);
			assertEquals(n.getNext().getData(),1);
		}
		
		@Test
		public void testGetNext(){
			SinglyLinkedNode n = new SinglyLinkedNode(1); 
			assertEquals(n.getNext(),null);
		}
		
		@Test
		public void testToString(){
			SinglyLinkedNode n = new SinglyLinkedNode(1); 
			assertEquals(n.toString(),"1");
		}
		
	}


