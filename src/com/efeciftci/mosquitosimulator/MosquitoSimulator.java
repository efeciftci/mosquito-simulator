package com.efeciftci.mosquitosimulator;

import java.util.Random;

public class MosquitoSimulator {
	public enum XDir {
		left, right
	};

	public enum YDir {
		top, bottom
	};

	public static void main(String[] args) throws InterruptedException {
		double x = 0.1, y = 1; // start position
		double fx = 0.01, fy = 0.01; // how much will the mosquito move on each direction change
		String mf = "mr.jpg"; // path of mosquito image
		XDir dx = XDir.right; // initial directions
		YDir dy = YDir.bottom;
		Random r = new Random();

		StdDraw.setCanvasSize(300, 300);
		StdDraw.setPenRadius(0.05);
		StdDraw.setPenColor(StdDraw.BLUE);

		while (true) {
			StdDraw.clear();
			if (x >= 1) {
				dx = XDir.left;
				mf = "ml.jpg";
				fx = 0.01 * r.nextInt(5);
			}
			if (x <= 0) {
				dx = XDir.right;
				mf = "mr.jpg";
				fx = 0.01 * r.nextInt(5);
			}
			if (y >= 1) {
				dy = YDir.top;
				fy = 0.01 * r.nextInt(5);
			}
			if (y <= 0) {
				dy = YDir.bottom;
				fy = 0.01 * r.nextInt(5);
			}
			if (dx == XDir.left)
				x = x - (fx + 0.01 * r.nextInt(5) * (r.nextInt(2) == 1 ? 1 : -1));
			if (dx == XDir.right)
				x = x + (fx + 0.01 * r.nextInt(5) * (r.nextInt(2) == 1 ? 1 : -1));
			if (dy == YDir.top)
				y = y - (fy + 0.01 * r.nextInt(5) * (r.nextInt(2) == 1 ? 1 : -1));
			if (dy == YDir.bottom)
				y = y + (fy + 0.01 * r.nextInt(5) * (r.nextInt(2) == 1 ? 1 : -1));
			StdDraw.picture(x, y, mf);
			Thread.sleep(50);
		}
	}
}
