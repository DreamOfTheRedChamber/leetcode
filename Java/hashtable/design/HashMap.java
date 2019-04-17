package hashtable.design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class MapEntry<K, V>
{
	private K key;
	private V value;
	public MapEntry( K key, V value )
	{
		this.key = key;
		this.value = value;
	}

	public K getKey()
	{
		return key;
	}
	public V getValue()
	{
		return value;
	}
	public void setKey( K key )
	{
		this.key = key;
	}
	public void setValue( V value )
	{
		this.value = value;
	}
	
	@Override
	public boolean equals( Object entry )
	{
		// judge entry class type
		if ( !( entry instanceof MapEntry ) )
		{
			return false;
		}
		
		// use the key field as standard
		MapEntry<K,V> castedEntry = (MapEntry<K,V>) entry;
		return this.getKey().equals(castedEntry.getKey());
	}
	
	@Override
	public int hashCode()
	{
		return this.getKey().hashCode();
	}	
}

public class HashMap<K,V>
{	
	private int bucketSize;
	private List<List<MapEntry<K,V>>> listHeads;
	
	public HashMap( int bucketSize )
	{
		this.bucketSize = bucketSize;
		listHeads = new ArrayList<>();
		for (int i = 0; i < bucketSize; i++)
		{
			listHeads.add( new LinkedList<MapEntry<K,V>>());
		}
	}
	
	private int calcBucketIndex( K key )
	{
		return key.hashCode() % bucketSize;
	}
	
	private List<MapEntry<K,V>> getMatchedEntry( final K key )
	{
		return 	listHeads.get( calcBucketIndex( key ) )
				.stream()
				.filter( ( MapEntry<K, V> o ) -> o.getKey().equals(key) )
				.collect( Collectors.toList() );
	}
	
	public Optional<V> get( final K key )
	{
		List<MapEntry<K,V>> matchedEntry = getMatchedEntry( key );
		if ( matchedEntry.size() == 0 )
		{
			return Optional.empty();
		}
		else if ( matchedEntry.size() == 1)
		{
			return Optional.ofNullable( matchedEntry.get( 0 ).getValue() );
		}
		else
		{
			throw new IllegalStateException("");			
		}
	}
	
	public Optional<V> put( final K key, final V value )
	{
		List<MapEntry<K,V>> matchedEntry = getMatchedEntry( key );
		if ( matchedEntry.size() == 0 )
		{
			int bucketIndex = calcBucketIndex( key );
			List<MapEntry<K,V>> chainingList = listHeads.get(bucketIndex);
			chainingList.add( new MapEntry<K,V>( key, value ));		
			return Optional.ofNullable(value);
		}
		else if ( matchedEntry.size() == 1 )
		{
			matchedEntry.get( 0 )
						.setValue( value );
			return Optional.ofNullable(value);
		}
		else
		{
			throw new IllegalStateException("");
		}
	}
	
	public Optional<V> remove( final K key )
	{
		int bucketIndex = calcBucketIndex( key );
		
		
		List<MapEntry<K,V>> chainingList = listHeads.get( bucketIndex );		
		int valueIndex = chainingList.indexOf( key );
		if ( valueIndex == -1 )
		{
			return null;
		}
		else
		{
			MapEntry<K,V> entry = chainingList.get( valueIndex );
			if ( entry != null )
			{
				V entryValue = (V) (entry.getValue());
				chainingList.remove( entry );
				return Optional.ofNullable(entryValue);
			}
			else
			{
				return Optional.empty();
			}			
		}
	}
}