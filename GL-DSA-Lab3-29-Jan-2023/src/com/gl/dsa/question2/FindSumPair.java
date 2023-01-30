package com.gl.dsa.question2;

import java.util.HashSet;
import java.util.Set;

public class FindSumPair {
	static class Node {
		int data;
		Node leftNode, rightNode;

		public Node(int data) {
			this.data = data;
			leftNode = rightNode = null;
		}
	}

	static Node createNode(int nodeData) {
		Node newNode = new Node(nodeData);
		return newNode;
	}

	Node insert(Node root, int key) {
		if (root == null) {
			return createNode(key);
		}
		if (key < root.data)
			root.leftNode = insert(root.leftNode, key);
		else
			root.rightNode = insert(root.rightNode, key);

		return root;
	}

	public static void main(String[] args) {
		Node root = null;

		FindSumPair findSp = new FindSumPair();
		root = findSp.insert(root, 40);
		root = findSp.insert(root, 20);
		root = findSp.insert(root, 60);
		root = findSp.insert(root, 10);
		root = findSp.insert(root, 30);
		root = findSp.insert(root, 50);
		root = findSp.insert(root, 70);

		int targetSum = 130;
		findSp.findPairWithGivenSum(root, targetSum);

		System.out.println("Inorder traversal");
		inorder(root);

	}

	private static void inorder(Node root) {
		if (root != null) {
			inorder(root.leftNode);
			System.out.print(root.data + " ");
			inorder(root.rightNode);

		}
	}

	private void findPairWithGivenSum(Node root, int targetSum) {
		Set<Integer> set = new HashSet<Integer>();
		if (!findPairUtil(root, targetSum, set))
			System.out.println("Pair do not exist.....");

	}

	private boolean findPairUtil(Node root, int targetSum, Set<Integer> set) {
		if (root == null)
			return false;

		int diff = targetSum - root.data;

		if (findPairUtil(root.leftNode, targetSum, set))
			return true;
		if (set.contains(diff)) {
			System.out.println("Pair is found(" + diff + ", " + root.data + ")");
			return true;

		} else
			set.add(root.data);

		return findPairUtil(root.rightNode, targetSum, set);

	}

}
