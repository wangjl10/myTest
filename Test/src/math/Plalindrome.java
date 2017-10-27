package math;

public class Plalindrome {

	public static void main(String[] args) {
		long startMili=System.currentTimeMillis();// 当前时间对应的毫秒数
		System.out.println(isAddPlalindrome("acc"));
		System.out.println(isAddPlalindrome("sos"));
		System.out.println(isAddPlalindrome("ititewewtiti"));
		System.out.println(isAddPlalindrome("ititxystiti"));
		long stopMili=System.currentTimeMillis();// 当前时间对应的毫秒数
		System.out.println("程序运行共计："+(stopMili-startMili)+"毫秒");
	}
	
	
	public static boolean isAddPlalindrome(String text){
		for(int i=0;i<=text.length()/2;i++){
			if(!text.substring(i, i+1).equals(text.substring(text.length()-1-i, text.length()-i))){
				if(isPlalindrome(text.substring(i,text.length()-1-i))||isPlalindrome(text.substring(i+1,text.length()-i))){
					return true;
				}else{
					return false;
				}
			}
		}
		return true;
	}
	
	
	public static boolean isPlalindrome(String textString){
		for(int i=0;i<=textString.length()/2;i++){
			if(!textString.substring(i, i+1).equals(textString.substring(textString.length()-1-i, textString.length()-i))){
				return false;
			}
		}
		return true;
	}
}
