import java.util.*;

public class Graph {

    private HashMap<String,Node> nodes = new HashMap<>();
    private HashMap<Node, List<Node>> adjacencyList = new HashMap<>();

    private class Node{
        private String label = new String();
        public Node (String str) {
            label = str;
        }
        @Override
        public String toString() {
            return label;
        }
    }

    // initialize methods
    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label,node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }
    public void removeNode(String label) {
        var node = nodes.get(label);
        if (node == null)
            return;
        for (var n : adjacencyList.keySet()) {
            adjacencyList.get(n).remove(node);
        }
        adjacencyList.remove(node);
        nodes.remove(node);
    }
    public void addEdge (String label, String target) {
        var labelNode = nodes.get(label);
        if (labelNode == null)
            throw new IllegalArgumentException();
        var targetNode = nodes.get(target);
        if (targetNode == null)
            throw new IllegalArgumentException();

        adjacencyList.get(labelNode).add(targetNode);
    }
    public void removeEdge (String label, String target) {
        var labelNode = nodes.get(label);
        if (labelNode == null)
            throw new IllegalArgumentException();
        var targetNode = nodes.get(target);
        if (targetNode == null)
            throw new IllegalArgumentException();

        adjacencyList.get(labelNode).remove(targetNode);
    }

    public void print() {
        for (var keys: adjacencyList.keySet()) {
            var target = adjacencyList.get(keys);
            if (!target.isEmpty()){
                System.out.println(keys + " is connected to " + target);
            }
        }
    }

    //traversals depth first
    public void depthTraversal (String label) {
        var node = nodes.get(label);
        Set<String> set = new HashSet<>();
        depthTraversal(node,set);
    }

    //depth traversal
    private void depthTraversal (Node node, Set<String> set) {
        if (adjacencyList.get(node) == null && !set.contains(node.label)) {
            System.out.println(node.label);
            set.add(node.label);
            return;
        }
        else if (!set.contains(node.label)){
            System.out.println(node.label);
            set.add(node.label);
            for (var n : adjacencyList.get(node)) {
                depthTraversal(n,set);
            }
        }
    }
    public void depthTraversalItr(String label) {
        var node = nodes.get(label);
        Stack<Node> stk = new Stack<>();
        Set<Node> set = new HashSet<>();
        stk.push(node);
        set.add(node);

        while (!stk.empty()) {
            var current = stk.pop();
            if (set.contains(current)) {
                continue;
            }
            System.out.println(current.label);
            set.add(current);
            for (var neighbour : adjacencyList.get(current)) {
                if (!set.contains(neighbour)) {
                    stk.push(neighbour);
                }
            }
        }
    }

    //breath traversal
    public void breathTraversal (String label) {
        var node = nodes.get(label);
        if (node == null)
            throw new NoSuchElementException();
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        breathTraversal(queue,set);
    }
    private void breathTraversal (Queue<Node> queue, Set<Node> set){
        if (queue.isEmpty()) {
            return;
        }
        var i = queue.remove();
        System.out.println(i.label);
        for (var n : adjacencyList.get(i)) {
            if (!set.contains(n)) {
                queue.add(n);
                set.add(n);
            }
        }
        breathTraversal(queue,set);
    }

    public void topologicalSort(String label) {
        var node = nodes.get(label);
        if (node == null)
            throw new NoSuchElementException();
        Set<Node> set = new HashSet<>();
        Stack<Node> stk = new Stack<>();
        topologicalSort(set,node,stk);
        while (!stk.empty()) {
            System.out.println(stk.pop().label);
        }
    }
    //topological sort
    private void topologicalSort (Set<Node> set, Node node, Stack<Node> stk) {
        if (adjacencyList.get(node).isEmpty() && !set.contains(node)) {
            stk.push(node);
            set.add(node);
        }
        else if (!set.contains(node)) {
            for (var n: adjacencyList.get(node)) {
                topologicalSort(set,n,stk);
            }
            stk.push(node);
            set.add(node);
        }
    }
    public boolean hasCycle() {
        Set<Node> all = new HashSet<>();
        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        all.addAll(nodes.values());
        while (!all.isEmpty()) {
           var current = all.iterator().next();// iterator method
           if (hasCycle(current,all,visiting,visited)) {
               return true;
           }
        }
        return false;
    }
    private boolean hasCycle(Node node,Set<Node> all, Set<Node> visiting, Set<Node> visited) {
        all.remove(node);
        visiting.add(node);

        for (var neighbour :adjacencyList.get(node)) {
            if (visited.contains(neighbour))
                continue;
            if (visiting.contains(node))
                return true;
            if (hasCycle(neighbour,all,visiting,visited));
            return true;
        }
        visiting.remove(node);
        visited.add(node);
        return false;
    }


}
