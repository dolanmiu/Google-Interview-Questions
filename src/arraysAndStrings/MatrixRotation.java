package arraysAndStrings;

public class MatrixRotation {

	public static Pixel[][] rotatePicture(Pixel[][] picture) {
		if (picture.length != picture[1].length) return null;
		
		boolean[][] flippedChecker = new boolean[picture.length][picture[1].length];
		for (int i = 0; i < picture.length; i++) {
			for (int j = 0; j < picture[i].length; j++) {
				if (flippedChecker[i][j]) continue;
				Pixel currentPixel = picture[i][j];
				int newI = picture.length - 1 - j;
				int newJ = i;

				Pixel destinationPixel = picture[newI][newJ];

				picture[i][j] = destinationPixel;
				picture[newI][newJ] = currentPixel;
				
				flippedChecker[newI][newJ] = true;
			}
		}
		return picture;
	}


	
	public static void main(String[] args) {
		Pixel[][] picture = new Pixel[3][3];
		for (int i = 0; i < picture.length; i++) {
			for (int j = 0; j < picture[i].length; j++) {
				picture[i][j] = new Pixel(i, j, 0, 0);
			}
		}
		
		Pixel[][] outputPicture = rotatePicture(picture);

		for (int i = 0; i < outputPicture.length; i++) {
			for (int j = 0; j < outputPicture[i].length; j++) {
				System.out.print(outputPicture[i][j]);
			}
			System.out.println("");
		}
	}
}

class Pixel {
	public byte r, g, b, a;

	public Pixel(byte r, byte g, byte b, byte a) {
		this.r = r;
		this.b = b;
		this.g = g;
		this.a = a;
	}
	
	public Pixel(int r, int g, int b, int a) {
		this.r = (byte)r;
		this.b = (byte)b;
		this.g = (byte)g;
		this.a = (byte)a;
	}
	
	@Override
	public String toString() {
		return r + " " + g + " " + b + " " + a + " | ";
	}
}
