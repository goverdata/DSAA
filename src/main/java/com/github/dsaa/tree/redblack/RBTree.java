package com.github.dsaa.tree.redblack;

import com.github.dsaa.tree.Node;
import com.github.dsaa.tree.Tree;

/**
 * Red Black Tree
 * 
 * @author Johnny Deng
 * 
 */
public class RBTree implements Tree {

	RBNode root = null;

	/**
	 * 当在某个结点pivot上，做左旋操作时，我们假设它的右孩子y不是NIL[T]，
	 * pivot可以为树内任意右孩子而不是NIL[T]的结点。
	 * 左旋以pivot到y之间的链为“支轴”进行，它使y成为该孩子树新的根，
	 * 而y的左孩子b则成为pivot的右孩子。
	 * */
	void leftRotate(RBNode pivotNode) {
		if(pivotNode == null ||pivotNode.getRight() == null){
			return;
		}
		
		RBNode temp = (RBNode) pivotNode.getRight();
		
		pivotNode.setRight(temp.getLeft());
		temp.getLeft().setParent(pivotNode);
		
		
		
	}

	void rightRotate(RBNode pivotNode) {

	}

	void insert(RBNode thisNode) {

	}

	void remove(RBNode thisNode) {

	}

	@Override
	public Node getRoot() {
		return root;
	}
}
