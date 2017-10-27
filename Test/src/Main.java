import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            char a = in.next().charAt(0);
            char b = in.next().charAt(0);
            List<String> list = new ArrayList<String>();
            list.add("");
            if (eq(a,b)) {
				System.out.println(str);
				System.exit(0);
			}
            for (int i = 0; i < str.length(); i++) {
                if (!eq(str.charAt(i), a)) {
                    for (int j = 0; j < list.size(); j++) {
                        list.set(j, list.get(j)+str.charAt(i));
                    }
                } else {
                    List<String> tmp = new ArrayList<String>();
                    for (int j = 0; j < list.size(); j++) {
                        tmp.add(list.get(j)+str.charAt(i));
                        tmp.add(list.get(j)+b);
                    }
                    list = tmp;
                }
            }
            Set set = new HashSet();
            String s = "";
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
            	String temp = list.get(i);
            	if (!set.contains(temp.hashCode())) {
            		set.add(temp.hashCode());
            		sb.append(list.get(i) + ",");
				}
            }
            if (sb.toString().endsWith(",")) {
				 s = sb.toString().substring(0,sb.toString().length() -1);
			}
            System.out.println(s);
        }
    }
    
    public static boolean eq(char a, char b) {
        int len = 'a' - 'A';
        if (a >= 'a' && a <='z') {
            char c = b >= 'A' && b <= 'Z' ? (char)(b + len) : b;
            return a == c;
        } else if (a >= 'A' && a <='Z'){
            char c = b >= 'a' && b <= 'z' ? (char)(b - len) : b;
            return a == c;
        }
        return a==b;
    }
  
}