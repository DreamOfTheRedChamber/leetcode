package string;

/*
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37

 * */

public class CompareVersionNumbers
{
 public int compareVersion( String version1, String version2 ) 
 {
  String[] levels1 = version1.split( "\\." );
  String[] levels2 = version2.split( "\\." );
  
  int length = Math.max( levels1.length, levels2.length );
  for ( int i = 0; i < length; i++ )
  {
  	int v1 = i < levels1.length ? Integer.parseInt( levels1[i] ) : 0;
  	int v2 = i < levels2.length ? Integer.parseInt( levels2[i] ) : 0;
  	
  	if ( v1 != v2 )
  	{
  		return v1 > v2 ? 1 : -1;
  	}
  }
  
  return 0;
 }
}
