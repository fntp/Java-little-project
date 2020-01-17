package hh;
import java.time.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.net.*;
import java.io.*;
import hh.*;
//将主类直接继承了适配器监听类
public class mysinsy extends WindowAdapter{
	//首先编写一个无参数的构造方法， 用于直接创建窗口并
	//且设置窗口的基本属性，调用this直接监听新建窗口
	private ImageIcon img = new ImageIcon("src/img/u=1939795079,646244577&fm=26&gp=0.jpg");
	public mysinsy() {
		JFrame a=  new JFrame ("SINSY工具包");
		//新建窗口的标签，定义为背景图片
		JLabel label = new JLabel(img);
		//我对窗口进行了布局设置
		a.setLayout(new FlowLayout());
		//设置窗口大小
		a.setSize(500, 432);
		//设置窗口位置
		a.setLocation(300, 300);
		//设置窗口可见性
		a.setVisible(true);
		//设置窗口监听
		a.addWindowListener(this);
		//添加按钮，一共十个
		Button c= new Button("几点了鸭");
		Button e= new Button("截获当前IP地址");
		Button p= new Button("全网音乐");
		Button t=new Button("全网影视");
		Button h=new Button("在线工具箱");
		Button j= new Button("代码记录");
		Button u= new Button("端口扫描");
		Button w= new Button("在线破解工具包");
		Button r= new Button("关于软件");
		Button y= new Button("鑫软点名");
		Button x= new Button("鑫软娱乐");
		Button s= new Button("鑫软压缩");
		//添加到窗口可视化输出
		a.add(label);
		a.add(y);
		a.add(r);
		a.add(j);
		a.add(h);
		a.add(t);
		a.add(c);
		a.add(e);
		a.add(p);
		a.add(u);
		a.add(w);
		a.add(x);
		a.add(s);
		a.add(y);
		//对象所对应的鼠标监听事件
		c.addMouseListener(new MouseListener(){
			public void mouseReleased(MouseEvent e) {}
			//鼠标点击事件：
			public void mousePressed(MouseEvent e) {				
				//以下是获取当前时间的代码
				Calendar calendar = Calendar.getInstance();
				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH);
				int day = calendar.get(Calendar.DATE);
				int hour = calendar.get(Calendar.HOUR);
				int minute= calendar.get(Calendar.MINUTE);
				  int second = calendar.get(Calendar.SECOND);
				  //以窗口形式输出，并设置当前窗口的名称
				  JFrame a= new JFrame("当前时间");
				  //设置窗口大小
				  a.setSize(290, 100);
				  //设置窗口的位置
				  a.setLocation(500, 400);
				  StringBuffer scx=null;
				  scx=new StringBuffer("当前时间为："
				  		+ ""+year+"年"+(month+1)+"月"+
						  day+"日"+hour+"时"+
				  		minute+"分"+second+"秒");
				  JLabel time=new JLabel();
				  //输出时间
				  time.setText(scx.toString());
				  a.add(time);
				  a.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
		});
		e.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				//这里在鼠标点击事件中放入截获当前IP地址的方法
				InetAddress myip = null;
				try {
					myip = InetAddress.getLocalHost();
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				}
				JFrame pp= new JFrame("截获当前IP");
				StringBuffer u1= null;
				StringBuffer u2=null;
				u2=new StringBuffer("您的主机名是："+myip.getHostName());
				u1=new StringBuffer("您的IP地址是："+myip.getHostAddress());
				JLabel yu= new JLabel();
				//利用html的语法格式嵌入到java中，使得文字换行输出
				yu.setText("<html><body><p  align=\"center\">" 
				+u2.toString()+ "<br>" + 
				u1.toString() +"<body></html>");
				//实现换行
				pp.setBackground(Color.lightGray);
				//设置背景为灰色
				pp.add(yu);
		        pp.setVisible(true);
		        pp.setSize(210, 230);
		        pp.setLocation(300, 300);
			}
		});
		p.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				try {
					//调用try 方法进行调用系统浏览器进行打开相应的网页，这里是全网免费音乐
					 Runtime.getRuntime().exec(
					 "cmd   /c   start   https://music.mli.im/ ");
					 //同样，采用cmd指令来调用浏览器打开网页
				} catch (IOException o) {
					o.printStackTrace();
					//打印出现的所有异常情况
				}
			}
		});
		t.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				try {
					//同上
					 Runtime.getRuntime().exec(
					 "cmd   /c   start   www.goudaitv.cc ");
					 //同样采用cmd命令行直接调用浏览器跳转外站链接，打开vip影视会员中心
				} catch (IOException eq) {
					eq.printStackTrace();
				}
			}
		});
		h.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {	
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				try {
				//这里只用到了一个鼠标点击事件，其他的方法都未涉及。
					//调用后台cmd进行网页访问
					 Runtime.getRuntime().exec(
					 "cmd   /c   start   https://tool.lu/ ");
				} catch (IOException yu) {
					//抛出异常
					yu.printStackTrace();
				}
			}
		});
		//代码记录的创建事件
		j.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {	
			}
			public void mousePressed(MouseEvent e) {	
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				//创建代码记录的文本,创建的对象yu，通过调用对象来调用方法，实现输出
				ceshi yu= new ceshi();
				yu.fun();
				yu.ceshi();
			}
		});
		u.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {	
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				//直接通过创建对象来实现方法，实现端口扫描代码：
				 JFrame portscan=new PortScan();
			        portscan.setVisible(true);
			        //在设置窗口可见即可
			}
		});
		r.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {	
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				//这里用到了模板思想，即程序的代码优化法。设置通用的窗口模板，
				//通过传递参数进行直接调用，只需要修改参数，即可。简便实用！
				guanyu  ni= new guanyu();
				ni.gy("鑫软工具包V1.0.3", "本软件由鑫软工作室旺仔独立开发", 
						"感谢使用，QQ358566760", 
						"src/img/u=2754969206,1196262824&fm=26&gp=0.jpg",
						"关于鑫软工具包");
			}
		}); 
		y.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				//同上调用方法打开系统的浏览器
				 new Window();
			}
		});
		w.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {	
			}
			public void mousePressed(MouseEvent arg0) {	
			}
			public void mouseExited(MouseEvent arg0) {	
			}
			public void mouseEntered(MouseEvent arg0) {
			}
			public void mouseClicked(MouseEvent arg0) {
				try {
			//同上使用的方法打开相应的网址，打开相应的网页。
					 Runtime.getRuntime().exec(
				 "cmd   /c   start   https://down.52pojie.cn/Tools/");				
					 } catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
//		鑫软压缩
		s.addMouseListener(new MouseListener() {	
			public void mouseClicked(MouseEvent e) {
				xinraunyasuo scx = new xinraunyasuo();
				scx.main(null);
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		x.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				try {
					//同上
					 Runtime.getRuntime().exec(
					 "cmd   /c   start   www.sinsy.77sq.net ");
					 //同样采用cmd命令行直接调用浏览器跳转外站链接，打开鑫软网络
				} catch (IOException eq) {
					eq.printStackTrace();
				}
			}
		});
	}
			//定义一个容器方法
	private JPanel getContentPane() {
		return null;
	}

			//定义带参数的窗口关闭方法，实现窗口关闭
	public void windowClosing(WindowEvent windowEvent) {
		System.exit(0);
	}
			//整个主类的唯一主方法，用于在主方法中调用mysinsy的构造方法，新建一个用户图形界面GUI
	public static void main(String[] args) {
			//程序从这里开始运行，并且这里直接实现主界面的注册，即主界面的新建。
			//	相应的参数属性都在相应的子类中进行修改，主方法只负责调用即可！
		new mysinsy();
	}
}
			//以下是子类的的模板，直接创建模板对象，再通过对象来调用模板中的方法即可。
