package lexicalanalysis;

import java.util.List;
import java.util.*;



import lexicalanalysis.token.TokenType;
/*
 * this is lexer class that have lex method that is used to seperate tokens and analyse them
 */
public class lexer 
{

	public static List<token> lex(String input)
	{
		List<token> result = new ArrayList<token>();
	
		String[] str = new String[100];
		
		HashMap<String, TokenType> knownwords = new HashMap<String ,TokenType>();
		   knownwords.put("print" , TokenType.print);

		
		// this is used to alter input so that any way of entering the expression dosent alter the desired input
		
		if(input.contains("-"))
		{
			input = input.replaceAll("\\-", " -"); //adds extra space for identification of the lexer
		 
		}
		if(input.contains("+"))
		{
			input = input.replaceAll("\\+", " + ");//adds extra space for identification of the lexer
		 
		}
		if(input.contains("*"))
		{
			input = input.replaceAll("\\*", " * ");//adds extra space for identification of the lexer
		 
		}
		if(input.contains("/"))
		{
			input = input.replaceAll("\\/", " / ");//adds extra space for identification of the lexer
		 
		}
		if(input.contains(""))
			if(input.contains("="))
			{
				input = input.replaceAll("\\=", "= ");//adds extra space for identification of the lexer
			}	
			if(input.contains("<"))
			{
				input = input.replaceAll("\\<", " <");//adds extra space for identification of the lexer
			 
			}
			//if(input.contains(")"))
			//{
			//	input = input.replaceAll("\\)", " ) ");//adds extra space for identification of the lexer
			 
			//}
			
		   //we slit based of space if exists in the expression if that has
			if(input.contains(" ") && !(input.contains("\"")))
			{
				
			str = input.split(" ");
			}
			else if(input.contains(" ") && (input.contains("\"")))
			{
				
			str = input.split("\"");
			}
		
			
			//if it dosent have a space in between then we split on symbol and digit basis.
			else
			{	
			//	str = input.split("(?<=[- + * / %(),])(?=.)|(?<=.)(?=[- + * / %(),])");
				str = input.split("(?<=[\\d.])(?=[^\\d.])|(?<=[^\\d.])(?=[\\d.])|(?=[()])|(?<=[()])");
				//System.out.println(Arrays.toString(str));
			}


		
	   //we slit based of space if exists in the expression if that has
		
		//if it dosent have a space in between then we split on symbol and digit basis.
		//else
		//{	
		//	str = input.split("(?<=[- + * / %(),])(?=.)|(?<=.)(?=[- + * / %(),])");

		//}
		
		//System.out.println(Arrays.toString(str));
		//starting of state machine
		int state = 0;//initial value of state machine
		
		for(int i = 0 ; i < str.length; i++)
		{
			String s = str[i];//each index of the string is taken and used to compare its equivalency
			if(isNumeric(s))//checks if it is number 
			{
				state = 1;
			}
			
			if(s.equalsIgnoreCase("+"))//checks for + and sets appropriate value of state
			{
				state = 2;
			}
			if(s.equalsIgnoreCase("-"))//checks for - and sets appropriate value of state
			{
				
				state = 3;
			}
			if(s.equalsIgnoreCase("*"))//checks for * and sets appropriate value of state
			{
				state = 4;
			}
			if(s.equalsIgnoreCase("/"))//checks for / and sets appropriate value of state
			{
				state = 5;
			}
			if(s.equalsIgnoreCase(" ") || s.equalsIgnoreCase("\t") || s.isEmpty()) //checks for the space , tab or empty so that to address that case
			{
				state = 6;
			}
			if(s.equalsIgnoreCase("="))//checks for / and sets appropriate value of state
			{
				state = 7;
			}
			if(s.equalsIgnoreCase("<"))//checks for / and sets appropriate value of state
			{
				state = 8;
			}
			if(s.equalsIgnoreCase(">"))//checks for / and sets appropriate value of state
			{
				state = 9;
			}
			if(s.equalsIgnoreCase("<="))//checks for / and sets appropriate value of state
			{
				state = 10;
			}
			if(s.equalsIgnoreCase(">="))//checks for / and sets appropriate value of state
			{
				state = 11;
			}
			if(s.equalsIgnoreCase("<>"))//checks for / and sets appropriate value of state
			{
				state = 12;
			}
			if(s.equalsIgnoreCase("("))//checks for / and sets appropriate value of state
			{
				state = 13;
			}
			if(s.equalsIgnoreCase(")"))//checks for / and sets appropriate value of state
			{
				state = 14;
			}
			if(s.matches(".*[a-zA-Z]+.*") && (!(s.contains("print")) || !(s.contains("PRINT"))) && !(s.contains("\"")))
			{
				state = 15;
			}
			if(s.matches(".*[a-zA-Z]+.*") && ((s.contains("print")) || (s.contains("PRINT"))) && !(s.contains("\"")))
			{
				state = 16;
			}
			if(s.matches(".*[a-zA-Z]+.*") && s.contains(":"))
			{
				state = 17;
			}
			if(s.matches(".*[a-zA-Z]+.*") && s.contains(":"))
			{
				state = 17;
			}
		
			
			switch(state)
			{
			case 1: result.add(new token(TokenType.number , s));break;//adds number to the token list using enum reference
			case 2: result.add(new token(TokenType.plus, "+"));break;//adds plus to the token list using enum reference
			case 3 : result.add(new token(TokenType.minus, "-"));break;//adds minus to the token list using enum reference
			case 4 : result.add(new token(TokenType.times, "*"));break;//adds multiply to the token list using enum reference
			case 5 : result.add(new token(TokenType.divide, "/"));break;//adds divide to the token list using enum reference
			case 6 : break;
			case 7 : result.add(new token(TokenType.equal, "="));break;
			case 8 : result.add(new token(TokenType.lessthan, "<"));break;
			case 9 : result.add(new token(TokenType.greaterthan, ">"));break;
			case 10 :result.add(new token(TokenType.lessthan_equal, "<="));break;
			case 11 :result.add(new token(TokenType.greaterthan_equal, ">="));break;
			case 12 :result.add(new token(TokenType.notequal, "<>"));break;
			case 13 :result.add(new token(TokenType.lparen, "("));break;
			case 14 :result.add(new token(TokenType.rparen, ")"));break;
			case 15: result.add(new token(TokenType.identifier, s));break;
			case 16: result.add(new token(TokenType.print, s));break;
			case 17 : result.add(new token(TokenType.label,s));break;
			case 18 : result.add(new token(TokenType.string,s));break;

			default: System.out.print("***improper input please correct****");//default case if a non recognized char is entered
			}
			
		}
		result.add(new token(TokenType.endofline, " "));
		return result;
	}
	
//used to identify is it a num or not
	public static boolean isNumeric(String strNum) 
	{
	    if (strNum == null) //if string is null it gives false
	    {
	        return false;
	    }
	    try 
	    {
	        double d = Double.parseDouble(strNum);//we parse the string to double and see if it is a num or not.
	    } catch (NumberFormatException nfe) //if its not it throws false to the boolean value.
	    {
	        return false;
	    }
	    return true; //if it is parsed then it is true
	}


}