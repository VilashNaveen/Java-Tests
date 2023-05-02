public class AVL_Tree {
    private class AVL_Node {
        private int value;
        protected int height = 0;
        protected int balanceFactor = 0;
        private AVL_Node left = null;
        private AVL_Node right = null;
        public AVL_Node (int value) {
            this.value = value;
        }
        public AVL_Node() {
        }
    }
    // root
    protected AVL_Node root;

    // Insert method
    public void Insert(int value) {
        root = Insert(value, root);
    }
    private AVL_Node Insert(int value, AVL_Node node) {
        if (node == null) {
            node = new AVL_Node(value);
            node.height = 0;
            return node;
        }
        else if (node.value > value) {
            node.left = Insert(value,node.left);
        }
        else {
            node.right = Insert(value, node.right);
        }
        node.height = Math.max(height(node.left),height(node.right)) + 1;
        node.balanceFactor = balanceFactor(node);
        //rotating
        node = rotation(node);

        return node;
    }
    // height calculator
    private int height(AVL_Node node) {
        return (node == null) ? -1: node.height;
    }
    private void set_height (AVL_Node node) {
        node.height = Math.max(height(node.left),height(node.right)) + 1;
    }
    // height difference
    private int balanceFactor (AVL_Node node) {
        return height(node.left) - height(node.right);
    }
    //rotation
    private AVL_Node rotation (AVL_Node node) {
        if (node.balanceFactor < -1 ) {
            if (node.right.balanceFactor > 0) {
                node.right = rightRotate(node.right);
            }
            return leftRotate(node);

        }
        else if (node.balanceFactor > 1) {
            if (node.left.balanceFactor < 0) {
                node.left = leftRotate(node.left);
            }
            return rightRotate(node);
        }
        return node;
    }
    private AVL_Node leftRotate (AVL_Node node) {
        var newroot = node.right;
        node.right = newroot.left;
        newroot.left = node;

        set_height(node);
        set_height(newroot);

        return newroot;
    }
    private AVL_Node rightRotate (AVL_Node node) {
        var newroot = node.left;
        node.left = newroot.right;
        newroot.right = node;

        set_height(node);
        set_height(newroot);

        return newroot;
    }
}
