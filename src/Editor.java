import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Editor implements ActionListener {
    JFrame md;
    JMenuBar Menu;
    JMenu file,edit;
    JMenuItem newfile,openfile,closefile,savefile;
    JMenuItem cut, copy,paste,selectAll,close;
    JTextArea area;

    Editor(){
        md=new JFrame();

//        insilize menu
        Menu=new JMenuBar();

        file=new JMenu("File");
        edit=new JMenu("Edit");

        Menu.add(file);
        Menu.add(edit);

//        Insilize Text area
        area=new JTextArea();


//        Insilize menu items
        newfile =new JMenuItem("New File");
        openfile=new JMenuItem("Open File");
        savefile=new JMenuItem("Save File");
        closefile=new JMenuItem("Close");
        file.add(newfile);
        file.add(openfile);
        file.add(closefile);
        file.add(savefile);

//        adding action to menu items
        newfile.addActionListener(this);
        openfile.addActionListener(this);
        closefile.addActionListener(this);
        savefile.addActionListener(this);




//        Insilziing items for menu in edit
        cut =new JMenuItem("cut");
        copy=new JMenuItem("copy");
        paste=new JMenuItem("paste");
        selectAll=new JMenuItem("select");
        close=new JMenuItem("close");
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(close);

//        adding action to edit items
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        close.addActionListener(this);


        md.add(area);
        md.setJMenuBar(Menu);
        md.setBounds(100,100,400,400);
        md.setVisible(true);
        md.setTitle("Editor Pro");
    }

    public static  void  main(String[] args){
        Editor start=new Editor();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
 if(e.getSource()==newfile){
     Editor start=new Editor();
 }

 if(e.getSource()==openfile){
     JFileChooser openFile =new JFileChooser("c");
     int chooseOption =openFile.showOpenDialog(null);

     if(chooseOption==JFileChooser.APPROVE_OPTION){
         File file =openFile.getSelectedFile();
         String path=file.getPath();
         try {
             BufferedReader bufferedReader =new BufferedReader(new FileReader(path));
             String intermidate=" ",output=" ";
             while ((intermidate=bufferedReader.readLine())!=null){
                 output+=intermidate +"\n";

             }
             area.setText(output);
         }catch (Exception error){
             System.out.println(error);
         }
     }

 }


 if(e.getSource()==savefile){
JFileChooser saveFile =new JFileChooser("c");
saveFile.setApproveButtonText("Save");
int chooseOption =saveFile.showSaveDialog(null);
if (chooseOption==JFileChooser.APPROVE_OPTION){
    File file =new File(saveFile.getSelectedFile().getAbsoluteFile()+"text");
    String filepath=file.getPath();
    try {
        BufferedWriter outfile=null;
        outfile=new BufferedWriter(new FileWriter(file));
        area.write(outfile);
        outfile.close();
    }catch(Exception error){
        System.out.println(error);
    }
}
        }
 if(e.getSource()==closefile){
     System.exit(0);
 }
 if(e.getSource()==close){
System.exit(0);
 }
 if(e.getSource()==copy){
     area.copy();
 }
 if(e.getSource()==paste){
area.paste();
 }
 if(e.getSource()==selectAll){

 }
 if(e.getSource()==cut){
area.cut();
 }
    }

}
