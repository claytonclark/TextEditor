// Clayton Clark
// CS1400, section 03
// Project 8 – Text Editor
// 4/23/2020

import java.io.*;
import java.util.Scanner;

public class TextEditorTest
{
   public static void main(String[] args) throws IOException
   {
      boolean run = true;
      Scanner input = new Scanner(System.in);
      String choice;
      if(!(new File(args[0]).exists()))
      {
         System.out.print("input file does not exist!\n");
         System.exit(0);
      }
      TextEditor file = new TextEditor(new File(args[0]));
      while(run)
      {
         System.out.println("\n[p]rint input file with line numbers");
         System.out.println("[f]ind the leftmost occurrences of pattern for all lines");
         System.out.println("[r]eplace all occurrence of old by new");
         System.out.println("[s]ort the input file");
         System.out.println("[q]uit the editor");
         System.out.print("Your choice: ");
         choice = input.nextLine();
         switch(choice)
         {
            case "p":
               file.print();
               break;
            case "f":
               file.find();
               break;
            case "r":
               file.replace();
               break;
            case "s":
               file.sort();
               break;
            case "q":
               System.out.print("bye\n");
               run = false;
               break;
            default:
               System.out.println("invalid choice!");
         }
      }
   }
}
