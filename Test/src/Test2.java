import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String target = scanner.nextLine();
		// String target = "A-B-C-D-E-F-G-H-I-J-K";
		target = target.replaceAll("-", "");
		String pattern = scanner.nextLine();
		// String pattern = "T-Y-U-H-I-J-K";
		pattern = pattern.replaceAll("-", "");
		
		if (pattern.length() > target.length()) {
			String tmp = pattern;
			pattern = target;
			target = tmp;
		}
		int max = maxCommon(target, pattern);
		if (max > 0) {
			char charAt = pattern.charAt(max -1);
			System.out.print(charAt);
			System.out.print(" ");
			System.out.print(max -1);
		}else {
			System.out.print(0);
			System.out.print(" ");
			System.out.print(0);
		}
	}
	
	
	public static int maxCommon(String target,String pattern ){
		if (target.length() <= 0 || pattern.length() <= 0)
			return 0;
		if (target.length() == 1 && pattern.length() == 1) {
			return target.charAt(0) == pattern.charAt(0) ? 1 : 0;
		}
		
		if (target.charAt(target.length() -1) == pattern.charAt(pattern.length() -1)) {
			return 1 + maxCommon(target.substring(0,target.length() -1),pattern.substring(0, pattern.length() -1));
		}else {
			return Math.max(maxCommon(target.substring(0,target.length()),pattern.substring(0, pattern.length() -1)), 
					maxCommon(target.substring(0,target.length() -1),pattern.substring(0, pattern.length())));
		}
		
	}

}
