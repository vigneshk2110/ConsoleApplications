package notepadapplication;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Functionalities {
    GraphicalOutlook graphicalOutlookObject;
    String fileName;
    String fileAddress;
    public Functionalities(GraphicalOutlook graphicalOutlookObject){
        this.graphicalOutlookObject=graphicalOutlookObject;
    }
    public void newFile(){
         graphicalOutlookObject.textArea.setText("");
        graphicalOutlookObject.window.setTitle("New");
        fileName=null;
        fileAddress=null;
    }
    public void openFile(){
        FileDialog fileDialog = new FileDialog(graphicalOutlookObject.window , "Open", FileDialog.LOAD);
        fileDialog.setVisible(true);
        if(fileDialog.getFile()!=null){
            fileName = fileDialog.getFile();
            fileAddress=fileDialog.getDirectory();
            graphicalOutlookObject.window.setTitle(fileName);
        }
        System.out.println("file found! ");
        System.out.println(fileName+" /"+fileAddress);
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileAddress + fileName));
            graphicalOutlookObject.textArea.setText("");
            String line = null;
            while((line=bufferedReader.readLine())!=null){
                graphicalOutlookObject.textArea.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch (Exception exception){
            System.out.println("File not Found exception at line 36");
        }
    }
    public void save(){
        if(fileName==null){
            saveAs();
        }
        else {
            try {
                FileWriter fileWriter = new FileWriter(fileAddress + fileName);
                fileWriter.write(graphicalOutlookObject.textArea.getText());
                graphicalOutlookObject.window.setTitle(fileName);
                fileWriter.close();
            }
            catch (Exception exception){
                System.out.println("exception at line 53 of functionalities!!!");
                System.out.println("Something went wrong!!!");
            }
        }
    }
    public void saveAs(){
        FileDialog fileDialog = new FileDialog(graphicalOutlookObject.window, "Save",FileDialog.SAVE);
        fileDialog.setVisible(true);
        if((fileDialog.getFile())!=null){
            fileName=fileDialog.getFile();
            fileAddress=fileDialog.getDirectory();
            graphicalOutlookObject.window.setTitle(fileName);
        }
        try {
            FileWriter fileWriter = new FileWriter(fileAddress + fileName);
            fileWriter.write(graphicalOutlookObject.textArea.getText());
            fileWriter.close();
        }
        catch (Exception exception){
            System.out.println("exception at line 56 of functionalities!!!");
            System.out.println("Something went wrong!!!");
        }
    }
    public void exit(){
        System.exit(0);
    }
}
