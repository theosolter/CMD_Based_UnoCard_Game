	import static org.junit.Assert.assertEquals;

	import java.util.Arrays;

	import org.junit.Test;
	import static org.junit.Assert.*;



public class PlayerCircleTest {

		
		@Test
		public void testAddToCircle(){
			Player p = new Player("Theo");
			Player p1 = new Player("TheoS");
			Player p2 = new Player("TheoD");
			Player p3= new Player("TheoF");
			Player p4 = new Player("TheoG");
			Player p5 = new Player("TheoH");
			PlayerCircle c = new PlayerCircle();
			c.addToCircle(p);
			c.addToCircle(p1);
			c.addToCircle(p2);
			c.addToCircle(p3);
			c.addToCircle(p4);
			c.addToCircle(p5);
			assertEquals(c.getFirstPlayer().getName(), "Theo");
			assertEquals(c.getFirstPlayer().getPrevPlayer().getName(), "TheoS");
		}
		
		@Test
		public void testRemoveFromCircle1(){
			Player p = new Player("Theo");
			PlayerCircle c = new PlayerCircle();
			boolean thrown = false;
			try {
				c.removeFromCircle(p);
			}catch(IllegalArgumentException e) {
				thrown = true;
			}
		}
		
		@Test
		public void testRemoveFromCircle2(){
			Player p = new Player("Theo");
			Player p1 = new Player("TheoS");
			PlayerCircle c = new PlayerCircle();
			c.addToCircle(p1);
			assertEquals(c.removeFromCircle(p), null);
			
		}
		
		@Test
		public void testGetFirstPlayer(){
			PlayerCircle c = new PlayerCircle();
			Player p = new Player("Theo");
			Player p2 = new Player("Becca");
			c.addToCircle(p);
			c.addToCircle(p2);
			assertEquals(p.getNextPlayer().getName(), "Becca");
			assertEquals(c.getFirstPlayer().getName(), "Becca");
			
		}
		
		@Test
		public void testSetFirstPlayer2(){
			PlayerCircle c = new PlayerCircle();
			assertEquals(c.getFirstPlayer(), null);
			
		}
		
		@Test
		public void testGetSize1(){
			Player p = new Player("Theo");
			Player p1 = new Player("TheoS");
			Player p2 = new Player("TheoD");
			Player p3= new Player("TheoF");
			Player p4 = new Player("TheoG");
			Player p5 = new Player("TheoH");
			PlayerCircle c = new PlayerCircle();
			c.addToCircle(p);
			c.addToCircle(p1);
			c.addToCircle(p2);
			c.addToCircle(p3);
			c.addToCircle(p4);
			c.addToCircle(p5);
			assertEquals(c.getSize(),6);
			assertEquals(p.getPrevPlayer().getName(),"TheoS");
			
		}
		
		@Test
		public void testGetSize2(){
			PlayerCircle c = new PlayerCircle();
			assertEquals(c.getSize(),0);
			
		}
		
		@Test
		public void testToString1(){
			Player p = new Player("Theo");
			Player p1 = new Player("TheoS");
			Player p2 = new Player("TheoD");
			Player p3= new Player("TheoF");
			Player p4 = new Player("TheoG");
			Player p5 = new Player("TheoH");
			PlayerCircle c = new PlayerCircle();
			c.addToCircle(p);
			c.addToCircle(p1);
			c.addToCircle(p2);
			c.addToCircle(p3);
			c.addToCircle(p4);
			c.addToCircle(p5);
			c.removeFromCircle(p2);
			assertEquals(c.toString(), "Theo, TheoF, TheoG, TheoH, TheoS, ");
		}
		
		@Test
		public void testToString2(){
			PlayerCircle c = new PlayerCircle();
			assertEquals(c.toString(), "");
		}
		
		
}
