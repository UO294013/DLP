package parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	public static double lexemeToReal(String str) {
		try {
			return Double.parseDouble(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	public static char lexemeToChar(String str) {
		try {
			if (str.length() == 3) {
				return str.charAt(1);
			} else if (str.equals("'\\n'")) {
				return '\n';
			} else if (str.equals("'\\t'")) {
				return '\t';
			} else {
				return (char) Integer.parseInt(str.substring(2, str.length()-1));
			}
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return str.charAt(1);
	}

	public static Boolean lexemeToBoolean(String str) {
		try {
			return Boolean.parseBoolean(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return null;
	}
}
