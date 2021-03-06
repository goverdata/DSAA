package com.github.dsaa.tree.btree;

/**
 * Balanced Tree
 * 
 * @author hadoopor@yahoo.com
 * 
 * @param <Key>
 * @param <Value>
 */
public class BTree<Key extends Comparable<Key>, Value> {
	private static final int M = 4; // max children per B-tree node = M-1

	private Node root; // root of the B-tree
	private int HT; // height of the B-tree

	/**
	 * number of key-value pairs in the B-tree
	 */
	private int N;

	// helper B-tree node data type
	private static final class Node {
		private int m; // number of children
		private Entry[] children = new Entry[M]; // the array of children

		private Node(int k) {
			m = k;
		} // create a node with k children
	}

	// internal nodes: only use key and next
	// external nodes: only use key and value
	private static class Entry {
		private Comparable key;
		private Object value;
		private Node next; // helper field to iterate over array entries

		public Entry(Comparable key, Object value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	// constructor
	public BTree() {
		root = new Node(0);
	}

	// return number of key-value pairs in the B-tree
	public int size() {
		return N;
	}

	// return height of B-tree
	public int height() {
		return HT;
	}

	// search for given key, return associated value; return null if no such key
	public Value get(Key key) {
		return search(root, key, HT);
	}

	private Value search(Node x, Key key, int ht) {
		Entry[] children = x.children;

		// external node
		if (ht == 0) {
			for (int j = 0; j < x.m; j++) {
				if (eq(key, children[j].key))
					return (Value) children[j].value;
			}
		}

		// internal node
		else {
			for (int j = 0; j < x.m; j++) {
				if (j + 1 == x.m || less(key, children[j + 1].key))
					return search(children[j].next, key, ht - 1);
			}
		}
		return null;
	}

	/**
	 * insert key-value pair 
	 * add code to check for duplicate keys
	 * @param key
	 * @param value
	 */
	public void put(Key key, Value value) {
		Node u = insert(root, key, value, HT);
		N++;
		// 刚好插入结点而不需要分裂，则完成一次插入操作并返回
		if (u == null) {
			return;
		}

		// need to split root
		Node newNode = new Node(2);
		newNode.children[0] = new Entry(root.children[0].key, null, root);
		newNode.children[1] = new Entry(u.children[0].key, null, u);
		root = newNode;
		HT++;
	}

	/**
	 * Pop up the middle node of the split node
	 * @param parentNode
	 * @param key
	 * @param value
	 * @param ht
	 * @return the split node
	 */
	private Node insert(Node parentNode, Key key, Value value, int ht) {
		int j;
		Entry t = new Entry(key, value, null);

		// external node
		if (ht == 0) {
			for (j = 0; j < parentNode.m; j++) {
				if (less(key, parentNode.children[j].key)){
					break;
				}
			}
		} else {
			// internal node
			for (j = 0; j < parentNode.m; j++) {
				if ((j + 1 == parentNode.m) || less(key, parentNode.children[j + 1].key)) {
					Node splitNode = insert(parentNode.children[j++].next, key, value, ht - 1);
					if (splitNode == null){
						return null;
					}
					t.key = splitNode.children[0].key;
					t.next = splitNode;
					break;
				}
			}
		}

		for (int i = parentNode.m; i > j; i--) {
			parentNode.children[i] = parentNode.children[i - 1];
		}
		parentNode.children[j] = t;
		parentNode.m++;
		if (parentNode.m < M) {
			return null;
		} else {
			return split(parentNode);
		}
	}

	// split node in half
	// 分裂结点，并将分裂出的中间结点向上弹出
	private Node split(Node h) {
		Node t = new Node(M / 2);
		h.m = M / 2;
		for (int j = 0; j < M / 2; j++)
			t.children[j] = h.children[M / 2 + j];
		return t;
	}

	// for debugging
	public String toString() {
		return toString(root, HT, "") + "\n";
	}

	private String toString(Node h, int ht, String indent) {
		String s = "";
		Entry[] children = h.children;

		if (ht == 0) {
			for (int j = 0; j < h.m; j++) {
				s += indent + children[j].key + " " + children[j].value + "\n";
			}
		} else {
			for (int j = 0; j < h.m; j++) {
				if (j > 0)
					s += indent + "(" + children[j].key + ")\n";
				s += toString(children[j].next, ht - 1, indent + "     ");
			}
		}
		return s;
	}

	// comparison functions - make Comparable instead of Key to avoid casts
	private boolean less(Comparable k1, Comparable k2) {
		return k1.compareTo(k2) < 0;
	}

	private boolean eq(Comparable k1, Comparable k2) {
		return k1.compareTo(k2) == 0;
	}

}
