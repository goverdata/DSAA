package com.github.dsaa.tree.redblack;

import com.github.dsaa.tree.btree.BNode;

public class RBNode<T extends Comparable<?>> extends BNode{
	int color;
	
	public RBNode(T nodeValue){
		super(nodeValue);
	}
	
	public RBNode(Comparable nodeValue, RBNode left, RBNode right){
		super(nodeValue, left, right);
	}
}
