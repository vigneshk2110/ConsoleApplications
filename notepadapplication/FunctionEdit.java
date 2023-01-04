package notepadapplication;

public class FunctionEdit {
    GraphicalOutlook graphicalOutlook;
    public FunctionEdit(GraphicalOutlook graphicalOutlook){
        this.graphicalOutlook = graphicalOutlook;
    }
    public void undo(){
        graphicalOutlook.undoManager.undo();
    }
    public void redo(){
        graphicalOutlook.undoManager.redo();
    }
}
