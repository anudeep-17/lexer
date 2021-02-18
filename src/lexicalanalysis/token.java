package lexicalanalysis;
/*
 * this class is used to create tokens and use them to tokenize the input and seperate them
 */
public class token
{
	//enum that create tokens and use them 
public static enum TokenType
{
	plus, minus, times, divide,number, endofline, error;
	

}

public TokenType token; // tokentype variable to take the token

public String value; // string variable to the take the sign

//constuctor that initialises variables
public token(TokenType t , String c)
{
	this.token = t;
	this.value=c;
}
//to string method that is used to convert tokens to strings.
public String toString()
{
   if(token == TokenType.plus)
   {
	   return "plus ["+ value + "]"; //returns sign with the token
   }
   if(token == TokenType.minus)
   {
	   return "minus ["+ value + "]";//returns sign with the token
   }
   if(token == TokenType.number)
   {
	   return "number ["+ value + "]";//returns sign with the token
   }
   if(token == TokenType.times)
   {
	   return "multiply ["+ value + "]";//returns sign with the token
   }
   if(token == TokenType.divide)
   {
	   return "divide ["+ value + "]";//returns sign with the token
   }
   
   if(token == TokenType.endofline)
   {
	   return "[endofline]"; //says end of the line
   }
   if(token == TokenType.error)
   {
	   return "[error] please enter appropriate";//says error
	   
   }
   return token.toString();
	   
}
//accessors and modifier methods for the enum.
public String getValue() {return value;}
public void setValue(String value){ this.value = value;}
public void setstate(TokenType token){this.token = token;}
public TokenType getstate() {return token;}


}
