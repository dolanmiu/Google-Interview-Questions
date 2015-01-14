package dynamicProgramming;

import java.util.ArrayList;

public class BoxStacker {

	public static Box[] findBoxStack(Box[] boxes) {
		ArrayList<Box> result = new ArrayList<Box>();

		mainLoop: for (Box box : boxes) {
			for (int i = 0; i < result.size(); i++) {
				if (box.compareTo(result.get(i)) > 0
						|| box.compareTo(result.get(i)) == 0) {
					result.add(i, box);
				}

				if (box.compareTo(result.get(i)) < 0) {
					continue;
				}

				if (box.compareTo(result.get(i)) == null) {
					continue mainLoop;
				}
			}
		}

		return (Box[]) result.toArray();
	}
}

class Box {
	public int w;
	public int h;
	public int d;

	public Box() {

	}

	public Box(int w, int h, int d) {
		this.w = w;
		this.h = h;
		this.d = d;
	}

	public Integer compareTo(Box box) {
		if (w > box.w && h > box.h && d > box.d) {
			return 1;
		} else if (w < box.w && h < box.h && d < box.d) {
			return -1;
		} else if (w == box.w && h == box.h && d == box.d) {
			return 0;
		} else {
			return null;
		}
	}
}
