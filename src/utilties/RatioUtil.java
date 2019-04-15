package utilties;

public class RatioUtil {
	public static void calcRatios(int valueX, int valueY) {
		int ratioX = valueX - 1;
		int ratioY = valueY - 1;
		
		while (valueX % ratioX != 0) {
			ratioX--;
		}
		
		while (valueY % ratioY != 0) {
			ratioY--;
		}
		System.out.println("Ratio of " + valueX + "x" + valueY + " is " + ratioX + " : " + ratioY);
		if (ratioX <= 1 || ratioY <= 1)
			return;
		calcRatios(ratioX, ratioY);
	}
}
