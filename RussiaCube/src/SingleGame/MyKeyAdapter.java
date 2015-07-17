package SingleGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


class MyKeyAdapter extends KeyAdapter{
     public static int w=0,a=0,s=0,d=0;
     private static int speed=0;
     KeyThread t=new KeyThread();
     public MyKeyAdapter()
     {
    	 t.start();
     }
	 public void keyPressed(KeyEvent e) {
         switch (e.getKeyCode()) {		         
           case KeyEvent.VK_UP:   w=1;break;
           case KeyEvent.VK_LEFT: a=1;break;
           case KeyEvent.VK_DOWN: s=1;break;
           case KeyEvent.VK_RIGHT:d=1;break;
           default: break;
         } 			 
	 }
	 public void keyReleased(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:   w=0;speed=0;break;
			case KeyEvent.VK_LEFT: a=0;speed=0;break;
			case KeyEvent.VK_DOWN: s=0;speed=0;break;
			case KeyEvent.VK_RIGHT:d=0;speed=0;break;
			default:break;
			}
		  }
	
	class KeyThread extends Thread{
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true)
				{
					if(w==1)
					{
						Data.Module_Player1.changestate();
						MainFrame.frame.refresh();
						try {
							Thread.sleep(140);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if(a==1)
					{
					   Data.Module_Player1.mov(2);	
					   if(speed<100)
					   {
					    speed+=20;
					    try {
							Thread.sleep(111-speed);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					   }
					}
					else if(s==1)
					{
					   Data.Module_Player1.mov(3);
					   if(speed<20)
					   {
					    speed+=10;
					    try {
							Thread.sleep(21-speed);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					   }
					}
					else if(d==1)
					{
					   Data.Module_Player1.mov(4);
					   if(speed<100)
					   {
					    speed+=20;
					    try {
							Thread.sleep(111-speed);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					   }
					}
					try {
						Thread.sleep(15);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
}

