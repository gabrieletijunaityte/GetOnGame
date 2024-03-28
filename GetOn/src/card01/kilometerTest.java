package card01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class kilometerTest{
	@Test
	public void testfive() {
		KilometerCard card5 = new KilometerCard(5);
		card5.playCard();
	}
	@Test
	public void testsix() {
		KilometerCard card6 = new KilometerCard(6);
		card6.playCard();
	}
	@Test
	public void testeight() {
		KilometerCard card8 = new KilometerCard(8);
		card8.playCard();
	}
	@Test
	public void testten() {
		KilometerCard card10 = new KilometerCard(10);
		card10.playCard();
	}

}

