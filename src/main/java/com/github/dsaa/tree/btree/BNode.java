package com.github.dsaa.tree.btree;

import java.util.List;

import com.github.dsaa.tree.Node;

public class BNode<T extends Comparable<?>> implements Node{
	T data;
	BNode left;
	BNode right;
	
	public BNode(T nodeValue){
		this(nodeValue, null, null);
	}
	
	public BNode(T nodeValue, BNode left, BNode right){
		this.data = nodeValue;
		this.left = left;
		this.right = right;
	}

	public List<Node> getChilds() {
		return null;
	}
}
