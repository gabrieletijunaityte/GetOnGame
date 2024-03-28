package card01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class kilometerTest{
	@Test
	public void test() {
		KilometerCard card = new KilometerCard(5);
		card.playCard(5);
	}

}

