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

		while (true) {
			StdDraw.clear(); // clear screen on every loop iteration

			/*
			 * the following 4 if conditions cause the mosquito to turn back if
			 * it either hits the window boundary, or if a random event occurs
			 * by 0.04% chance. when the mosquito changes direction, a new
			 * directional speed is determined and stored in fx and fy
			 * variables. these if's also set the proper mosquito image
			 * according to the direction it is facing
			 */
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

			/*
			 * the following if's determine the next x and y coordinates of the
			 * mosquito with added "shakiness"
			 */
			if (dx == XDir.left)
				x = x - (fx + 0.01 * r.nextInt(5) * (r.nextBoolean() ? 1 : -1));
			if (dx == XDir.right)
				x = x + (fx + 0.01 * r.nextInt(5) * (r.nextBoolean() ? 1 : -1));
			if (dy == YDir.top)
				y = y - (fy + 0.01 * r.nextInt(5) * (r.nextBoolean() ? 1 : -1));
			if (dy == YDir.bottom)
				y = y + (fy + 0.01 * r.nextInt(5) * (r.nextBoolean() ? 1 : -1));

			StdDraw.picture(x, y, mf); // display the mosquito in its new
										// position

			Thread.sleep(50); // sleep for 50msecs
		}
	}
}
