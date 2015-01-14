package Moderate;

import java.util.Arrays;
import java.util.HashMap;

import Moderate.SlotGame.Colour;


public class SlotGame {

	public enum Colour {
		RED, YELLOW, GREEN, BLUE;
	}

	public static int[] isHit(Slots answer, Slots guess) {
		int hits = 0;

		HashMap<Colour, Integer> hmAnswer = new HashMap<Colour, Integer>();
		HashMap<Colour, Integer> hmGuess = new HashMap<Colour, Integer>();

		for (int i = 0; i < answer.slots.length; i++) {
			
			if (answer.slots[i] == guess.slots[i]) {
				hits++;
				continue;
			}
			
			if (hmAnswer.get(answer.slots[i]) == null) {
				hmAnswer.put(answer.slots[i], 1);
			} else {
				hmAnswer.put(answer.slots[i],
						hmAnswer.get(answer.slots[i]) + 1);
			}
			
			if (hmGuess.get(guess.slots[i]) == null) {
				hmGuess.put(guess.slots[i], 1);
			} else {
				hmGuess.put(guess.slots[i],
						hmGuess.get(guess.slots[i]) + 1);
			}

		}

		int pseudo = 0;

		if (checkIfHasValue(hmAnswer, hmGuess, Colour.RED)) {
			pseudo++;
		}

		if (checkIfHasValue(hmAnswer, hmGuess, Colour.YELLOW)) {
			pseudo++;
		}

		if (checkIfHasValue(hmAnswer, hmGuess, Colour.BLUE)) {
			pseudo++;
		}

		if (checkIfHasValue(hmAnswer, hmGuess, Colour.GREEN)) {
			pseudo++;
		}

		return new int[] { hits, pseudo };
	}

	public static boolean checkIfHasValue(HashMap<Colour, Integer> answer,
			HashMap<Colour, Integer> guess, Colour colour) {
		if (answer.get(colour) == null || guess.get(colour) == null) return false;
		if (answer.get(colour) > 0 && guess.get(colour) > 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Slots answer = new Slots();
		Slots guess = new Slots();

		Colour[] a = new Colour[] { Colour.RED, Colour.GREEN, Colour.BLUE,
				Colour.YELLOW };
		Colour[] g = new Colour[] { Colour.GREEN, Colour.GREEN, Colour.RED,
				Colour.RED };

		answer.slots = a;
		guess.slots = g;

		int[] f = isHit(answer, guess);
		System.out.println(Arrays.toString(f));
	}
}

class Slots {

	public Colour[] slots;

	public Slots() {
		slots = new Colour[4];
	}
}
