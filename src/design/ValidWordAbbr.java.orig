package design;

import java.util.Set;

public class ValidWordAbbr
{
	private Set<String> dict;
	
	public ValidWordAbbr( String[] dictionary )
	{
		for ( String word : dictionary )
		{
			dict.add( getAbbre( word ) );
		}
	}

	public boolean isUnique( String word )
	{
		String abbre = getAbbre( word );
		return !dict.contains( abbre );
	}
	
	private String getAbbre( String word )
	{
		if ( word.length() <= 2 )
		{
			return word;
		}
		else
		{
			StringBuilder abbre = new StringBuilder();
			abbre.append( word.charAt( 0 ) );
			abbre.append( word.length() - 2 );
			abbre.append( word.charAt( word.length() - 1 ) );
			return abbre.toString();
		}
	}
}

// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");