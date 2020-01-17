package hh;
import java.io.*;
import java.util.*;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;
import hh.*;
public class JxExcel {
//	创建一个工作表scxbook
    public Workbook scxbook;
//  创建一个文件类file对象
    public File file;
//    初始化构造方法，抛出读取文件excel异常
    public JxExcel(File file) throws BiffException, IOException {
        this.file=file;
    }
    public List<String> getRowName(String name) throws 
    BiffException, IOException, WriteException, InterruptedException {
//    	抛出biffexception即excel文件读取异常，输入输出异常，写入异常以及中断连接异常，
        scxbook = Workbook.getWorkbook(file);
        List<String> list = new ArrayList<String>();
         // 2、声明工作簿对象
        Sheet firstsheet = scxbook.getSheet(0);
//        获取当前xls文件中的第一个页面
        int row = firstsheet.getRows();
//        获取第一个页面的行数
        int col = firstsheet.getColumns();
//        获取第一个页面的列数
        StringBuffer scxBuffer=new StringBuffer();
//		找到名字为mame的这列@2
//        BF算法的直接实现
//       效率过低，没必要使用BF匹配算法
//        for (int i = 0; i < col; i++) {
//			scxBuffer.append(firstsheet.getCell(i, 0).getContents());
//		}
//        String yu=scxBuffer.toString();
//        BF_pipei scxsheet_rowsof_name = new BF_pipei();
//        scxsheet_rowsof_name.bfFind(yu, name, 0);
        for (int i = 0; i < col; i++) {
//			找到名字为mame的这列
            if(firstsheet.getCell(i, 0).getContents().equals(name)) {
                col=i;
                break;
            }
        }

        for (int i = 1; i < row; i++) {
            list.add(firstsheet.getCell(col, i).getContents());
        }
        
        //获取名单时就创建得分的sheet 
        Sheet sheet = scxbook.getSheet(1);
        if (sheet==null)createSheet(name);
        scxbook.close();
        return list;
    }
    
    public void createSheet(String name) throws BiffException, IOException, WriteException, InterruptedException{
        //以下是参考博客园的博客
//               //获得文件    
//               Workbook wb = Workbook.getWorkbook(new File ("Test.xls"));
//               //打开一个文件的副本，并且指定数据写回到原文件
//               WritableWorkbook book = Workbook.createWorkbook(new File ("Test.xls"), wb);
//               WritableSheet sheet = book.createSheet("sheet_two", 1);
//               sheet.addCell(new Label(0,0,"Test data for sheet_two"));
//               //输出
//               System.out.println(sheet.getCell(0, 0).getContents());    
//              book.write();
//              book.close();   
 
//      Workbook wb = Workbook.getWorkbook(file);
        
        scxbook = Workbook.getWorkbook(file);
        WritableWorkbook ww = Workbook.createWorkbook(file,scxbook);
        //第一个sheel
        Sheet sheet1 = scxbook.getSheet(0);
        int row = sheet1.getRows();
        //创建sheet
        WritableSheet sheet2=ww.createSheet("得分", 1);
        sheet2.addCell(new Label(1, 0, "分数"));
        
        int col = sheet1.getColumns();
        for (int i = 0; i < col; i++) {//找到名字为name的这列
            if(sheet1.getCell(i, 0).getContents().equals(name)) {
                col=i;
                break;
            }
        }
        
        for (int i = 0; i < row; i++) {
                //第一个参数是列，第二个是行 ，第三个是value
                sheet2.addCell(new Label(0, i, sheet1.getCell(col, i).getContents()));
                if(i!=0)sheet2.addCell(new Label(1, i, "0"));
        }
        ww.write();
        ww.close();
        scxbook.close();
    }
    public void addScore(String studentName , int score) throws IOException, RowsExceededException, WriteException, BiffException {
        scxbook = Workbook.getWorkbook(file);
         WritableWorkbook ww = Workbook.createWorkbook(file,scxbook);
         Sheet sheet0 = scxbook.getSheet(1);
         WritableSheet sheet = ww.getSheet(1);
         int row = sheet.getRows();
         for (int i = 1; i < row; i++) {
             if(sheet0.getCell(0, i).getContents().toString().equals(studentName)) {
                 int n = Integer.parseInt(sheet0.getCell(1, i).getContents().toString());
                 sheet.addCell(new Label(1, i, String.valueOf(n+score)));
             }
        }
        ww.write();
        ww.close();
        scxbook.close();
    }
    
    public String findScore(String studentName) throws IOException, RowsExceededException, WriteException, BiffException {
        scxbook = Workbook.getWorkbook(file);
         Sheet sheet0 = scxbook.getSheet(1);
         int row = sheet0.getRows();
         for (int i = 1; i < row; i++) {
             if(sheet0.getCell(0, i).getContents().toString().equals(studentName)) {
                return sheet0.getCell(1,i).getContents().toString();
             }
        }
        scxbook.close();
        return null;
    }
}
