package SingleGame;

public class Module {
	   int type;                //1 l  2  Ìï     3 Z   4 L   5 T
       int state;               //·½Ïò
       Point p[]=new Point[4];
       public Module()
       {
    	   for(int i=0;i<4;i++)
    		   p[i]=new Point();
       }

       public void set(int Type,int State,int Colortype)
       {
    	   type=Type;
    	   state=State;
    	   for(int i=0;i<4;i++)
    		   p[i].setColortype(Colortype);
    	   switch(type)
    	   {
    	   case(1):
    		   if(state==2)
    			   {p[0].set(5,0);p[1].set(5,1);p[2].set(5,2);p[3].set(5,3);}
    		   else
    		       {p[0].set(3,3);p[1].set(4,3);p[2].set(5,3);p[3].set(6,3);}
    	       break;
    	   case(2):
    		   p[0].set(4,2);p[1].set(5,2);p[2].set(4,3);p[3].set(5,3);
    		   break;
    	   case(3):
    		   if(state==1)
			   {p[0].set(4,2);p[1].set(5,2);p[2].set(5,3);p[3].set(6,3);}
		       else
		       {p[0].set(5,1);p[1].set(5,2);p[2].set(4,2);p[3].set(4,3);}
	           break;
    	   case(4):
    		   switch(state)
    		   {
    		   case(1):
    			   p[0].set(6,2);p[1].set(6,3);p[2].set(5,3);p[3].set(4,3);
    			   break;
    		   case(2):
    			   p[0].set(4,1);p[1].set(5,1);p[2].set(5,2);p[3].set(5,3);
    			   break;
    		   case(3):
    			   p[0].set(4,2);p[1].set(4,1);p[2].set(5,1);p[3].set(6,1);
    			   break;
    		   case(4):
    			   p[0].set(5,3);p[1].set(4,3);p[2].set(4,2);p[3].set(4,1);
    			   break;
    		   }
    	       break;
    	   case(5):
    		   switch(state)
    		   {
    		   case(1):
    			   p[0].set(5,2);p[1].set(4,3);p[2].set(5,3);p[3].set(6,3);
    			   break;
    		   case(2):
    			   p[0].set(4,2);p[1].set(5,3);p[2].set(5,2);p[3].set(5,1);
    			   break;
    		   case(3):
    			   p[0].set(5,3);p[1].set(6,2);p[2].set(5,2);p[3].set(4,2);
    			   break;
    		   case(4):
    			   p[0].set(5,2);p[1].set(4,1);p[2].set(4,2);p[3].set(4,3);
    			   break;
    		   }
    	       break;
    	   }
    	   
       }
       public void fall()
       {
    	   int i;
    	   for(i=0;i<4;i++)
    	   {
    		   p[i].set(p[i].getX(),p[i].getY()+1);
    	   }
       }
       public void mov(int d)
       {
    	   int i;
    	   switch(d)
    	   {
    	   case(2):
    		   if(!testleft())
    		   for(i=0;i<4;i++)
    		   {
    			   p[i].set(p[i].getX()-1,p[i].getY());
    		   }
    	       break;
    	   case(3):
    		   if(!check(false))
    		   for(i=0;i<4;i++)
    		   {
    			   p[i].set(p[i].getX(),p[i].getY()+1);
    		   }
    	       break;
    	   case(4):    		   
    		   if(!testright())
    		   for(i=0;i<4;i++)
    		   {
    			   p[i].set(p[i].getX()+1,p[i].getY());
    		   }
    	       break;
    	   }
    	   MainFrame.frame.refresh();
       }
       public void changestate()
       {
    	   switch(type)
    	   {
    	   case(1):                  //  1 l
    		   if(state==1)
    		   {
    			   if(!check(false))
    			   {
    			    state=2;
    			    if(p[0].getY()<3)
    			    {
    			     p[0].set(p[0].getX()+2,p[0].getY());
       			     p[1].set(p[1].getX()+1,p[1].getY()+1);
       			     p[2].set(p[2].getX(),p[2].getY()+2);
       			     p[3].set(p[3].getX()-1,p[3].getY()+3);	
    			    }
    			    else
    			    {
    			     p[0].set(p[0].getX()+2,p[0].getY()-2);
    			     p[1].set(p[1].getX()+1,p[1].getY()-1);
    			     p[3].set(p[3].getX()-1,p[3].getY()+1);
    			    }
    			   }
    			   else{}
    		   }
    		   else
    		   {
    			   if(!check(false))
    			   {
    			    state=1;
    			    if(testleft())
    			    {
    			     if((!testright())&&(p[0].getX()!=9))
    			     {
    			      p[0].set(p[0].getX(),p[0].getY()+2);
          			  p[1].set(p[1].getX()+1,p[1].getY()+1);
          			  p[2].set(p[2].getX()+2,p[2].getY());
          			  p[3].set(p[3].getX()+3,p[3].getY()-1);
    			     }
    			     else{}
    			    }
    			    else if(p[0].getX()==1)
    			    {
    			    	 if((!testright())&&(p[0].getX()!=9))
    			    	 {
    			    	 p[0].set(p[0].getX()-1,p[0].getY()+2);
             			 p[1].set(p[1].getX(),p[1].getY()+1);
             			 p[2].set(p[2].getX()+1,p[2].getY());
             			 p[3].set(p[3].getX()+2,p[3].getY()-1);
    			    	 }
    			    	 else{}
    			    }
    			    else if(p[0].getX()==9)
    			    {
    			         p[0].set(p[0].getX()-2,p[0].getY()+2);
             			 p[1].set(p[1].getX()-1,p[1].getY()+1);
             			 p[2].set(p[2].getX(),p[2].getY());
             			 p[3].set(p[3].getX()+1,p[3].getY()-1);	
    			    }
    			    else if(testright())
    			    {
    			     p[0].set(p[0].getX()-3,p[0].getY()+2);
          			 p[1].set(p[1].getX()-2,p[1].getY()+1);
          			 p[2].set(p[2].getX()-1,p[2].getY());
          			 p[3].set(p[3].getX(),p[3].getY()-1);	
    			    }
    			    else
    			    {
    			     p[0].set(p[0].getX()-2,p[0].getY()+2);
       			     p[1].set(p[1].getX()-1,p[1].getY()+1);
       			     p[3].set(p[3].getX()+1,p[3].getY()-1);	
    			    }
    			   }
    			   else{}
    		   }
    	       break;
    	   case(2):break;             
    	   case(3):                 // 3 Z
    		    if(state==1)
    		    {
    		    	if(!check(false))
    		    	{
    		    	 state=2;
    		    	 p[0].set(p[0].getX()+1,p[0].getY()-1);
       			     p[2].set(p[1].getX()-1,p[1].getY());
       			     p[3].set(p[3].getX()-2,p[3].getY());
    		    	}
    		    	else{}
    		    }
    		    else
    		    {
    		    	if(!check(false))
    		    	{
    		    	 state=1;
    		    	 if(testright())
    		    	 {
    		    	  p[0].set(p[0].getX()-2,p[0].getY()+1);
       			      p[1].set(p[1].getX()-1,p[1].getY());
       			      p[2].set(p[2].getX(),p[2].getY()+1);
       			      p[3].set(p[3].getX()+1,p[3].getY());
    		    	 }
    		    	 else
    		    	 {
    		    	  p[0].set(p[0].getX()-1,p[0].getY()+1);
          			  p[2].set(p[1].getX(),p[1].getY()+1);
          			  p[3].set(p[3].getX()+2,p[3].getY()); 
    		    	 }
    		    	}
    		    	else{}
    		    }
    	        break;
    	   case(4):                        // 4 L
    		   if(!check(false))
    		   switch(state)
    		   {
    		   case(1):
    			   state=2;
    		       p[0].set(p[0].getX()-1,p[0].getY());
			       p[1].set(p[1].getX(),p[1].getY()-1);
			       p[2].set(p[2].getX()+1,p[2].getY());
			       p[3].set(p[3].getX()+2,p[3].getY()+1);
			       break;
    		   case(2):
    			   state=3;
    		       if(testright())
    		       {
    		    	   p[0].set(p[0].getX()-1,p[0].getY()+2);
    			       p[1].set(p[1].getX()-2,p[1].getY()+1);
    			       p[2].set(p[2].getX()-1,p[2].getY());
    			       p[3].set(p[3].getX(),p[3].getY()-1); 
    		       }
    		       else
    		       {
    		    	   p[0].set(p[0].getX(),p[0].getY()+2);
    			       p[1].set(p[1].getX()-1,p[1].getY()+1);
    			       p[2].set(p[2].getX(),p[2].getY());
    			       p[3].set(p[3].getX()+1,p[3].getY()-1);
    		       }
    		       break;
    		   case(3):
    			   state=4;
    			   p[0].set(p[0].getX()+1,p[0].getY());
		           p[1].set(p[1].getX(),p[1].getY()+1);
		           p[2].set(p[2].getX()-1,p[2].getY());
		           p[3].set(p[3].getX()-2,p[3].getY()-1);
		           break;
    		   case(4):
    			   state=1;
    		       if(testleft())
    		       {
    		    	   p[0].set(p[0].getX()+1,p[0].getY()-2);
    		           p[1].set(p[1].getX()+2,p[1].getY()-1);
    		           p[2].set(p[2].getX()+1,p[2].getY());
    		           p[3].set(p[3].getX(),p[3].getY()+1); 
    		       }
    		       else
    		       {
    		    	   p[0].set(p[0].getX(),p[0].getY()-2);
    		           p[1].set(p[1].getX()+1,p[1].getY()-1);
    		           p[2].set(p[2].getX(),p[2].getY());
    		           p[3].set(p[3].getX()-1,p[3].getY()+1);
    		       }
    		       break;
    		   }
    		   else{}
    	       break;
    	   case(5):                 // 5  T
    		   if(!check(false))
    		   {
    			   switch(state)
    			   {
    			   case(1):
    				   state=2;
    			       p[0].set(p[0].getX()-1,p[0].getY()+1);
		               p[1].set(p[1].getX()+1,p[1].getY()+1);
		               p[2].set(p[2].getX(),p[2].getY());
		               p[3].set(p[3].getX()-1,p[3].getY()-1);
		               break;
    			   case(2):
    				   state=3;
    			       if(testright())
    			       {
    			    	   p[0].set(p[0].getX(),p[0].getY()+1);
        		           p[1].set(p[1].getX(),p[1].getY()-1);
        		           p[2].set(p[2].getX()-1,p[2].getY());
        		           p[3].set(p[3].getX()-2,p[3].getY()+1);
    			       }
    			       else
    			       {
    			    	   p[0].set(p[0].getX()+1,p[0].getY()+1);
        		           p[1].set(p[1].getX()+1,p[1].getY()-1);
        		           p[2].set(p[2].getX(),p[2].getY());
        		           p[3].set(p[3].getX()-1,p[3].getY()+1);
    			       }
    			       break;
    			   case(3):
    				   state=4;
			           p[0].set(p[0].getX()+1,p[0].getY()-1);
	                   p[1].set(p[1].getX()-1,p[1].getY()-1);
	                   p[2].set(p[2].getX(),p[2].getY());
	                   p[3].set(p[3].getX()+1,p[3].getY()+1);
	                   break;
    			   case(4):
    				   state=1;
			           if(testleft())
			           {
			        	p[0].set(p[0].getX(),p[0].getY()-1);
	    		        p[1].set(p[1].getX(),p[1].getY()+1);
	    		        p[2].set(p[2].getX()+1,p[2].getY());
	    		        p[3].set(p[3].getX()+2,p[3].getY()-1);
			           }
			           else
			           {
			    	    p[0].set(p[0].getX()-1,p[0].getY()-1);
    		            p[1].set(p[1].getX()-1,p[1].getY()+1);
    		            p[2].set(p[2].getX(),p[2].getY());
    		            p[3].set(p[3].getX()+1,p[3].getY()-1);
			           }
			           break;
    			   }
    		   }
    		   else{}
    	       break;
    	   }
       }
       boolean testleft()
       {
    	   boolean flag=false;
    	   int i;
    	   int x,y;
    	   for(i=0;i<4;i++)
    	   {
    		   x=p[i].getX();
    		   y=p[i].getY();
    		   if(p[i].getX()<=0||Data.AllPoint_Player1[x-1][y]>0)
    		   {
    			   flag=true;
    			   break;
    		   }
    	   }
    	   return flag;
       }
       boolean testright()
       {
    	   boolean flag=false;
    	   int i;
    	   int x,y;
    	   for(i=0;i<4;i++)
    	   {
    		   x=p[i].getX();
    		   y=p[i].getY();
    		   if(p[i].getX()>=10||Data.AllPoint_Player1[x+1][y]>0)
    		   {
    			   flag=true;
    			   break;
    		   }
    	   }
    	   return flag;
       }
       public boolean check(boolean b)
       {
    	   boolean flag=false;
    	   int i,j;
    	   int x,y;
    	   for(i=0;i<4;i++)
    	   {
    		   x=p[i].getX();
    		   y=p[i].getY();
    		   if(y+1>=24||Data.AllPoint_Player1[x][y+1]>0)
    		   {
    			   flag=true;
    			   if(b)
    			   for(j=0;j<4;j++)
    			   {
    				   x=p[j].getX();
    				   y=p[j].getY();
    				   Data.AllPoint_Player1[x][y]=p[0].getColortype();
    			   }
    			   else{}    			   
    			   i=5;
    		   }
    	   }
    	   return flag;
       }

       public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Point[] getP() {
		return p;
	}
	public void setP(Point[] p) {
		this.p = p;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
       
}
class Point
{
	int colortype;
	int x,y;
	public int getColortype() {
		return colortype;
	}
	public void setColortype(int colortype) {
		this.colortype = colortype;
	}
	public int getX() {
		return x;
	}
	public void set(int x,int y) {
		this.x = x;
		this.y = y;
	}
	public int getY() {
		return y;
	}	   	   
}