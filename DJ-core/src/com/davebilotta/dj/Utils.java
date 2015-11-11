package com.davebilotta.dj;

public class Utils {

	private static boolean debug = true;
	private static long lastTime = 0;

	public static void log(String msg) {
		if (debug) {
			System.out.println(msg);
		}
	}

	public static void startTimer() {
		lastTime = System.currentTimeMillis();
	}

	public static void stopTimer() {
		if (lastTime != 0) {
			long elapsedTime = System.currentTimeMillis() - lastTime;
			log("Total time: " + elapsedTime + "ms (" + ((float) elapsedTime / 1000) + "s)");
		}
	}
}
