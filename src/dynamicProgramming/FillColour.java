package dynamicProgramming;

public class FillColour {

	public static void fill(Pixel[][] screen, Vector2 point, Colour colour, Colour previousColour) {
		
		if (point.x < 0 || point.y < 0 || point.x > screen.length - 1 || point.y > screen[0].length - 1) {
			return;
		}

		if (screen[point.x][point.y].colour != previousColour) {
			return;
		}

		if (screen[point.x][point.y].colour == colour) {
			return;
		}

		screen[point.x][point.y].colour = colour;	

		fill(screen, new Vector2(point.x + 1, point.y), colour, previousColour);
		fill(screen, new Vector2(point.x - 1, point.y), colour, previousColour);
		fill(screen, new Vector2(point.x, point.y + 1), colour, previousColour);
		fill(screen, new Vector2(point.x, point.y - 1), colour, previousColour);
	}
	
	public static void main(String[] args) {
		fill(new Pixel[1][1], new Vector2(4, 2), new Colour(255, 255, 255), new Colour(122,122,122));
	}
}

class Vector2 {
	public int x, y;

	public Vector2() {

	}

	public Vector2(int x, int y) {

	}
}

class Pixel {

	public Colour colour;

	public Pixel() {

	}

	public Pixel(Colour colour) {
		this.colour = colour;
	}
}

class Colour {

	public int r;
	public int g;
	public int b;

	public Colour(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	@Override
	public boolean equals(Object c) {
		if (!(c instanceof Colour)) return false;
		if (this.r == ((Colour)c).r || this.g == ((Colour)c).g || this.b == ((Colour)c).b) {
			return true;
		}
		return false;
	}
}
