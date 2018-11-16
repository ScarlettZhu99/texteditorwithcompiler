

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author mengyueming
 */
public class TextEditor extends JFrame {
    JMenu m = new JMenu("File");
    JMenu n = new JMenu("Build");
    JMenuItem m4 = new JMenuItem("Quit");
    JMenuItem n1 = new JMenuItem("Compile");
    public TextEditor(){
        super("Menus");
        setSize(500,500);
        Container c = getContentPane();
        JTextArea t = new JTextArea();
        Font f = new Font("Helvetica", Font.BOLD, 24);
        t.setFont(f);
        t.addKeyListener(new MyKeyListener());
        c.add(t,BorderLayout.CENTER);
        
     //menu
        JMenuItem m1 = new JMenuItem("New");
        JMenuItem m2 = new JMenuItem("Save");
        JMenuItem m3 = new JMenuItem("Open");
        JMenuItem n2 = new JMenuItem("Run");
        m1.addActionListener(new MyListener());
        m2.addActionListener(new MyListener());
        m3.addActionListener(new MyListener());
        m4.addActionListener(new MyListener());
       n1.addActionListener((ActionEvent e) -> {
            try {
                runProcessUsingRuntime();
            } catch (Exception ex) {
                Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
 
    });
       
        n2.addActionListener(new MyListener());
        m.add(m1);
        m.add(m2);
        m.add(m3);
        m.add(m4);
        n.add(n1);
        n.add(n2);
        JMenuBar menubar = new JMenuBar();
        menubar.add(m);
        menubar.add(n);
        setJMenuBar(menubar);
        setVisible(true); 
        ShowDIalog();
   
    } 
    
 

private  void ShowDIalog(){

   m4.addActionListener((ActionEvent e) -> {
       int x = JOptionPane.showConfirmDialog(null, "Do you want to save", "Not save yet", JOptionPane.YES_NO_OPTION);
       if (x==JOptionPane.NO_OPTION) {
System.exit(0);
}
    });
   n1.addActionListener((ActionEvent e) -> {
       int y = JOptionPane.showConfirmDialog(null, "Do you want to save", "Not save yet", JOptionPane.YES_NO_OPTION);
       if (y==JOptionPane.NO_OPTION) {
           
System.exit(0);
}

    });
  setVisible(true); 
  
}

 
    


    class MyKeyListener implements KeyListener{
    @Override
    public void keyTyped(KeyEvent e) {
    
        System.out.print(e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
    
    }

    
    @Override
    public void keyReleased(KeyEvent e) {
    
    }
        
    }
    class MyListener implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) { 
       
   }
        
    }
    public static void runProcessUsingRuntime() throws Exception {
        Runtime r= Runtime.getRuntime();
        Process p = r.exec("javac test.java");
        BufferedReader isr = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        String line;
        while ((line = isr.readLine()) != null)
            System.out.println(line);
        int status = p.exitValue();
        System.out.println("Process ran with result: " + status);        
    }
    
    public static void main(String[] args){
        new TextEditor();
       
    }
}
    


