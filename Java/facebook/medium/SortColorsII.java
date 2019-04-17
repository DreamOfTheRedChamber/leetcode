package facebook.medium;

public class SortColorsII 
{
	public void countingSort( int[] colors, int k )
	{
		int[] count = new int[k];
		for ( int color : colors )
		{
			count[color-1]++;
		}
		int index = 0;
		for ( int i = 0; i < k; i++ )
		{
			while ( count[i] > 0 )
			{
				colors[index++] = i + 1;
				count[i]--;
			}
		}
	}
	
	public void twoPointersSort( int[] colors, int k )
	{
		int left = 0;
		int right = colors.length - 1;
		int min = 1;
		int max = k;
		int i = 0;
		while ( min < max )
		{
			while ( i <= right )
			{
				if ( colors[i] == min )
				{
					swap( colors, left, i );
					i++;
					left++;
				}
				else if ( colors[i] == max )
				{
					swap( colors, right, i );
					right--;
				}
				else
				{
					i++;
				}
			}
			i = left;
			min++;
			max--;
		}
	}
	
	private void swap( int[] colors, int index1, int index2 )
	{
		int temp = colors[index1];
		colors[index1] = colors[index2];
		colors[index2] = temp;
	}
}
