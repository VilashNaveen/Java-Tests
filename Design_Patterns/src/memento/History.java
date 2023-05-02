package memento;
import java.util.Stack;

public class History {
    private Stack<EditorState> stk = new Stack<>();

    public void push(String state) {
        EditorState state1 = new EditorState(state);
        stk.push(state1);
    }
    public String pop() {
         return stk.pop().getStates();
    }
}
