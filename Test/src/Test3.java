import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Test3 {
	
	static Set  result =  new HashSet();

	 public static void main(String[] args) {
		
		 String str = "997";
		 String key = "9";
		 String s3 = "8";
		 ArrayList list = searchAllIndex(str,key);
		 Object[] indexs = list.toArray();
		 
		 
		 
		 System.out.println(list.size());
		 
	}
	 
	 //找出所以key值的位置
	 private static ArrayList searchAllIndex(String str,String key) {
		 ArrayList list = new ArrayList();
	     int a = str.indexOf(key);//*第一个出现的索引位置
	     while (a != -1) {
	    	 list.add(a);
	         a = str.indexOf(key, a + 1);//*从这个索引往后开始第一个出现的位置
	     }
	     return list;
	  }
		
	 
	 public static void permutation(String input) {
			permutation("", input);
		}

	 private static void permutation(String perm, String word) {
			if (word.isEmpty()) {
				result.add(perm + word);
			} else {
				for (int i = 0; i < word.length(); i++) {
					permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
				}
			}

		}
}
