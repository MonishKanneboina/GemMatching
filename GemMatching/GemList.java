import java.awt.Font;
import java.util.*;
public class GemList 
{
   public static void main(String [] args)
   {
      GemList list = new GemList();
      System.out.println(list);
      System.out.println("size = " + list.size() + ", score = " + list.score());
      list.draw(0.9);		
   		
      list.insertBefore(new Gem(GemType.BLUE, 10), 0);
      System.out.println("\n" + list);
      System.out.println("size = " + list.size() + ", score = " + list.score());
      list.draw(0.8);
   		
      list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
      System.out.println("\n" + list);
      System.out.println("size = " + list.size() + ", score = " + list.score());
      list.draw(0.7);
   		
      list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
      System.out.println("\n" + list);
      System.out.println("size = " + list.size() + ", score = " + list.score());
      list.draw(0.6);
   		
      list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
      System.out.println("\n" + list);
      System.out.println("size = " + list.size() + ", score = " + list.score());
      list.draw(0.5);
   		
      list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
      System.out.println("\n" + list);
      System.out.println("size = " + list.size() + ", score = " + list.score());
      list.draw(0.4);
   		
      list.insertBefore(new Gem(GemType.GREEN, 50), 2);
      System.out.println("\n" + list);
      System.out.println("size = " + list.size() + ", score = " + list.score());
      list.draw(0.3);		
   }	
   
   
   private int size;
   private Node head;
   private int score;
   
   
   private class Node
   {
      private Gem gem;
      private Node next;
      
      public Node (Gem gem)
      {
         this.gem = gem;
      }
   }
   
   public GemList()
   {
      head = null;
      size = 0;
      score = 0;
   }
   
   public int size()
   {
      return size;
   } 
   
   public void draw (double y)
   {
      Node current = head;
      
      if(current == null)
      {
         return;
      }
      
      int index = 0;
      
      while(current.next != null)
      {
         current.gem.draw(GemGame.indexToX(index),y);
         current = current.next;
         index++;
      }
      current.gem.draw(GemGame.indexToX(index),y);
   
   }
   
   
   
   @Override
   public String toString()
   {
      if(size == 0)
      {
         return "<none>";     
      }
         
      String s = ""; 
      Node current = head;
      s += current.gem.getType();
         
      while (current.next != null)
      {
         s += " -> ";
         String t = "" + current.next.gem.getType();
         s += t;
         current = current.next;
              
      }
      
      return s;
         
         
   }
   
   public void insertBefore(Gem gem, int index)
   {
      Node current = head;
      Node newGem = new Node(gem);
      
      if (size == 0)
         {
         head = newGem;
         size++;
         return;
         }
         
      if (index == 0)
      {        
         newGem.next = head;
         head = newGem;
         size++;
         return;
      }
      if (index >= size)
      {  
      
         while (current.next != null)
         {
            current = current.next;
         }
         current.next = newGem;
         size++;
         return;
      }
      
      while (current.next != null)
      {
         for (int i = 0; current.next != null && i < index - 1; i++)
         {
            current = current.next;
         }
            
         newGem.next = current.next;
         current.next = newGem;
         size++;
         break;
      }    
         
      if(index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
   }

      
   public int score()
   {
      score = 0;
      int subscore = 0;
      int multiplier = 1;
      int x = 0;
      
      Node current = head;
         
      if (size == 0)
         {
            return 0;
         }   
         
      
      if (size == 1)
         {
            subscore += current.gem.getPoints();
            return score += subscore * multiplier;
         }
                     
      while (current.next != null)
      { 
                
         if (current.gem.getType() == current.next.gem.getType())
         {
            while (current.next != null && current.gem.getType() == current.next.gem.getType())
            {
               x += current.gem.getPoints();
               multiplier++;
               current = current.next;
            }
            x += current.gem.getPoints();
            score += x * multiplier;
            x = 0;
            multiplier = 1;
            if (current.next == null)
               {
                  return score; 
               }
           else 
               {
                  current = current.next;
               } 
         }
         else
         {
            subscore += current.gem.getPoints();
            current = current.next;
         }
      }
      subscore += current.gem.getPoints();
      score += subscore;
      return score;
   }    
}
              
