package lexicalanalysis;
import java.util.List;
import java.io.*;
import java.util.*;

import lexicalanalysis.token;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
 /*
  * this class is used to excecute the lex method reading the file 
*/
public class basic 
{
	public static void main(String [] args) throws IOException
	{
		if(args.length>1)//if arguments are more than 1 this will terminate the method
		{
			System.out.println("too many arguments .. please enter the filename as argument ! *program ends*");
		    System.exit(0);//exits the program
		}
		else if(args.length == 1)//if and only if the arguments are equal to 1
		{
		List<token> check = new ArrayList<token>();//creating a list to fill token and print it
		
			System.out.println("argument is accepted ! ......searching through file");
			
			System.out.println();
			String dir = args[0];
			Path path = Paths.get(dir);//path of the file is taken and file is loaded
			try 
			{
			List<String> lines = Files.readAllLines(path);//reads the fine and fills the lines with each line thats read
			
			for(String lines1:lines)
			{
				lexer linelex = new lexer();//lexer object is created
				check =  linelex.lex(lines1);//lex method is called to lexically go through the lines that are read.
				
				for(token t : check) 
				{
		            System.out.print(t +" ");//this will print the tokens list
		        }
				System.out.println("");
			}}catch(Exception e)
			{
				e.printStackTrace();
			}
			//try and catch are used to excute the lex method and find that there is no exception or a error is thrown.
		}
			
			
		}}
	


