package com.github.dsaa.tree.binary;

import java.util.List;

import com.github.dsaa.tree.Node;

public class BNode<T extends Comparable<?>> implements Node{
	private T data;
	private BNode<T> left;
	private BNode<T> right;
	private BNode<T> parent;
	
	public BNode(T nodeValue){
		this(nodeValue, null, null);
	}
	
	public BNode(T nodeValue, BNode<T> left, BNode<T> right){
		this.data = nodeValue;
		this.left = left;
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BNode<T> getLeft() {
		return left;
	}

	public void setLeft(BNode<T> left) {
		this.left = left;
	}

	public BNode<T> getRight() {
		return right;
	}

	public void setRight(BNode<T> right) {
		this.right = right;
	}

	public List<Node> getChilds() {
		return null;
	}

	public BNode<T> getParent() {
		return parent;
	}

	public void setParent(BNode<T> parent) {
		this.parent = parent;
	}
}
