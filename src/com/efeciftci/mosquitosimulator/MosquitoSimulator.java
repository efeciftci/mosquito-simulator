/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
		double fx = 0.01, fy = 0.01; // how much will the mosquito move on each
										// direction change
		String mf = "mr.jpg"; // path of mosquito image
		XDir dx = XDir.right; // initial directions
		YDir dy = YDir.bottom;
		Random r = new Random();

		StdDraw.setCanvasSize(300, 300);
		StdDraw.setPenRadius(0.05);
		StdDraw.setPenColor(StdDraw.BLUE);

		while (true) {
			StdDraw.clear();
			if (x >= 1 || r.nextInt(100) < 4) {
				dx = XDir.left;
				mf = "ml.jpg";
				fx = 0.01 * r.nextInt(5);
			}
			if (x <= 0 || r.nextInt(100) < 4) {
				dx = XDir.right;
				mf = "mr.jpg";
				fx = 0.01 * r.nextInt(5);
			}
			if (y >= 1 || r.nextInt(100) < 4) {
				dy = YDir.top;
				fy = 0.01 * r.nextInt(5);
			}
			if (y <= 0 || r.nextInt(100) < 4) {
				dy = YDir.bottom;
				fy = 0.01 * r.nextInt(5);
			}
			if (dx == XDir.left)
				x = x - (fx + 0.01 * r.nextInt(5) * (r.nextBoolean() ? 1 : -1));
			if (dx == XDir.right)
				x = x + (fx + 0.01 * r.nextInt(5) * (r.nextBoolean() ? 1 : -1));
			if (dy == YDir.top)
				y = y - (fy + 0.01 * r.nextInt(5) * (r.nextBoolean() ? 1 : -1));
			if (dy == YDir.bottom)
				y = y + (fy + 0.01 * r.nextInt(5) * (r.nextBoolean() ? 1 : -1));
			StdDraw.picture(x, y, mf);
			Thread.sleep(50);
		}
	}
}
