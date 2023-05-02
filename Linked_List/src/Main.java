public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        var List = new LinkedList();
        List.addLast(20);
        List.addLast(30);
        List.addLast(40);
        List.addFirst(50);

        System.out.println(List.indexOf(40));
        System.out.println(List.contains(20));
        System.out.println(List.contains(80));

        List.deleteFirst();

    }
}