package facebook.medium;

import org.junit.Test;

/**
 * 输入[1,2,3, {"id": 1, "name": "wang", "tag":[1,"home",2], "price":234}]
 * Pretty print a json object using proper indentation.

Every inner brace should increase one indentation to the following lines.
Every close brace should decrease one indentation to the same line and the following lines.
The indents can be increased with an additional ‘\t’
Example 1:

Input : {A:"B",C:{D:"E",F:{G:"H",I:"J"}}}
Output : 
{ 
    A:"B",
    C: 
    { 
        D:"E",
        F: 
        { 
            G:"H",
            I:"J"
        } 
    }     
}
Example 2:

Input : ["foo",{"bar":["baz",null,1.0,2]}]
Output : 
[
    "foo", 
    {
        "bar":
        [
            "baz", 
            null, 
            1.0, 
            2
        ]
    }
]
[] and {} are only acceptable braces in this case.

Assume for this problem that space characters can be done away with.

Your solution should return a list of strings, where each entry corresponds to a single line. The strings should not have “\n” character in them.
 */

public class PrettifyJSON
{
	@Test
	public void test()
	{
		System.out.println( printJSON( "[\"foo\",{\"bar\":[\"baz\",null,1.0,2]}]" ) );
		System.out.println( printJSON( "{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}" ) );
	}
	
	public String printJSON( String input )
	{
		StringBuilder result = new StringBuilder();
		int indentNum = 0;
		int index = 0;
		while ( index < input.length() )
		{
			switch ( input.charAt( index ) )
			{
				case '{':
				case '[':
					addIndent( result, indentNum );
					result.append( input.charAt( index ) );
					result.append( '\n' );
					indentNum++;

					index++;
					break;
				case '}':
				case ']':
					indentNum--;
					addIndent( result, indentNum );
					result.append( input.charAt( index ) );
					result.append( '\n' );

					index++;
					break;
				default:
					addIndent( result, indentNum );
					while ( input.charAt( index ) != ',' && input.charAt( index ) != ']' && input.charAt( index ) != '[' && input.charAt( index ) != '{' && input.charAt( index ) != '}')
					{
						result.append( input.charAt( index ) );
						index++;
					}
					if ( input.charAt( index ) == ',' )
					{
						result.append( input.charAt( index ) );
						index++;
					}
					result.append( '\n' );
					break;
			}			
		}
		return result.toString();
	}
	
	private void addIndent( StringBuilder result, int indentNum )
	{
		for ( int i = 0; i < indentNum; i++ )
		{
			result.append( '\t' );
		}
	}
}
