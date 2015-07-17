package SingleGame;

class Proc{   //检测、消格、加分等处理

    public static void check()
    {
    	int i,j,k;
    	boolean flag=false;
    	boolean test=true;
    	for(j=0;j<24;j++)
    	{
    		test=true;
    		for(i=0;i<11;i++)
    			if(Data.AllPoint_Player1[i][j]==0)
    			{
    				test=false;
    				i=12;
    			}
    		if(test)
    		{
    			flag=true;
    			Data.Score_Player1+=1;
    			for(k=j;k>0;k--)
    			{
    				for(i=0;i<11;i++)
    					Data.AllPoint_Player1[i][k]=Data.AllPoint_Player1[i][k-1];
    			}   
    			for(i=0;i<11;i++)
    				Data.AllPoint_Player1[i][0]=0;
    		}
    	}
		if(flag)
			MainFrame.frame.refresh();
    }
    public static boolean islose()
    {
    	boolean flag=false;
    	int i;
    	for(i=0;i<11;i++)
    	{
    		if(Data.AllPoint_Player1[i][3]>0)
    		{
    			flag=true;
    			break;
    		}
    	}
    	return flag;
    }

}
public class ProcThread extends Thread{           //生产模块、移动模块
    int x=0;
    int type;
    int state1,state2;
    int colortype;
    Point []point=new Point[4];
    boolean stop=false;
    int k=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(stop==false)
		{
			if(Proc.islose())
		    {
			   stop=true;
			   Data.Lose_Player1=true;
		    }
			else
			if(x==0)
			{
				x=1;
				Data.draw_module=true;
				if(Data.initflag)Data.Module_Player1.set(Data.Next_Player1.getType(),
						Data.Next_Player1.getState(),Data.Next_Player1.getP()[0].getColortype());
				else{}
				type=(int)(Math.random()*100)%5+1;
				state1=(int)(Math.random()*100)%4+1;
				state2=(int)(Math.random()*100)%2+1;
				colortype=(int)(Math.random()*100)%4+1;
				if(type<4)
					Data.Next_Player1.set(type,state2,colortype);
				else
					Data.Next_Player1.set(type,state1,colortype);
				if(!Data.initflag)
				Data.Module_Player1.set(Data.Next_Player1.getType(),
						Data.Next_Player1.getState(),Data.Next_Player1.getP()[0].getColortype());
				else{}
			}
			else
			{
				if(!Data.initflag)
				{
					x=0;
					Data.initflag=true;
					Data.draw_module=true;
				}
				else
				{
				 if(Data.Module_Player1.check(true))
				 {
					x=0;
					Data.draw_module=false;
					Proc.check();
				 }
				 else
				 {
				  Data.Module_Player1.fall();	
				  Data.draw_module=true;
				 }
				}
			}
			try {
				if(k==1)
				Thread.sleep(400);
				else
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(k==1)
			MainFrame.frame.refresh();
			else k=1;
		}
	}	
}
