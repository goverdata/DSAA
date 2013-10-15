package com.github.dsaa.tree.binary.redblack;

import com.github.dsaa.tree.binary.BNode;

public class RBNode<T extends Comparable<?>> extends BNode{
	public static final int RED = 0;
	public static final int BLACK = 0;
	
	private int color;
	
	public RBNode(T nodeValue){
		super(nodeValue);
	}
	
	public RBNode(Comparable nodeValue, RBNode left, RBNode right){
		super(nodeValue, left, right);
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
}
