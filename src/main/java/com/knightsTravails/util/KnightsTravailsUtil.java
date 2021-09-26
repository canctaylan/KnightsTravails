package com.knightsTravails.util;

public class KnightsTravailsUtil {
	public static int[] stringToCoord(String location) // method to convert the String location to numerical values for
														// easy calculation
	{
		int[] locationArray = new int[2];
		char letterLocation = location.charAt(0);
		int numberLocation = Integer.parseInt(location.substring(1)) - 1;

		if (letterLocation == 'A')
			locationArray[0] = 0;
		else if (letterLocation == 'B')
			locationArray[0] = 1;
		else if (letterLocation == 'C')
			locationArray[0] = 2;
		else if (letterLocation == 'D')
			locationArray[0] = 3;
		else if (letterLocation == 'E')
			locationArray[0] = 4;
		else if (letterLocation == 'F')
			locationArray[0] = 5;
		else if (letterLocation == 'G')
			locationArray[0] = 6;
		else if (letterLocation == 'H')
			locationArray[0] = 7;
		else
			return null;

		locationArray[1] = numberLocation;
		return locationArray;
	}

	public static String coordToString(String nodeList) // convert all numerical values into String locations
	{
		String[] nodeArray = nodeList.trim().split(" ");
		String result = "";
		for (String node : nodeArray) {
			String letterLocation = node.substring(0, 1);
			int numberLocation = Integer.parseInt(node.substring(1)) + 1;

			if (letterLocation.equals("0"))
				result += " A" + numberLocation;
			else if (letterLocation.equals("1"))
				result += " B" + numberLocation;
			else if (letterLocation.equals("2"))
				result += " C" + numberLocation;
			else if (letterLocation.equals("3"))
				result += " D" + numberLocation;
			else if (letterLocation.equals("4"))
				result += " E" + numberLocation;
			else if (letterLocation.equals("5"))
				result += " F" + numberLocation;
			else if (letterLocation.equals("6"))
				result += " G" + numberLocation;
			else if (letterLocation.equals("7"))
				result += " H" + numberLocation;
		}
		return result.trim();
	}
}
