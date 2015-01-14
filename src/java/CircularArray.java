package java;

import java.util.ArrayList;

public class CircularArray<T> extends ArrayList<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2925124340412465188L;

	public boolean rotate(int steps) {
		if (this.size() <= 1) return false;

		boolean rotateLeft = false;
		if (steps < 0) { 
			rotateLeft = true;
			steps = Math.abs(steps);
		}
		
		for (int i = 0; i < steps; i++) {
			if (rotateLeft) {
				T element = this.remove(0);
				this.add(element);
			} else {
				T element = this.remove(this.size() - 1);
				this.add(0, element);
			}
		}
		
		return true;
	} 
}