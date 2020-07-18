	import static org.junit.Assert.assertEquals;

	import java.util.Arrays;

	import org.junit.Test;
	import static org.junit.Assert.*;


public class PlayerTest {


			
		@Test
		public void testConstructor(){
			Player p = new Player("Theo");
			assertEquals(p.getName() , "Theo");
			assertEquals(p.getHandSize(), 0);
		}
		
		@Test
		public void testAddToHand(){
			Player p = new Player("Theo");
			UnoCard c = new UnoCard(false);
			p.addToHand(c);
			p.addToHand(c);
			p.addToHand(c);
			p.addToHand(c);
			UnoCard ca = new UnoCard(true);
			p.addToHand(ca);
			assertEquals(p.getHand().lastNode().getData(),ca);
			assertEquals(p.getHand().size(), 5);
		}
		
		@Test
		public void testRemoveFromHand(){
			Player p = new Player("Theo");
			UnoCard c = new UnoCard(false);
			p.addToHand(c);
			p.addToHand(c);
			p.addToHand(c);
			p.addToHand(c);
			UnoCard ca = new UnoCard(true);
			p.addToHand(ca);
			p.removeFromHand(2);
			assertEquals(p.getHand().lastNode().getData(),ca);
			assertEquals(p.getHand().size(), 4);
			p.removeFromHand(0);
			p.removeFromHand(0);
			p.removeFromHand(0);
			p.removeFromHand(0);
			boolean thrown = false;
			try {
				p.removeFromHand(0);
			}catch(UnsupportedOperationException e) {
				thrown = true;
			}
		}
		
		@Test
		public void testDiscardCard2(){
			Player p = new Player("Theo");
			UnoCard c = new UnoCard(false);
			p.addToHand(c);
			p.addToHand(c);
			p.addToHand(c);
			p.addToHand(c);
			UnoCard ca = new UnoCard(true);
			p.addToHand(ca);
			p.removeFromHand(2);
			assertEquals(p.getHand().lastNode().getData(),ca);
			assertEquals(p.getHand().size(), 4);
			p.removeFromHand(0);
			p.removeFromHand(0);
			p.removeFromHand(0);
			p.removeFromHand(0);
			assertTrue(p.winner());
			
		}
		
		@Test
		public void getNextPlayer(){
			Player p = new Player("Theo");
			Player p2 = new Player("Becca");
			assertEquals(p.getNextPlayer(), null);
			
		}
		
		@Test
		public void setNextPlayer(){
			Player p = new Player("Theo");
			Player p2 = new Player("Becca");
			p.setNextPlayer(p2);
			assertEquals(p.getNextPlayer().getName(), "Becca");
			
		}
		
		@Test
		public void getPrevPlayer(){
			Player p = new Player("Theo");
			Player p2 = new Player("Becca");
			assertEquals(p.getPrevPlayer(), null);
			
		}
		
		@Test
		public void setPrevPlayer(){
			Player p = new Player("Theo");
			Player p2 = new Player("Becca");
			p.setPrevPlayer(p2);
			assertEquals(p.getPrevPlayer().getName(), "Becca");
			
		}
		
		@Test
		public void testToString(){
			Player p = new Player("Theo");
			assertEquals(p.toString(), "Player [name=Theo]");
		}
		
		@Test
		public void testGetName(){
			Player p = new Player("");
			assertEquals(p.getName(), "");
		}
		
}
