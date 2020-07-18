import static org.junit.Assert.assertEquals;

	import java.util.Arrays;

	import org.junit.Test;
	import static org.junit.Assert.*;

	
	public class SinglyLinkedListTest {
		
		@Test 
		public void testSize1(){ 
			SinglyLinkedList l = new SinglyLinkedList(); 
			assertEquals(0, l.size()); 
			l.regularInsert("Theo"); 
			assertEquals(1, l.size()); 
		}

		@Test
		public void testConstructor(){
			SinglyLinkedList l = new SinglyLinkedList(); 
			assertEquals(0, l.size()); 
		}
		
		@Test
		public void testGetHead1(){
			SinglyLinkedList l = new SinglyLinkedList();
			l.regularInsert(1);
			l.regularInsert(0);
			l.regularInsert(2);
			l.regularInsert(0);
			l.regularInsert(0);
			l.regularInsert(0);
			l.remove(1);
			assertEquals(0, l.getHead().getData());
			l.removeIndex(0);
			assertEquals(2, l.getHead().getData());
		}
		
		@Test
		public void testGetHead2(){
			SinglyLinkedList l = new SinglyLinkedList();
			assertEquals(null, l.getHead());
		}
		
		
		@Test
		public void testRegularInsert1(){
			SinglyLinkedList l = new SinglyLinkedList();
			l.regularInsert("A");
			assertEquals("(0) A |",l.toString());
		}
		
		@Test
		public void testRegularInsert2(){
			SinglyLinkedList l = new SinglyLinkedList();
			
			boolean thrown = false;
			try {
				l.regularInsert(null);
			}catch(IllegalArgumentException e) {
				thrown = true;
			}
		}
		
		@Test
		public void testRegularInsert3(){
			SinglyLinkedList l = new SinglyLinkedList();
			l.regularInsert("A");
			l.regularInsert("B");
			l.regularInsert("C");
			assertEquals(l.getHead().getData(),"A");
			assertEquals(l.getHead().getNext().getData(),"B");
			assertEquals(l.lastNode().getData(),"C");
		}
		
		@Test
		public void testRandomInsert1(){
			SinglyLinkedList l = new SinglyLinkedList();
			l.randomInsert("A");
			l.randomInsert("B");
			l.randomInsert("C");
			assertEquals(l.size(),3);
		}
		
		@Test
		public void testRandomInsert2(){
			SinglyLinkedList l = new SinglyLinkedList();
			
			boolean thrown = false;
			try {
				l.randomInsert(null);
			}catch(IllegalArgumentException e) {
				thrown = true;
			}
		}
		
		@Test
		public void testRandomInsert3(){
			SinglyLinkedList l = new SinglyLinkedList();
			l.randomInsert(1);
			l.randomInsert(2);
			l.randomInsert(3);
			assertNotEquals(l.getHead(),null);
			assertEquals(l.lastNode().getNext(),null);
		}
		
		@Test
		public void testRemove1(){
			SinglyLinkedList l = new SinglyLinkedList();
			assertEquals(l.remove(3),null);
			assertEquals(l.size(),0);
		}
		
		@Test
		public void testRemove2(){
			SinglyLinkedList l = new SinglyLinkedList();
			l.regularInsert("A");
			l.regularInsert("B");
			l.regularInsert("C");
			assertEquals(l.remove("A"),"A");
			assertEquals(l.getHead().getData(),"B");
			assertEquals(l.size(),2);
		}
		
		
		@Test
		public void testRemove3(){
			SinglyLinkedList l = new SinglyLinkedList();
			l.regularInsert("A");
			l.regularInsert("B");
			l.regularInsert("C");
			assertEquals(l.remove("C"),"C");
			assertEquals(l.getHead().getData(),"A");
			assertEquals(l.lastNode().getNext(),null);
			assertEquals(l.size(),2);
		}
		
		@Test
		public void testRemove4(){
			SinglyLinkedList l = new SinglyLinkedList();
			l.regularInsert("A");
			l.regularInsert("B");
			l.regularInsert("C");
			assertEquals(l.remove("B"),"B");
			assertEquals(l.getHead().getData(),"A");
			assertEquals(l.getHead().getNext().getData(),"C");
			assertEquals(l.lastNode().getNext(),null);
			assertEquals(l.toString(), "(0) A |(1) C |");
		}
		
		@Test
		public void testRemove5(){
			SinglyLinkedList l = new SinglyLinkedList();
			l.regularInsert("A");
			l.regularInsert("B");
			l.regularInsert("C");
			assertEquals(l.remove("B"),"B");
			assertEquals(l.remove("C"),"C");
			assertEquals(l.remove("A"),"A");
			assertEquals(l.getHead(),null);
			assertEquals(l.lastNode(),null);
		}
		
		@Test
		public void testRemove6(){
			SinglyLinkedList l = new SinglyLinkedList();
			l.regularInsert("A");
			l.regularInsert("B");
			l.regularInsert("C");
			assertEquals(l.remove("T"),null);
			assertEquals(l.remove("C"),"C");
			assertEquals(l.remove("A"),"A");
		}
		
		@Test
		public void testSize2(){
			SinglyLinkedList l = new SinglyLinkedList();
			l.regularInsert("A");
			l.regularInsert("B");
			l.regularInsert("C");
			assertEquals(l.remove("B"),"B");
			assertEquals(l.remove("C"),"C");
			assertEquals(l.remove("A"),"A");
			assertEquals(l.size(),0);
			
		}
		
		@Test
		public void testToString(){
			SinglyLinkedList l = new SinglyLinkedList();
			l.regularInsert("A");
			l.regularInsert("B");
			l.regularInsert("C");
			assertEquals(l.remove("B"),"B");
			assertEquals(l.remove("C"),"C");
			assertEquals(l.remove("A"),"A");
			assertEquals(l.toString(), "");
		}
		
		@Test
		public void testLastNode1(){
			SinglyLinkedList l = new SinglyLinkedList();
			l.regularInsert("A");
			l.regularInsert("B");
			l.regularInsert("C");
			assertEquals(l.remove("B"),"B");
			assertEquals(l.remove("C"),"C");
			assertEquals(l.remove("A"),"A");
			assertEquals(l.getHead(),null);
			assertEquals(l.lastNode(),null);
		}
		
		@Test
		public void testLastNode2(){
			SinglyLinkedList l = new SinglyLinkedList();
			l.regularInsert("A");
			l.regularInsert("B");
			l.regularInsert("C");
			assertEquals(l.remove("B"),"B");
			assertEquals(l.lastNode().getData(),"C");
		}
		
		@Test
		public void testRemoveIndex1(){
			SinglyLinkedList l = new SinglyLinkedList();
			assertEquals(l.removeIndex(3),null);
			assertEquals(l.size(),0);
		}
		
		@Test
		public void testRemoveIndex2(){
			SinglyLinkedList l = new SinglyLinkedList();
			l.regularInsert("A");
			l.regularInsert("B");
			l.regularInsert("C");
			assertEquals(l.removeIndex(0),"A");
			assertEquals(l.getHead().getData(),"B");
			assertEquals(l.size(),2);
		}
		
		
		@Test
		public void testRemoveIndex3(){
			SinglyLinkedList l = new SinglyLinkedList();
			l.regularInsert("A");
			l.regularInsert("B");
			l.regularInsert("C");
			assertEquals(l.removeIndex(2),"C");
			assertEquals(l.getHead().getData(),"A");
			assertEquals(l.lastNode().getNext(),null);
			assertEquals(l.size(),2);
		}
		
		@Test
		public void testRemoveIndex4(){
			SinglyLinkedList l = new SinglyLinkedList();
			l.regularInsert("A");
			l.regularInsert("B");
			l.regularInsert("C");
			assertEquals(l.removeIndex(1),"B");
			assertEquals(l.getHead().getData(),"A");
			assertEquals(l.getHead().getNext().getData(),"C");
			assertEquals(l.lastNode().getNext(),null);
			assertEquals(l.toString(), "(0) A |(1) C |");
		}
		
		@Test
		public void testRemoveIndex5(){
			SinglyLinkedList l = new SinglyLinkedList();
			l.regularInsert("A");
			l.regularInsert("B");
			l.regularInsert("C");
			assertEquals(l.size(),3);
			assertEquals(l.removeIndex(1),"B");
			assertEquals(l.removeIndex(1),"C");
			assertEquals(l.removeIndex(0),"A");
			assertEquals(l.getHead(),null);
			assertEquals(l.lastNode(),null);
		}
		
		@Test
		public void testRemoveIndex6(){
			SinglyLinkedList l = new SinglyLinkedList();
			l.regularInsert("A");
			l.regularInsert("B");
			l.regularInsert("C");
			assertEquals(l.remove(6),null);
			assertEquals(l.remove("C"),"C");
			assertEquals(l.remove("A"),"A");
		}
		
		@Test
		public void testRemoveIndex7(){
			SinglyLinkedList l = new SinglyLinkedList();
			l.regularInsert("A");
			l.regularInsert("B");
			l.regularInsert("C");
			assertEquals(l.remove(-1),null);
			assertEquals(l.remove("C"),"C");
			assertEquals(l.remove("A"),"A");
		}
		

	}


