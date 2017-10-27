package com.ai.test;

/**
 * 
 * Copyright: Copyright (c) 2017 Asiainfo
 * @ClassName StringPermutations.javag
 * @Description
 * 递归方式实现字符串倒序
 *
 * @version: V1.0.0
 * @author wangjl10
 * @date 2017年4月11日
 * StringPermutations
 */
public class StringPermutations {

	public static void main(String[] args) {
		String s = "12";
		permutation(s);
	}

	public static void permutation(String input) {
		permutation("", input);
	}

	private static void permutation(String perm, String word) {

		if (word.isEmpty()) {
			System.out.println(perm + word);
		} else {
			for (int i = 0; i < word.length(); i++) {
				System.out.println("---" + perm + "---" + word);
				permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
			}
		}

	}

}
