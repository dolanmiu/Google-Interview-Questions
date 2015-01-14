package hard;

import java.util.Random;

public class ShuffleDeck {
	public static Card[] shuffleDeck(Card[] cards) {
		Random random = new Random();
		for (int i = 0; i < cards.length; i++) {
			int j = random.nextInt(52);
			Card temp = cards[j];
			cards[j] = cards[i];
			cards[i] = temp;
		}
		return cards;
	}
}

class Card {
	
}
