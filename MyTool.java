package hh;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFrame;
//给窗体设置图标
public class MyTool {
    public void setJFrameImage(JFrame jf) {
        Toolkit t1 = Toolkit.getDefaultToolkit();
        String ss = "C:\\Users\\Administrator\\Desktop\\tools\\src\\img\\02.png";
        Image image = t1.getImage(ss);
        jf.setIconImage(image);
    }	
//窗体位置自动居中
    public void setJFrameLcotionCenter(JFrame jf) {
        int jfw = jf.getWidth();
        int jfh = jf.getHeight();
        Toolkit t1 = Toolkit.getDefaultToolkit();
        Dimension screen = t1.getScreenSize();
        int winw = screen.width;
        int winh = screen.height;
        jf.setLocation((winw-jfw)/2,(winh-jfh)/2);
    }
 
}
 
