package com.toropov.binary_tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    public static void main(String[]args){
        Node root = new Node(20,new Node(7,
                new Node(4,null,new Node(6,null,null)),
                new Node(9,null,null)),
                new Node(35,new Node(31,new Node(28,null,null),null),
                new Node(40,new Node(38,null,null), new Node(52,null,null))));
        System.out.println("1 Way: The sum of the tree nodes is equal to " + root.sumNodes());
        System.out.println("2 Way: The sum of the tree nodes is equal to " + sumDeep(root));
        System.out.println("3 Way: The sum of the tree nodes is equal to " + sumWide(root));
    }

    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(int value) {
            this.value = value;
        }

        //Рекурсия (Stack вызовов может быть переполнен)
        public int sumNodes() {
            int sum = value;
            if(left!=null){
                sum+= left.sumNodes();
            }
            if(right!=null){
                sum+=right.sumNodes();
            }
            return sum;
        }


    }

    public static int sumDeep(Node root){
        Deque<Node> stack = new ArrayDeque<Node>();
        stack.push(root);

        int sum = 0;
        while(!stack.isEmpty()){
            Node node = stack.pop();
            sum += node.value;

            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
        return sum;
    }

    public static int sumWide(Node root){
        Queue<Node> stack = new LinkedList<Node>();
        stack.add(root);

        int sum = 0;
        while(!stack.isEmpty()){
            Node node = stack.remove();
            sum += node.value;

            if(node.left != null)
                stack.add(node.left);

            if(node.right != null)
                stack.add(node.right);
        }
        return sum;
    }
}
