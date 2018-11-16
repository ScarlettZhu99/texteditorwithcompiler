
/**
 *
 * @author Haiping Zhu
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
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
    
 

