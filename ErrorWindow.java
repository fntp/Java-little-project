package hh;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ErrorWindow {
    JFrame jf;
    Button bt;
    public ErrorWindow(String ss) {
        jf = new JFrame("error");
        bt = new Button(ss);
        bt.setBounds(20, 20, 40, 80);
        jf.setSize(320, 200);
        jf.setLayout(new BorderLayout());
        jf.add(bt,BorderLayout.CENTER);
        new MyTool().setJFrameLcotionCenter(jf);
        jf.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\close.png"));
        bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
            }
        });
        
        jf.setVisible(true);
    }
}
 
 
