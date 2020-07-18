	import static org.junit.Assert.assertEquals;

	import java.util.Arrays;

	import org.junit.Test;
	import static org.junit.Assert.*;


public class UnoDeckTest {

			
		@Test
		public void testConstructor(){
			UnoDeck d = new UnoDeck();
			assertEquals(d.getLastDiscarded(),null);
			assertEquals(d.getDeck().size(), 108);
		}
		
		@Test
		public void testLastDiscarded(){
			UnoDeck d = new UnoDeck();
			UnoCard c = d.drawCard();
			d.discardCard(c);
			assertEquals(d.getLastDiscarded(),c);
		}
		
		@Test
		public void testDiscardCard1(){
			UnoDeck d = new UnoDeck();
			UnoCard c = d.drawCard();
			d.discardCard(c);
			assertEquals(d.getLastDiscarded(),c);
			boolean thrown = false;
			try {
				d.discardCard(null);
			}catch(NullPointerException e) {
				thrown = true;
			}
		}
		
		@Test
		public void testDiscardCard2(){
			UnoDeck d = new UnoDeck();
			UnoCard c = d.drawCard();
			d.discardCard(c);
			while(d.getDeck().size() != 0) {
				c = d.drawCard();
				if(!c.canBePlacedOn(d.getLastDiscarded())) {
					boolean thrown = false;
					try {
						d.discardCard(c);
					}catch(UnsupportedOperationException e) {
						thrown = true;
					}
					
				}else {
					d.discardCard(c);
				}
			}
			
		}
		
		@Test
		public void testDiscardCard3(){
			UnoDeck d = new UnoDeck();
			UnoCard c = new UnoCard(false);
			boolean thrown = false;
			try {
				d.discardCard(c);
			}catch(UnsupportedOperationException e) {
				thrown = true;
			}
			
		}
		
		@Test
		public void testDrawCard(){
			UnoDeck d = new UnoDeck();
			UnoDeck discard = new UnoDeck();
			while(d.getDeck().size() != 0) {
				d.drawCard();
			}
			assertEquals(d.getDeck().size(), 0 );
		}
		
		
		@Test
		public void testToString(){
			UnoDeck d = new UnoDeck();
			assertFalse(d.toString().length() < 108);
		}
		
}
