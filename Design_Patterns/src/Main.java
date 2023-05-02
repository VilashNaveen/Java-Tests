import memento.Editor;
import state.BrushTool;
import state.Canvas;
import state.SelectionTool;

public class Main {
    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        canvas.setCurrentTool(new BrushTool());
        canvas.mouseUp();
        canvas.mouseUp();
        canvas.mouseDown();
    }
}