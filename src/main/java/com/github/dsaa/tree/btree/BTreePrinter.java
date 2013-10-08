package com.github.dsaa.tree.btree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTreePrinter {

	public static <T extends Comparable<?>> void printBNode(BNode<T> root) {
		int maxLevel = BTreePrinter.maxLevel(root);

		printBNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}

	private static <T extends Comparable<?>> void printBNodeInternal(
			List<BNode<T>> BNodes, int level, int maxLevel) {
		if (BNodes.isEmpty() || BTreePrinter.isAllElementsNull(BNodes))
			return;

		int floor = maxLevel - level;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		BTreePrinter.printWhitespaces(firstSpaces);

		List<BNode<T>> newBNodes = new ArrayList<BNode<T>>();
		for (BNode<T> BNode : BNodes) {
			if (BNode != null) {
				System.out.print(BNode.getData());
				newBNodes.add(BNode.getLeft());
				newBNodes.add(BNode.getRight());
			} else {
				newBNodes.add(null);
				newBNodes.add(null);
				System.out.print(" ");
			}

			BTreePrinter.printWhitespaces(betweenSpaces);
		}
		System.out.println("");

		for (int i = 1; i <= endgeLines; i++) {
			for (int j = 0; j < BNodes.size(); j++) {
				BTreePrinter.printWhitespaces(firstSpaces - i);
				if (BNodes.get(j) == null) {
					BTreePrinter.printWhitespaces(endgeLines + endgeLines + i
							+ 1);
					continue;
				}

				if (BNodes.get(j).getLeft() != null)
					System.out.print("/");
				else
					BTreePrinter.printWhitespaces(1);

				BTreePrinter.printWhitespaces(i + i - 1);

				if (BNodes.get(j).getRight() != null)
					System.out.print("\\");
				else
					BTreePrinter.printWhitespaces(1);

				BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
			}
			System.out.println("");
		}

		printBNodeInternal(newBNodes, level + 1, maxLevel);
	}

	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}

	private static <T extends Comparable<?>> int maxLevel(BNode<T> BNode) {
		if (BNode == null)
			return 0;
		return Math.max(BTreePrinter.maxLevel(BNode.getLeft()),
				BTreePrinter.maxLevel(BNode.getRight())) + 1;
	}

	private static <T> boolean isAllElementsNull(List<T> list) {
		for (Object object : list) {
			if (object != null)
				return false;
		}
		return true;
	}
}
