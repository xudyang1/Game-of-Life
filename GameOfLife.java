
public class GameOfLife
{
   private int[][] system;
   public GameOfLife()
   {
      system= new int[10][10];
   }
   public GameOfLife(int row, int column)
      throws IllegalArgumentException
   {
      if(row>0&&column>0)
      {
         system=new int[row][column];
      }
      else
         throw new IllegalArgumentException();
   }
   public int[][] getSystem()
   {
      return system;
   }
   public void setAlivedCell(int[][] input)
      throws IllegalArgumentException
   {
      for(int i=0; i<input.length;i++)
      {
         if(input[i][0]>=0&&input[i][0]<system.length&&input[i][1]>=0&&input[i][1]<system[i].length)
            system[input[i][0]][input[i][1]]=1;
         else
            throw new IllegalArgumentException();
      }
   }
   public int getNei(int row,int column)
   {
      int answer=0;
      for(int i=-1;i<2;i++)
      {
         for(int j=-1; j<2; j++)
         {
            if(!(i==0&&j==0)&&(system[Math.floorMod(row+i,system.length)][Math.floorMod(column+j,system[row].length)]==1))
               answer++;
         }
      }
      return answer;
   }
   public void check()
   {
      int[][] temp=new int[system.length][system[0].length];
      for(int i=0;i<system.length;i++)
      {
         for(int j=0;j<system[i].length;j++)
         {
            temp[i][j]=system[i][j];
         }
      }
      for(int i=0;i<system.length;i++)
      {
         for(int j=0;j<system[i].length;j++)
         {
            if(getNei(i,j)<2)
               temp[i][j]=0;
            else if(getNei(i,j)==3)
               temp[i][j]=1;
            else if(getNei(i,j)>3)
               temp[i][j]=0;
            else
               continue;
         }
      }
      system=temp;
   }
   public void printTable()
   {
      System.out.println("===============================================");
      for(int i=0; i<system.length;i++)
      {
         String s="";
         for(int j=0;j<system[i].length;j++)
         {
            if(system[i][j]==0)
               s+="|   ";
            else
               s+="| "+'O'+" "; 
         }
         s+="|";
         System.out.println(s);
         System.out.println("===============================================");
      }
   }
   public void reset()
   {
      for(int i=0; i<system.length;i++)
      {
         for(int j=0;j<system[i].length;j++)
         {
            system[i][j]=0;
         }
      }
   }
   public static void main(String[] args)
   {
      try
      {
         GameOfLife g=new GameOfLife();
         g.printTable();
         int[][] input={{5,5},{6,6},{7,6},{7,5},{7,4}};
         g.setAlivedCell(input);
         for(int i=0;i<10;i++)
         {
            g.printTable();
            g.check();
            System.out.println("\n");
         }
      }
      catch(IllegalArgumentException ex)
      {
      
      }
      catch(Exception ex)
      {
      
      }
   }
}