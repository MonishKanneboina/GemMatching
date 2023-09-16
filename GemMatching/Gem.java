import java.awt.Font;
import java.util.*;

enum GemType {
   GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited
}

public class Gem 
{
	/** Tester main method */
   public static void main(String [] args)
   {
   		final int maxGems = 16;
   		
   		 //Create a gem of each type
   		Gem green  = new Gem(GemType.GREEN, 10);
   		Gem blue   = new Gem(GemType.BLUE, 20);
   		Gem orange = new Gem(GemType.ORANGE, 30);
   		System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());		
   		System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
   		System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
   		green.draw(0.3, 0.7);
   		blue.draw(0.5, 0.7);
   		orange.draw(0.7, 0.7);
   		
   		// A row of random gems
   		for (int i = 0; i < maxGems; i++)
   		{
   			Gem g = new Gem();
   			g.draw(1.0 / maxGems * (i + 0.5), 0.5);
    		}
   }
   
   private GemType type;
   private int points;
   
   public Gem()
   {
      Random random = new Random();
      int color = random.nextInt(3);
      int value = random.nextInt(11);
         
      if (color == 0)
      {
         this.type = GemType.GREEN;         
      }
      else if (color == 1)
      {
         this.type = GemType.BLUE;   
      }
      else
      {
         this.type = GemType.ORANGE;   
      }
      
      points = value * 5;
   }
   
   public Gem(GemType type, int points)
      {
         this.type = type;
         this.points = points;
      }
      
    @Override  
    public String toString()
      {
         return type + " "  + points;
      }
      
   public GemType getType()
      {
         return type;
      }
      
   public int getPoints()
      {
         return points;
      }
      
    public void draw(double x, double y)
      {
         if (type == GemType.GREEN)
            {
               StdDraw.picture(x,y, "gem_green.png");
            }
         else if (type == GemType.BLUE)
            {
               StdDraw.picture(x,y, "gem_blue.png");
            }
         else 
            {
               StdDraw.picture(x,y, "gem_orange.png");
            }
         StdDraw.setFont(new Font("SansSerif", Font.BOLD, 15));
         
         StdDraw.text(x,y, points + "");
      }
}
