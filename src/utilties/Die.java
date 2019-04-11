package utilties;

public class Die {
	private static final byte D_4 = 4;
	private static final byte D_6 = 6;
	private static final byte D_8 = 8;
	private static final byte D_10 = 10;
	private static final byte D_20 = 20;
	
	public static int rollD4() {
		return (int) (Math.random() * D_4) + 1;
	}
	
	public static int rollD6() {
		return (int) (Math.random() * D_6) + 1;
	}
	
	public static int rollD8() {
		return (int) (Math.random() * D_8) + 1;
	}
	
	public static int rollD10() {
		return (int) (Math.random() * D_10) + 1;
	}
	
	public static int rollD20() {
		return (int) (Math.random() * D_20) + 1;
	}
}
