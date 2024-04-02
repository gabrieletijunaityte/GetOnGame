package test;

import junit.framework.TestCase;
import logic.KilometerCard;

public class KilometerTest extends TestCase {

			public void testfive() {
				KilometerCard card5 = new KilometerCard(5);
				card5.playCard();
			}

			public void testsix() {
				KilometerCard card6 = new KilometerCard(6);
				card6.playCard();
			}

			public void testeight() {
				KilometerCard card8 = new KilometerCard(8);
				card8.playCard();
			}

			public void testten() {
				KilometerCard card10 = new KilometerCard(10);
				card10.playCard();
			}

		}