class  guanyu{
	String a,b,c,f;
	ImageIcon d;
	public void gy(String a, String b,String c,String d,String f){
	ImageIcon e=new ImageIcon(d);
	this.a=a;
	this.b=b;
	this.c=c;
	this.f=f;
			//将图片放入label中
	JLabel label=new JLabel(e);
			//设置label的大小
	label.setBounds(0,0,e.getIconWidth(),e.getIconHeight());
	JFrame guanyu=new JFrame(f);		
			//获取窗口的第二层，将label放入
	guanyu.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
			//获取frame的顶层容器,并设置为透明
	JPanel j=(JPanel)guanyu.getContentPane();
			//获取容器
	j.setOpaque(false);	 
	JPanel panel=new JPanel();
			//设置三个变量，分别表示标题，标签文本内容，以及图片的地址格式！
	JLabel jb=new JLabel(a);
	JLabel jb2=new JLabel(b);
	JLabel jb3= new JLabel(c);
	jb.setForeground(Color.GREEN);
	jb2.setForeground(Color.GREEN);
	jb3.setForeground(Color.GREEN);
	jb2.setFont(new Font("宋体",1,23));
	jb.setFont(new Font("宋体",1,23));
	jb3.setFont(new Font("宋体",1,23));
	panel.add(jb);
	panel.add(jb2);
	panel.add(jb3);
			//必须设置为透明的。否则看不到图片
	panel.setOpaque(false);
	guanyu.add(panel);
	guanyu.add(panel);
	guanyu.setSize(e.getIconWidth(),e.getIconHeight());
	guanyu.setVisible(true);
}
}
			//创建ceshi类，继承JFrame类
	 class ceshi extends JFrame{
		 public void fun(){
			//新建一个线程进行事件排列事件队列，当用户点击一个事件，这个事件会在事件队列当中，排队执行
			 EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
			//新建一个Jframe类型的ceshi窗口
							ceshi frame = new ceshi();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		 public void ceshi() {	
		}
		public ceshi() {
				setTitle("sinsy随身笔记");//标题
				//设置记事本的标题
				setBounds(400, 300, 300, 300);
				//父窗口的坐标和大小
				getContentPane().setLayout(null);
				//设置了自由布局但是如果下面需要进行流式布局会有布局模式刷新，覆盖为流式布局
				String beizhu="版本V1.0";
				//设置发布版本号
				String beizhu2="鑫软工作室荣誉出品";
				//设置发布信息
				JLabel pageLabel = new JLabel(beizhu , JLabel.RIGHT);
				JLabel pageLabe2 = new JLabel(beizhu2 , JLabel.RIGHT);
				//是使用Jlable创建一个标签pagelble1和2
				JButton bt = new JButton("点击创建");
				//按钮的变量名为bt
				bt.setBounds(80,80,120,60);
				//按钮的位置坐标和大小
				getContentPane().add(bt);
				//按钮添加到窗口中
				FlowLayout flo = new FlowLayout();
				//建立了流式空间布局界面，将控件进行流式布局
				setLayout(flo);
				add(pageLabel);
				add(pageLabe2);
				//将两个标签添加进窗口容器中
				setVisible(true);
				//设置控件可见性为可见
				bt.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						NotePal notePal = new NotePal();
				//调用notepal类声明对象，实现构造方法
					}
				});
			}
		 }
	  class NotePal extends JFrame implements ActionListener {
			private static final long serialVersionUID = 1L;
				//定义一个文本框
			JTextArea jTextArea = null;
				//定义一个菜单栏
			JMenuBar jMenuBar = null;
				//定义一个菜单
			JMenu jMenu1 = null;
				//定义一个“打开”子选项
			JMenuItem jMenuItem1 = null;
				//定义一个“保存”子选项
			JMenuItem jMenuItem2 = null;
				//定义一个文件选择
			JFileChooser jFileChooser = null;
				//定义一个FileReader文件输入流
			FileReader fileReader = null;
				//定义一个FileWriter输出流
			FileWriter fileWriter = null;
				//定义一个缓冲字符输入流
			BufferedReader bufferedReader = null;
						//定义一个缓冲字符输出流
			BufferedWriter bufferedWriter = null;
			@SuppressWarnings("unused")
						//并无实际意义
			public static void notepad() {
		        		//实例化
				NotePal notePal = new NotePal();
			}
						//构造函数
			public NotePal()
			{
						//实例化jTextArea
				jTextArea = new JTextArea();
						//实例化jMenuBar
				jMenuBar = new JMenuBar();
						//实例化就jMenu1，并设置其名字为“文件”
				jMenu1 = new JMenu("文件");
						//实例化就MenuItem1，并将其命名为“打开”
				jMenuItem1 = new JMenuItem("打开");
						//实现对jMenuItem1的监听
				jMenuItem1.addActionListener(this);
				jMenuItem1.setActionCommand("打开");
						//实例化就MenuItem2，并将其命名为“保存”
				jMenuItem2 = new JMenuItem("保存");
						//实现对jMenuItem2的监听
				jMenuItem2.addActionListener(this);
				jMenuItem2.setActionCommand("保存");				
						//设置jTextArea的背景颜色为
				jTextArea.setBackground(Color.gray);
						//将组件添加上各自的位置
						//将jMenuBar添加到JFrame中
				this.setJMenuBar(jMenuBar);
						//将jMenu添加到jMenuBar中
				jMenuBar.add(jMenu1);
						//将jMenuTItem1添加到Jmenu1中
				jMenu1.add(jMenuItem1);
						//将jMenuTItem2添加到Jmenu1中
				jMenu1.add(jMenuItem2);
						//将jTextArea添加到JFrame中
				this.add(jTextArea);
						//设置窗体的标题
				this.setTitle("SINSY笔记本");
						//设置窗体的大小
				this.setSize(800,600);
						//当关闭窗口的时候，关闭进程
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						//显示窗口
				this.setVisible(true);
			}
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("打开"))
				{
						//实例化一个JFileChoose
					jFileChooser = new JFileChooser();
						//设置文件选择窗口的名字
					jFileChooser.setDialogTitle("请选择路径");
						//设置文件窗口的默认路径
					jFileChooser.showOpenDialog(null);
						//显示文件窗口
					jFileChooser.setVisible(true);
						//用address保存用户编辑文件的绝对路径
						String address = jFileChooser.getSelectedFile().getAbsolutePath();
					try {
						//为fileReader分配空间
						fileReader = new FileReader(address);
						//为bufferedReader分配空间
						bufferedReader = new BufferedReader(fileReader);
						//定义一个str判断输入的字符是否已经为空
						String str = "";
						//定义一个strAll接收文件的全部信息
						String strAll = "";
						//读取文件信息，并将其保存到strAll中
						//循环嵌套
						while((str = bufferedReader.readLine()) != null)
						{
							strAll += str + "\r\n";
						}
						//将strAll中的全部信息显示到JTextArea上
						jTextArea.setText(strAll);
					} catch (Exception e2) {
						e2.printStackTrace();
					}finally{
						try {
							//关闭文件
							bufferedReader.close();
							fileReader.close();
						} catch (Exception e3) {
							e3.printStackTrace();
						}
					}	
				}
					//如果用户点的是保存按钮
				if(e.getActionCommand().equals("保存"))
				{
					//创建一个保存窗口
					JFileChooser jFileChooser1 = new JFileChooser();
					//设置窗口名字
					jFileChooser1.setDialogTitle("另存为... ...");
					//设置默认设置
					jFileChooser1.showSaveDialog(null);
					//显示窗口
					jFileChooser1.setVisible(true);
					try {
						//为fileWrite分配空间
						fileWriter = new FileWriter(jFileChooser1.getSelectedFile().getAbsolutePath());
						//为bufferedWrite分配空间
						bufferedWriter = new BufferedWriter(fileWriter);
						//保存进去
						bufferedWriter.write(this.jTextArea.getText());
					} catch (Exception e2) {
						e2.printStackTrace();
					}finally{
						//关闭文件
						try {
							bufferedWriter.close();
							fileWriter.close();
						} catch (Exception e3) {
							e3.printStackTrace();
						}
					}
				}
			}
		}
	  				//端口扫描功能模块
	  class PortScan extends JFrame {
		  	//直接采用与主类相同的方法直接继承JFrame，使得避免写窗口关闭等方法
		    JPanel center=new JPanel();
		    Box hBox0=Box.createHorizontalBox();
		     Box hBox1= Box.createHorizontalBox();
		     Box hBox2= Box.createHorizontalBox();
		     Box hBox3= Box.createHorizontalBox();
		    private JLabel state=new JLabel("关闭");
		    private JLabel HOST=new JLabel("主机名:");
		    private JLabel PORT=new JLabel("端口号:");
		    private JLabel STATE=new JLabel("状态：");
		    private JButton btn1=new JButton("开始扫描");
		    private JButton reset=new JButton("重置");
		    private JTextField host=new JTextField(20);
		    private JTextField port=new JTextField(7);
		    Font f1=new Font("隶书",Font.PLAIN,15);
		    public static void scan() {
		       //方法迁移到按钮点击事件中
		    }
		    
		    public PortScan(){
		        setTitle("PortScanner");
		        setSize(300, 200);
		        center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS));
		         Toolkit kit = Toolkit.getDefaultToolkit();
		            Dimension screenSize = kit.getScreenSize();//获取屏幕分辨率
		          setLocation(screenSize.width/4,screenSize.height/4);//位置
		          //给参数设置字体
		          state.setFont(f1);
		          HOST.setFont(f1);
		          PORT.setFont(f1);
		          btn1.setFont(f1);
		          reset.setFont(f1);
		          STATE.setFont(f1);
		          //在容器中添加控件
		         center.add(hBox0);
		         center.add(Box.createRigidArea(new Dimension(10,20)));
		         center.add(hBox1);
		         center.add(Box.createRigidArea(new Dimension(2,20)));
		         center.add(hBox2);
		         center.add(Box.createRigidArea(new Dimension(2,20)));
		         center.add(hBox3);
		         hBox0.add(HOST);
		         hBox0.add(host);
		         hBox1.add(PORT);
		         hBox1.add(port);
		         hBox2.add(btn1);
		         hBox2.add(reset);
		         hBox3.add(STATE);
		         hBox3.add(state);
		         //界面中添加主控件
		         add(center);
		         //添加动作监听事件
		         btn1.addActionListener(new MyActionListener());
		         reset.addActionListener(new MyActionListener());
		    }
		    class MyActionListener implements ActionListener{
		        public void actionPerformed(ActionEvent e) {
		            String post1=host.getText();
		            int port1=Integer.parseInt(port.getText());
		            if(e.getActionCommand()=="开始扫描"){
		            if(    PortScannerByIP.scan(post1, port1)){
		                state.setText("开放");
		            }else{
		                state.setText("关闭");
		            }    
		            }
		            if(e.getActionCommand()=="重置"){
		                host.setText("");
		                port.setText("");
		            }
		        }
		    }
		}
	  class PortScannerByIP {
		  			//创建端口扫描类，实现端口扫描功能
			 		//端口扫描IP地址（网址也就是IP地址）
			    public static boolean scan(String host,int port){
			    	//新建scan扫描方法，定义参数ip地址与端口号
			    	//方法调用
			        boolean flag=true;
			        Socket socket=null;
			        try {
			        	//将主机值与端口值放在socket中
			            socket=new Socket(host,port);
			            return flag;
			        } catch (IOException e) {
			            flag=false;
			            return flag;
			        }finally{
			            try {
			                if(socket!=null)
			                	//关闭数据端口测试
			                    socket.close();
			            } catch (IOException e) {
			                e.printStackTrace();
			            }
			        }
			    }
			}	
//	  
