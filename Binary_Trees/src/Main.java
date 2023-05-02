public class Main {
    public static void main(String[] args) {
        /*
        Binary_Tree tree = new Binary_Tree();
        tree.Insert(5);
        tree.Insert(6);
        tree.Insert(1);
        tree.Insert(2);
        tree.Insert(7);
        tree.Insert(9);
        tree.Insert(8);
        tree.Insert(10);

        Binary_Tree tree2 = new Binary_Tree();
        tree2.Insert(5);
        tree2.Insert(6);
        tree2.Insert(1);
        tree2.Insert(2);
        tree2.Insert(7);
        tree2.Insert(9);
        tree2.Insert(8);
        tree2.Insert(10);

        System.out.println(tree.Find(9));
        System.out.println(tree.Find(11));

        //tree.TraversePreOrder(tree.root);
        tree.TraversalInOrder(tree.root);

        System.out.println(tree.TreeHeight());
        System.out.println(tree.TreeMin());
        //equal function
        System.out.println(tree.Equals(tree2.root));
        System.out.println(tree.Equals_Improved(tree2.root));

        //validate function
        System.out.println(tree.Validate(Integer.MIN_VALUE,Integer.MAX_VALUE));

        //nodes at a certain level
        tree.Nodes_at_Level(3);
        System.out.println();

        //delete function
        tree.Delete(2);
        tree.TraversalInOrder();

         */
        Binary_Tree tree3 = new Binary_Tree();
        int arr[] = {1,3,5,7,9,11,13,2,4,6,8,10,12};
        for (int i = 0; i < arr.length; i++) {
            tree3.Insert(arr[i]);
        }
        System.out.println();
    }
}
