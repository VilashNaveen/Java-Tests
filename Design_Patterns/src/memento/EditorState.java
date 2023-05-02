package memento;

public class EditorState {
    private String states;

    public EditorState (String str) {
        this.states = str;
    }

    public String getStates() {
        return states;
    }
}
