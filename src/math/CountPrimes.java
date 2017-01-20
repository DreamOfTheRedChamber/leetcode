package math;

/**
Count the number of prime numbers less than a non-negative number, n.
 */

public class CountPrimes
{

	public int countPrimes( int n )
	{
		boolean[] notPrime = new boolean[n];
		int count = 0;
		for ( int i = 2; i < n; i++ )
		{
			if ( notPrime[i] == false )
			{
				count++;
				for ( int j = 2; i * j < n; j++ )
				{
					notPrime[i * j] = true;
				}
			}
		}

		return count;
	}

}
