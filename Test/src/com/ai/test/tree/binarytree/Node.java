package com.ai.test.tree.binarytree;

public class Node {

	private String key;
	private Node left;
	private Node right;

	public Node(String key) {
		super();
		this.key = key;
	}

	public Node(String key, Node left, Node right) {
		super();
		this.key = key;
		this.left = left;
		this.right = right;
	}

	public Node() {
		super();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}
