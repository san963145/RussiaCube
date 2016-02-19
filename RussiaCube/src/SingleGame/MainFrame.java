package SingleGame;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	public static MainFrame frame=null;
	private  MyPanel panel=new MyPanel();
	private ImageIcon imageIcon = new ImageIcon("res/1.png");
	private Image image=imageIcon.getImage();
	private ImageIcon imageIcon0 = new ImageIcon("res/b.png");
	private Image image0=imageIcon0.getImage();
	private ImageIcon imageIcon1 = new ImageIcon("res/player1.png");
	private Image image1=imageIcon1.getImage();
	private ImageIcon imageIcon2 = new ImageIcon("res/player2.png");
	private Image image2=imageIcon2.getImage();
	private Image buffer;
	public static void main(String []args)
	{
		frame = new MainFrame();
		/*
	    frame.setTitle("RussiaCube");
	    frame.setLocation(200, 100); // Center the frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(800, 600);
	    frame.setVisible(true);
	    ProcThread t=new ProcThread();
	    t.start();
	    frame.addKeyListener(new MyKeyAdapter());
	    */
	}
	public MainFrame()
	{
		init();
		panel.setLayout(null);
		panel.setBounds(0,0,800,600);
		this.setLayout(null);
		this.add(panel);
		Data.init();
		buffer=this.createImage(this.getSize().width,this.getSize().height);			
		setTitle("RussiaCube");
	    setLocation(200, 100); // Center the frame
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(800, 600);
	    setVisible(true);
	    ProcThread t=new ProcThread();
	    t.start();
	    addKeyListener(new MyKeyAdapter());
	}
	private void init()
	{
		panel.setLayout(null);
		panel.setBounds(0,0,800,600);
		this.setLayout(null);
		this.add(panel);
		Data.init();
		buffer=this.createImage(this.getSize().width,this.getSize().height);
	}
	public void refresh()
	{
		panel.repaint();
	}
	class MyPanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Override
		public void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			int i,j;
			int x,y;
			buffer=this.createImage(this.getSize().width,this.getSize().height);
			Graphics gbuffer=buffer.getGraphics();		
			gbuffer.drawImage(image0,0,0,null);
			gbuffer.drawImage(image1,50,120,null);
			gbuffer.drawImage(image2,450,120,null);
			for(i=0;i<11;i++)
				for(j=3;j<24;j++)
				{
					x=187+i*16;
					y=131+(j-3)*16;
					switch(Data.AllPoint_Player1[i][j])
					{
					case(0):break;
					case(1):gbuffer.drawImage(image,x,y,x+16,y+16,0,0,14,14,null);break;
					case(2):gbuffer.drawImage(image,x,y,x+16,y+16,14,0,27,14,null);break;
					case(3):gbuffer.drawImage(image,x,y,x+16,y+16,0,14,14,27,null);break;
					case(4):gbuffer.drawImage(image,x,y,x+16,y+16,14,14,27,27,null);break;
					}
				}
			if(Data.initflag)
			{
				if(Data.draw_module)
				for(i=0;i<4;i++)
				{   
					Point p=Data.Module_Player1.getP()[i];
					x=p.getX();
					y=p.getY();
					if(y>2)
					{
					 x=187+x*16;
					 y=131+(y-3)*16;
					 switch(p.getColortype())
					 {
					 case(0):break;
					 case(1):gbuffer.drawImage(image,x,y,x+16,y+16,0,0,14,14,null);break;
					 case(2):gbuffer.drawImage(image,x,y,x+16,y+16,14,0,27,14,null);break;
					 case(3):gbuffer.drawImage(image,x,y,x+16,y+16,0,14,14,27,null);break;
					 case(4):gbuffer.drawImage(image,x,y,x+16,y+16,14,14,27,27,null);break;
					 }
					}
				}
				for(i=0;i<4;i++)
				{
					Point p=Data.Next_Player1.getP()[i];
					x=p.getX();
					y=p.getY();
					x=39+x*14;
					y=160+(y-1)*14;
					switch(p.getColortype())
					{
					case(0):break;
					case(1):gbuffer.drawImage(image,x,y,x+14,y+14,0,0,14,14,null);break;
					case(2):gbuffer.drawImage(image,x,y,x+14,y+14,14,0,27,14,null);break;
					case(3):gbuffer.drawImage(image,x,y,x+14,y+14,0,14,14,27,null);break;
					case(4):gbuffer.drawImage(image,x,y,x+14,y+14,14,14,27,27,null);break;
					}
				}
				
			}	
			Font font = new Font("SansSerif", Font.BOLD,20);
			gbuffer.setFont(font);
			gbuffer.setColor(new Color(255, 0, 0));
			gbuffer.drawString(Integer.toString(Data.Score_Player1),130,410);
			gbuffer.drawString("NO PLAYER",488,300);
			if(Data.Lose_Player1)
			{
				Font font2 = new Font("SansSerif", Font.BOLD,20);
				gbuffer.setFont(font2);
				gbuffer.setColor(new Color(255, 0, 0));
				gbuffer.drawString("GAME OVER",212,300);
			}
			g.drawImage(buffer,0,0,this);
		}
	}
	

}
