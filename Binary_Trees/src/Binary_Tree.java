import com.sun.source.tree.Tree;

import java.util.ArrayList;

public class Binary_Tree {
    private class Node {
        private int value;
        private Node leftchild = null;
        private Node rightchild = null;
    }
    protected Node root;
    //Insert value
    public void Insert(int value) {
        if (root == null) {
            root = new Node();
            root.value = value;
            return;
        }
        var current = root;
        while (true) {
            if (current.value > value) {
                if (current.leftchild == null) {
                    current.leftchild = new Node();
                    current.leftchild.value = value;
                    break;
                }
                current = current.leftchild;
            } else if (current.value < value) {
                if (current.rightchild == null) {
                    current.rightchild = new Node();
                    current.rightchild.value = value;
                    break;
                }
                current = current.rightchild;
            } else {
                // Decide how to handle duplicates
                break;
            }
        }
    }
    //Find value
    public boolean Find(int value) {
        var current = root;
        while (true) {
            if (current == null) {
                return false;
            }
            if (current.value == value) {
                return true;
            }
            if (current.value >= value ) {
                current = current.leftchild;
            }
            else {
                current = current.rightchild;
            }
        }
    }
    // delete function
    public void Delete(int ValueToDelete) {
        root = Delete(root,ValueToDelete);
    }
    private Node Delete(Node root, int value) {
        if (root == null) {
            return root;
        }
        if (value < root.value) {
            root.leftchild = Delete(root.leftchild, value);
        }
        else if (value > root.value) {
            root.rightchild = Delete(root.rightchild, value);
        }
        else {
            if (root.rightchild == null && root.leftchild == null) {
                return null;
            }
            else if (root.leftchild != null && root.rightchild == null) {
                return root.leftchild;
            }
            else if (root.rightchild != null && root.leftchild == null) {
                return root.rightchild;
            }
            else {
                root.value = TreeMin(root.rightchild);
                root.rightchild = Delete(root.rightchild, root.value);
            }
        }
        return root;
    }

    //Traversal Overriding
    public void TraversalPreOrder() {
        TraversePreOrder(root);
    }
    public void TraversalInOrder() {
        TraversalInOrder(root);
    }
    public void TraversalPostOrder() {
        TraversePostOrder(root);
    }
    //Traversals
    public void TraversePreOrder (Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        TraversePreOrder(root.leftchild);
        TraversePreOrder(root.rightchild);
    }
    public void TraversalInOrder (Node root) {
        if (root == null) {
            return;
        }
        TraversalInOrder(root.leftchild);
        System.out.println(root.value);
        TraversalInOrder(root.rightchild);
    }
    public void TraversePostOrder (Node root) {
        if (root == null) {
            return;
        }
        TraversePostOrder(root.leftchild);
        TraversePostOrder(root.rightchild);
        System.out.println(root.value);
    }

    //Tree height
    public int TreeHeight()  {
        return TreeHeight(root);
    }
    public int TreeHeight(Node root) {
        if (root == null) {
            return -1;
        }
        if (root.leftchild == null && root.rightchild == null) {
            return 0;
        }
        return 1 + Math.max(TreeHeight(root.leftchild),
                TreeHeight(root.rightchild));
    }

    //Minimum value
    public int TreeMin() {
        return TreeMin(root);
    }
    public int TreeMin (Node root) {
        if (root == null) {
            return 10000000;
        }
        if (root.leftchild == null && root.rightchild == null) {
            return root.value;
        }
        var left = TreeMin(root.leftchild);
        var right = TreeMin(root.rightchild);

        return Math.min(Math.min(left,right),root.value);
    }

    //equals function
    public void Traversepreorder (Node root, ArrayList arr) {
        if (root == null) {
            return;
        }
        arr.add(root.value);
        Traversepreorder(root.leftchild, arr);
        Traversepreorder(root.rightchild, arr);
    }
    public boolean Equals(Node root2) {
        return Equals(root, root2);
    }
    public boolean Equals(Node root,Node root2 ) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        Traversepreorder(root,arr1);
        Traversepreorder(root2,arr2);
        if (arr1.size() != arr2.size() ) {
            return false;
        }
        for (int i = 0; i< arr1.size(); i++ ) {
            if (arr1.get(i) != arr2.get(i)) {
                return false;
            }
        }
        return true;
    }
      //improved equal function
    public boolean Equals_Improved(Node root2) {
        return Equals_Improved(root,root2 );
    }
    private boolean Equals_Improved (Node first, Node second) {
        if (first == null && second == null) {
            return true;
        }
        if (first != null && second != null) {
            return first.value == second.value &&
                    Equals_Improved(first.leftchild,second.leftchild) &&
                    Equals_Improved(first.rightchild,second.rightchild);
        }
        return false;
    }

    //tree validation
    public boolean Validate(int min, int max) {
        return Validate(root,min,max);
    }
    private boolean Validate(Node root, int min, int max) {
        if (root == null) {
             return true;
        }
        return (min < root.value) && (root.value < max) &&
                Validate(root.leftchild,min, root.value) &&
                Validate(root.rightchild, root.value, max);
    }

    //Node at K distance (this prints all nodes after certain distance)
    public void Nodes_at_Level(int k) {
        int index = 0;
        Nodes_at_Level(index,root,k);
    }
    private void Nodes_at_Level (int index, Node root,int k) {
        if (root == null) {
            return;
        }
        index++;
        if (index > k) {
            System.out.print(root.value + " ");
        }
        Nodes_at_Level(index,root.leftchild,k);
        Nodes_at_Level(index, root.rightchild,k);
    }

    //level by level traversal
    /*
    public void TraversLevelOrder() {
        for (var i = 0; i <= TreeHeight(root); i++) {

        }
    }
     */
}
