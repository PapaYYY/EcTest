package ua.nik.ECTest;

public class Helper {

	public static String getRandomNameFor(String item) {
		int rnd = (int) System.currentTimeMillis();
		return  item+rnd;
	} 
}
