package hh;
import java.awt.*;
import java.awt.Toolkit;
//Toolkit设置图像
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import hh.*;
public class xinraunyasuo {
	static Huffman yuHuffman= new Huffman();
	static String coding;
	Cache scx= new Cache();
    public static void main(String[] args) {
        //创建窗体对象
        JFrame jf = new JFrame("鑫软压缩");
        Toolkit t1 = Toolkit.getDefaultToolkit();
        String ss = "C:\\Users\\Administrator\\Desktop\\yu\\src\\img\\05.png";
        Image image = t1.getImage(ss);
        jf.setIconImage(image);
        jf.setVisible(true);
        //设置大小
        jf.setSize(323, 506);
        //设置居中
        jf.setLocationRelativeTo(null);
        //设置布局
        jf.setLayout(new FlowLayout());
        //设置关闭事件
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //添加label
        Label yasuoneirong = new Label("运行内存");
        Label runtime = new Label("运行时间");
        Label runrom = new Label("压缩内容");
        //添加文本框
        final TextField neirongkuang = new TextField(30);
        neirongkuang.setColumns(30);
        final TextField runshijian = new TextField(30);
        runshijian.setColumns(30);
        final TextField yunxingneicun = new TextField(30);
        yunxingneicun.setColumns(30);
        //添加按钮
        Button confirm = new Button("哈夫曼压缩");
        Button jiema=new Button("哈夫曼解压");
        Button cancel = new Button("取消");   
        JTextArea jta = new JTextArea(10, 15);  
        jta.setTabSize(4);  
        jta.setFont(new Font("楷体", Font.BOLD, 16));  
        jta.setLineWrap(true);// 激活自动换行功能  
        jta.setWrapStyleWord(true);// 激活断行不断字功能  
        jta.setBackground(Color.CYAN);  
        JScrollPane jscrollPane = new JScrollPane(jta);  
        JPanel jpanel = new JPanel();  
        jpanel.setLayout(new GridLayout(1, 3));
        jpanel.add(jscrollPane);
//        ====================================
        //添加程序主页背景
        String url = "C:/Users/Administrator/Desktop/yu/src/img/02.png";
        ImageIcon img = new ImageIcon(url);
        JLabel label = new JLabel(img);
        jf.add(label);
        jf.add(yasuoneirong);
        jf.add(yunxingneicun);
        jf.add(runtime);
        jf.add(runshijian);
        jf.add(runrom);
        jf.add(neirongkuang);
        jf.add(confirm);
        jf.add(jiema);
        jf.add(cancel);
        jf.add(jpanel);
        neirongkuang.setText("在这里输入字符串！");
//        "程序运行时间： "+(endTime - startTime)+"ms"
        //添加事件
        jta.setText("欢迎使用鑫软哈夫曼压缩测试工具，"
        		+ "请在对应的文本输入区域输入您要压缩的内容！"
        		+ "然后点击哈夫曼压缩，本文本框会显示所有压缩内容！"
        		+ "如需要解码，只需要直接点击哈夫曼解码，就可以"
        		+ "一键哈夫曼解码数据流！鑫软出品，qq358566760！");
        confirm.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	String neirong=null;
            	long Beginningtime=System.currentTimeMillis();
            		try {
//                        yuHuffman.createCodeTable(neirongkuang.getText());
                        yuHuffman.createCodeTable(neirong);
                       coding = yuHuffman.enCode(neirong);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
            		long endTime=System.currentTimeMillis();
            		jta.setText("哈夫曼编码:"+coding); //哈夫曼编码
            		yunxingneicun.setText("虚拟机剩余内存:"+Cache.cache()+"消耗内存:"+Runtime.getRuntime().freeMemory()/1024/1024+"M");
            		runshijian.setText("程序运行时间： "+(endTime - Beginningtime)+"ms");
            }
        });
        cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        //解压
        jiema.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	try {
					coding =yuHuffman.deCode(coding);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
             jta.setText("解码后字符串:"+coding); //
            }
        });
        
    }
//    内存占用计算
   
}
class Cache{
	 public static String cache() {
			return ((Runtime.getRuntime().maxMemory()/1024/1024-Runtime.getRuntime().freeMemory()/1024/1024)+"M");
		}
}
