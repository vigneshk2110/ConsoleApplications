package notepadapplication;

import java.awt.*;

public class FormatFunctions {
    GraphicalOutlook graphicalOutlook;
    Font arial,comicSansMS,timesNewRoman;
    String selectedFont;
    public FormatFunctions(GraphicalOutlook graphicalOutlook){
        this.graphicalOutlook = graphicalOutlook;
    }
    public void wordWrap(){
        if(graphicalOutlook.wordWrapOn==false){
            graphicalOutlook.wordWrapOn=true;
            graphicalOutlook.textArea.setLineWrap(true);
            graphicalOutlook.textArea.setWrapStyleWord(true);
            graphicalOutlook.myWrap.setText("Word Wrap : On");
        }
        else if(graphicalOutlook.wordWrapOn==true){
            graphicalOutlook.wordWrapOn=false;
            graphicalOutlook.textArea.setLineWrap(false);
            graphicalOutlook.textArea.setWrapStyleWord(false);
            graphicalOutlook.myWrap.setText("Word Wrap : Off");
        }
    }
    public void fontWrap(int fontSize){
        arial = new Font("Arial",Font.PLAIN,fontSize);
        comicSansMS = new Font("Comic Sans MS",Font.PLAIN,fontSize);
        timesNewRoman = new Font("Times New Roman",Font.PLAIN,fontSize);

        setFont(selectedFont);
    }
    public void setFont(String font){
        selectedFont = font;
        switch (selectedFont){
            case "Arial":
                graphicalOutlook.textArea.setFont(arial);
                break;
            case "Comic Sans MS":
                graphicalOutlook.textArea.setFont(comicSansMS);
                break;
            case "Times New Roman":
                graphicalOutlook.textArea.setFont(timesNewRoman);
                break;
        }
    }
}
