package linkedIn;
/*
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

(1)  " . " ,   "1."  true,   "1.e2" true, ".3" true.
(2) " e ",   ".e1" false,  "1e.1" false, "1e1.1" false, "2.3e" false.
(3) "+/-",  "+1.e+5" true.

The key point of this problem is that we have to gather all possible cases, the problem is intended to be ambiguous. This problem is to test whether you have a comprehensive knowledge about a valid number. 
Basically, we have to find what kind of number is not valid.
After trim the string: remove all the leading space and trailing space
First of all, if there is a sign '+' or '-', it must be the first char or after a 'e' or 'E' and must be followed by number.
Secondly, if there is a 'e' or 'E', there must be no 'e' or 'E' occurred before, which means, only one scientific sign is allowed. There must be numbers before it and after it.
Thirdly, if there is a '.', must be no scientific sign before it and no dot before it. It must either follow a number or be followed by a number or scientific sign. 
Fourthly, no other character is allowed 

 * */
public class ValidNumber
{
 public boolean isNumber( String s )
 {
 	// skip leading white spaces
  int left = 0;
  while ( left < s.length() && Character.isWhitespace( s.charAt( left ) ) )
  {
  	left++;
  }
  if ( left >= s.length() )
  {
  	return false;
  }
  int right = s.length() - 1;
  while ( right >= left && Character.isWhitespace( s.charAt( right ) ) )
  {
  	right--;
  }
  // skip leading +/-
  if ( s.charAt( left ) == '+' || s.charAt( left ) == '-' )
  {
  	left++;
  }
  
  boolean isDigit = false;
  boolean isDot = false;
  boolean isExp = false;
  while ( left <= right )
  {
  	char c = s.charAt( left );
  	if ( Character.isDigit( c ) )
  	{
  		isDigit = true;
  	}
  	else if ( c == '.' )
  	{
  		if ( isExp || isDot )
  		{
  			return false;
  		}
  		isDot = true;
  	}
  	else if ( c == 'e' )
  	{
  		if ( isExp || !isDigit )
  		{
  			return false;
  		}
  		isExp = true;
  		isDigit = false;
  	}
  	else if ( c == '+' || c == '-' )
  	{
  		if ( s.charAt( left - 1 ) != 'e' )
  		{
  			return false;
  		}
  	}
  	else
  	{
  		return false;
  	}
  	left++;
  }
  return isDigit;
 }
}
