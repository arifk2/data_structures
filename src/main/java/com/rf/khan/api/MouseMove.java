package com.rf.khan.api;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.util.Random;

/**
 * This class is created to get move the mouse at some random coordinate
 * 
 * @author mkhan339
 *
 */
public class MouseMove {

	/**
	 * This is main driver method having the actual logic
	 * 
	 * @param args
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws AWTException, InterruptedException {
		while (true) {
			Robot robot = new Robot();
			Point p = MouseInfo.getPointerInfo().getLocation();
			int x = p.x + new Random().nextInt();
			int y = p.y + new Random().nextInt();

			robot.mouseMove(x, y);

			Thread.sleep(40000);
		}
	}
}
