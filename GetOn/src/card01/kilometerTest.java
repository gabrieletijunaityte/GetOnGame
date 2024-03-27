package card01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class kilometerTest {

	@Test
	void test() {
		KilometerCard kaart = new KilometerCard(5);
		kaart.getDistance();
	}

}
