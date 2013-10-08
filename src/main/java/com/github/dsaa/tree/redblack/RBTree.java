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
	 * ����ĳ�����pivot�ϣ�����������ʱ�����Ǽ��������Һ���y����NIL[T]��
	 * pivot����Ϊ���������Һ��Ӷ�����NIL[T]�Ľ�㡣
	 * ������pivot��y֮�����Ϊ��֧�ᡱ���У���ʹy��Ϊ�ú������µĸ���
	 * ��y������b���Ϊpivot���Һ��ӡ�
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
