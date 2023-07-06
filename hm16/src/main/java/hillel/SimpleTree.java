package edu.hillel;

import lombok.Data;

/**
 * "Simple tree" data structure.
 */
@Data
public class SimpleTree {
  private Node root;

  public void add(int value) {
    root = addRecursive(root, value);
  }

  private Node addRecursive(Node currentNode, int value) {
    if (currentNode == null) {
      return new Node(value);
    }

    if (currentNode.getValue() > value) {
      currentNode.setLeft(addRecursive(currentNode.getLeft(), value));
    } else if (currentNode.getValue() < value) {
      currentNode.setRight(addRecursive(currentNode.getRight(), value));
    }
    return currentNode;
  }

  public void traverseInorder() {
    traverseInorderRecursive(root);
  }

  private void traverseInorderRecursive(Node node) {
    if (node != null) {
      traverseInorderRecursive(node.getLeft());
      System.out.print(node.getValue() + " ");
      traverseInorderRecursive(node.getRight());
    }
  }
}