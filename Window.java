package hh;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
public class Window implements ActionListener {
    JFrame jf;
    JMenuBar bar;
    JMenu fileMenu;
    JMenuItem  openItem,  closeItem;
    ImageIcon  openIcon,  closeIcon;
    JFileChooser chooser;
    JLabel jt1,jt2,jt3,jt4,jt5;
    JButton bt1,bt2;
    JTextField jtext;
    File file;
    ArrayList list;
    public Window() {
        newWindow();
        MyTool tool = new MyTool();
        tool.setJFrameImage(jf);
        jf.setSize(380, 250);
        tool.setJFrameLcotionCenter(jf);
        jf.setVisible(true);
        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
         public void newWindow() {
        jf = new JFrame("随机点名器");
        jf.setLayout(null);
        bar = new JMenuBar(); // new一个菜单条
        fileMenu = new JMenu("打开文件"); // 菜单栏里面的菜单
        openIcon = new ImageIcon("img\\open.png");
        closeIcon = new ImageIcon("img\\close.png");
         openItem = new JMenuItem("打开（O）", openIcon);
        closeItem = new JMenuItem("关闭（X）", closeIcon);
        jt1 = new JLabel("姓名：");
        jt2 = new JLabel("***");
        jt3 = new JLabel("当前分数:");
        jt4 = new JLabel("**");
        jt5 = new JLabel("请输入当前得分：");
        jtext = new JTextField();
        bt1 = new JButton("提交");
        bt2 = new JButton("开始抽取");
        
        jt1.setBounds(70, 15, 150, 20);
        jt2.setBounds(110, 15, 150, 20);
        jt3.setBounds(190, 15, 150, 20);
        jt4.setBounds(250, 15, 150, 20);
        
        jt5.setBounds(55, 50, 150, 20);
        jtext.setBounds(155, 50, 150, 20);
        
        bt1.setBounds(105, 90, 150, 20);
        bt2.setBounds(105, 120, 150, 20);
        
        bt1.addActionListener(new ActionListener() {//提交
            public void actionPerformed(ActionEvent e) {
                if(file==null) new ErrorWindow("请选取文件");
                else {
                String name = jt2.getText();
                String text = jtext.getText();
                int score = 0;
                try {
                     score = Integer.parseInt(text);
                } catch (Exception e2) {
                    new ErrorWindow("请输入正确的数字！");
                }
                if(!name.equals(null)) new Fun(file).addScore(name, score);
                jt4.setText(new Fun(file).findScore(name));
                jtext.setText("");
            }
        }});
        
        bt2.addActionListener(new ActionListener() {//开始抽取
            public void actionPerformed(ActionEvent e) {
                if(list==null) new ErrorWindow("请选取文件");
                else {
                    RandomNumber ran = new RandomNumber();
                    String name=(String) list.get(ran.getRandomNumber(list.size()));
                    jt2.setText(name);
                    jt4.setText(new Fun(file).findScore(name));
                }
            }
        });
        
        
 
        // 添加快捷键
        openItem.setMnemonic(KeyEvent.VK_O);
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Event.CTRL_MASK));
        closeItem.setMnemonic(KeyEvent.VK_X);
        closeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));
 
        // 添加监听器
        openItem.addActionListener(this);
        closeItem.addActionListener(this);
        chooser = new JFileChooser();// Chooser 选择器
        jf.setJMenuBar(bar);
        bar.add(fileMenu);
        jf.add(jt1);
        jf.add(jt2);
        jf.add(jt3);
        jf.add(jt4);
        jf.add(jt5);
        jf.add(jtext);
        jf.add(bt1);
        jf.add(bt2);
        
        
        fileMenu.add(openItem);
        fileMenu.add(closeItem);
    }
 
    // 按钮事件监听
    public void actionPerformed(ActionEvent e) {
        JMenuItem performed = (JMenuItem) e.getSource();
            if (performed == openItem) {
            chooser.showOpenDialog(null);// Dialog 会话
            file = chooser.getSelectedFile();   
            list = (ArrayList) new Fun(file).getRowName("姓名");  
        } else if (performed == closeItem) {
            System.exit(1);
        }
    }
 
 
}
