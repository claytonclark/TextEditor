// Clayton Clark
// CS1400, section 03
// Project 8 – Text Editor
// 4/23/2020

import java.util.Scanner;
import java.io.*;

public class TextEditor
{
   public static final int MAX = 200;
   private String[] lines;
   private int size;

   public TextEditor(File myFile) throws IOException
   {
      Scanner inputFile = new Scanner(myFile);
      lines = new String[MAX];
      size = 0;
      while(inputFile.hasNext())
      {
         lines[size] = inputFile.nextLine();
         size++;
      }  
   }
   public void print()
   {
      for(int i = 0; i < size; i++)
         System.out.printf("%-3d: %s\n", i, lines[i] );
      if(size == 0)
         System.out.println("empty file");
   }
   public void find()
   {
      Scanner input = new Scanner(System.in);
      String str;
      boolean found = false; //flag to check if str is found at least once
      System.out.print("enter pattern: ");
      str = input.nextLine();
      if(size == 0)
         System.out.println("empty file");

      else if(str.length() == 0)
         System.out.println("illegal pattern: length must be at least one");
      else
      {
         for(int i = 0; i < size; i++)
         {
            int index = lines[i].indexOf(str);
            if(index == -1)
               continue;
            found = true;
            System.out.printf("%-3d: %s\n", i, lines[i] );
            System.out.println("position = " + index);
         }
         if(!found)
            System.out.println("pattern not found");
      }
   }
   public void replace()
   {
      Scanner input = new Scanner(System.in);
      String oldPat,newPat;
      int index;
      boolean found = false; //flag to check if oldPat is found at least once
      System.out.print("enter old pattern: ");
      oldPat = input.nextLine();
      if(oldPat.length() == 0)
         System.out.println("illegal pattern: length must be at least one");
      else
      {
         System.out.print("enter new pattern: ");
         newPat = input.nextLine();
         if(newPat.length() == 0)
            System.out.println("illegal pattern: length must be at least one");
         else if(size == 0)
            System.out.println("empty file");
         else
         {
            for(int i = 0; i < size; i++)
            {
               while(true)
               {
                  index = lines[i].indexOf(oldPat, 0);
                  if(index == -1)
                     break;
                  found = true;
                  String temp1 = lines[i].substring(0, index);
                  String temp2 = lines[i].substring(index + oldPat.length());
                  lines[i] = temp1+newPat+temp2;
               }
            }
            if(!found)
               System.out.println("pattern not found");
            else
               System.out.println("done!");
         }
      }
   }
   public void sort()
   {
      if(size == 0)
         System.out.println("empty file");
      else
      {
         for(int i = 0; i < size; i++)
         {
            for(int j = i + 1; j < size; j++)
            {
               int n = lines[i].compareTo(lines[j]);
               if(n > 0)
               {
                  String temp = lines[i];
                  lines[i] = lines[j];
                  lines[j] = temp;
               }
            }
         }
         System.out.println("sorted!");
      }
   }
}
