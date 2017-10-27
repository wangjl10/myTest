import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;



public class Test { 
	
	
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	String next = scanner.nextLine();
    	String[] split = next.split(" ");
    	Map map = new HashMap();
    	List list = new ArrayList();
    	if (null != split && split.length > 0) {
			for (int i = 0; i < split.length; i++) {
				int n = Integer.valueOf(split[i]);
				if (map.containsKey(n)) {
					AtomicInteger ato = (AtomicInteger) map.get(n);
					ato.getAndIncrement();
					map.put(n, ato);
				}else {
					list.add(n);
					map.put(n, new AtomicInteger(1));
				}
			}
		}
        
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
			System.out.print(" ");
			AtomicInteger ato = (AtomicInteger) map.get(list.get(i));
			System.out.print(ato.get());
			System.out.print(" ");
		}
		
		System.out.println();
      
    }
}
