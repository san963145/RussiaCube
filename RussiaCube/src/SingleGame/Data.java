package SingleGame;


public class Data {
       public static int AllPoint_Player1[][];
       public static int AllPoint_Player2[][];
       public static int Score_Player1=0;
       public static int Score_Player2=0;
       public static Module Next_Player1;
       public static Module Next_Player2;
       public static Module Module_Player1;
       public static Module Module_Player2;
       public static boolean Lose_Player1=false;
       public static boolean Lose_Player2=false;
       public static boolean draw_module=true;
   	   public static boolean initflag=false;
       public static void init()
       {
    	   int i,j;
    	   Next_Player1=new Module();
    	   Next_Player2=new Module();
    	   Module_Player1=new Module();
    	   Module_Player2=new Module();
    	   AllPoint_Player1=new int[11][];
    	   AllPoint_Player2=new int[11][];
    	   for(i=0;i<11;i++)
    	   {
    		   AllPoint_Player1[i]=new int[24];
    		   AllPoint_Player2[i]=new int[24];
    	   }
    	   for(i=0;i<11;i++)
    		   for(j=0;j<21;j++)
    		   {
    			   AllPoint_Player1[i][j]=0; 
    			   AllPoint_Player2[i][j]=0;
    		   }
       }
}
