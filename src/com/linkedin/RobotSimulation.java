package com.linkedin;

public class RobotSimulation {

	static String[] doesCircleExist(String[] commands) {

		String[] isCircle = new String[commands.length];

		char initialFacing = 'N';
		int x = 0, y = 0, i = 0;

		for (String command : commands) {

			for (char c : command.toCharArray()) {

				switch (c) {
				case 'G':
					if (initialFacing == 'N') {
						y++;
					} else if (initialFacing == 'W') {
						x--;
					} else if (initialFacing == 'S') {
						y--;
					} else if (initialFacing == 'E') {
						x++;
					}
					break;

				case 'L':
					if (initialFacing == 'N') {
						initialFacing = 'W';
					} else if (initialFacing == 'W') {
						initialFacing = 'S';
					} else if (initialFacing == 'S') {
						initialFacing = 'E';
					} else if (initialFacing == 'E') {
						initialFacing = 'N';
					}
					break;

				case 'R':
					if (initialFacing == 'N') {
						initialFacing = 'E';
					} else if (initialFacing == 'E') {
						initialFacing = 'S';
					} else if (initialFacing == 'S') {
						initialFacing = 'W';
					} else if (initialFacing == 'E') {
						initialFacing = 'N';
					}
				}
			}

			isCircle[i] = (x == 0 && y == 0) ? "YES" : "NO";
		}

		return isCircle;
	}
}
