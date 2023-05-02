import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String str = "(( [a] + <2> )) [a]";
        Stack<Character> stk = new Stack<>();
        ArrayList<Character> arr = new ArrayList<>();

        for (Character i : str.toCharArray()) {
            stk.push(i);
        }
        while (!stk.empty()) {
            arr.add(stk.pop());
        }

        Syntax_Checker chkstr = new Syntax_Checker();
        System.out.println(chkstr.Check(arr));
    }
}