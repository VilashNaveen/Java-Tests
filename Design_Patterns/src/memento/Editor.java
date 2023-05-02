package memento;

public class Editor {
    private String content;
    private History history = new History();

    public String getContent() {
        return content;
    }

    public void createState(String content) {
        this.content = content;
        this.history.push(content);
    }
    public void restoreState() {
        this.content = history.pop();
    }
}
