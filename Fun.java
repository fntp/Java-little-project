package hh;
import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
 
/***
 * 这个类主要处理JxExcel的异常
 */
public class Fun {
    JxExcel jce;
    public Fun(File file) {
        try {
            jce = new JxExcel(file);
        } catch (BiffException | IOException e) {
            e.printStackTrace();
        }
    }
    
    public List<String> getRowName(String name){
        try {
            return jce.getRowName(name);
        } catch (BiffException | WriteException | IOException | InterruptedException e) {
            new ErrorWindow("文件发生错误");
            e.printStackTrace();
        }
        System.out.println("获取名单失败！");
        return null;
    }
    
    public void addScore(String studentName , int score) {
        try {
            jce.addScore(studentName, score);
        } catch (WriteException | BiffException | IOException e) {
            new ErrorWindow("文件发生错误");
            e.printStackTrace();
        }
    }
    
    public String findScore(String studentName) {
        try {
            return jce.findScore(studentName);
        } catch (WriteException | BiffException | IOException e) {
            new ErrorWindow("文件发生错误");
            e.printStackTrace();
        }
        return null;
    }
 
}
 
