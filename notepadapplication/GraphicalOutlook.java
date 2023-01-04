package notepadapplication;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalOutlook implements ActionListener {
    JFrame window;
    JTextArea textArea;

    JScrollPane scrollPane;
    boolean wordWrapOn = false;

    JMenuBar menuBar;
    JMenu menuFile , menuEdit, menuFormat, menuColor;

    JMenuItem myNew,myOpen,mySave,mySaveAs,myExit;
    JMenuItem myWrap , myFontArial, myFontCSMS, myFontTMR, myFontSize8, myFontSize12, myFontSize16,myFontSize20,myFontSize24;
    JMenuItem myUndo, myRedo;
    JMenu menuFont, menuFontSize;
    Functionalities file = new Functionalities(this);
    FormatFunctions formatFunctions = new FormatFunctions(this);
    UndoManager undoManager = new UndoManager();
    FunctionEdit functionEdit = new FunctionEdit(this);
    public static void main(String[] args) {
        new GraphicalOutlook();
    }
    GraphicalOutlook(){
        notePadWindow();
        textAreaPart();
        menuBar();
        fileMenu();
        editMenu();
        createFormat();
        formatFunctions.selectedFont="Times New Roman";
        formatFunctions.fontWrap(12);
        formatFunctions.wordWrap();
        window.setVisible(true);
    }
    private void notePadWindow(){
        window = new JFrame("Java Notepad");//title
        window.setSize(800,600);//size
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void textAreaPart(){
        textArea = new JTextArea();
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener(){
            public void undoableEditHappened(UndoableEditEvent editEvent){
                undoManager.addEdit(editEvent.getEdit());
            }
        });
        scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }
    private void menuBar(){
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);
        menuFile=new JMenu("File");
        menuBar.add(menuFile);
        menuEdit=new JMenu("Edit");
        menuBar.add(menuEdit);
        menuFormat=new JMenu("Format");
        menuBar.add(menuFormat);
    }
    private void fileMenu(){
        myNew=new JMenuItem("New");
        myNew.addActionListener(this);
        myNew.setActionCommand("New");
        menuFile.add(myNew);

        myOpen=new JMenuItem("Open");
        myOpen.addActionListener(this);
        myOpen.setActionCommand("Open");
        menuFile.add(myOpen);

        mySave=new JMenuItem("Save");
        mySave.addActionListener(this);
        mySave.setActionCommand("Save");
        menuFile.add(mySave);

        mySaveAs=new JMenuItem("Save As");
        mySaveAs.addActionListener(this);
        mySaveAs.setActionCommand("SaveAs");
        menuFile.add(mySaveAs);

        myExit=new JMenuItem("Exit");
        myExit.addActionListener(this);
        myExit.setActionCommand("Exit");
        menuFile.add(myExit);
    }
    private void createFormat(){
        myWrap=new JMenuItem("Word Wrap - Off");
        myWrap.addActionListener(this);
        myWrap.setActionCommand("Word Wrap");
        menuFormat.add(myWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);
        myFontArial=new JMenuItem("Arial");
        myFontArial.addActionListener(this);
        myFontArial.setActionCommand("Arial");
        menuFont.add(myFontArial);

        myFontCSMS=new JMenuItem("Comic Sans MS");
        myFontCSMS.addActionListener(this);
        myFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(myFontCSMS);

        myFontTMR=new JMenuItem("Times New Roman");
        myFontTMR.addActionListener(this);
        myFontTMR.setActionCommand("Times New Roman");
        menuFont.add(myFontTMR);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        myFontSize8=new JMenuItem("8");
        myFontSize8.addActionListener(this);
        myFontSize8.setActionCommand("size8");
        menuFontSize.add(myFontSize8);

        myFontSize12=new JMenuItem("12");
        myFontSize12.addActionListener(this);
        myFontSize12.setActionCommand("size12");
        menuFontSize.add(myFontSize12);

        myFontSize16=new JMenuItem("16");
        myFontSize16.addActionListener(this);
        myFontSize16.setActionCommand("size16");
        menuFontSize.add(myFontSize16);

        myFontSize20=new JMenuItem("20");
        myFontSize20.addActionListener(this);
        myFontSize20.setActionCommand("size20");
        menuFontSize.add(myFontSize20);

        myFontSize24=new JMenuItem("24");
        myFontSize24.addActionListener(this);
        myFontSize24.setActionCommand("size24");
        menuFontSize.add(myFontSize24);


    }
    private void editMenu(){
        myUndo = new JMenuItem("Undo");
        myUndo.addActionListener(this);
        myUndo.setActionCommand("Undo");
        menuEdit.add(myUndo);

        myRedo = new JMenuItem("Redo");
        myRedo.addActionListener(this);
        myRedo.setActionCommand("Redo");
        menuEdit.add(myRedo);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "New":
                file.newFile();
                break;
            case "Open":
                file.openFile();
                break;
            case "Save":
                file.save();
                break;
            case "SaveAs":
                file.saveAs();
                break;
            case "Exit":
                file.exit();
                break;
            case "Undo":
                functionEdit.undo();
                break;
            case "Redo":
                functionEdit.redo();
                break;
            case "Word Wrap":
                formatFunctions.wordWrap();
                break;
            case "Arial":
            case "Times New Roman":
            case "Comic Sans MS":
                formatFunctions.setFont(command);
                break;
            case "size8":
                formatFunctions.fontWrap(8);
                break;
            case "size12":
                formatFunctions.fontWrap(12);
                break;
            case "size16":
                formatFunctions.fontWrap(16);
                break;
            case "size20":
                formatFunctions.fontWrap(20);
                break;
            case "size24":
                formatFunctions.fontWrap(24);
                break;
        }
    }
}