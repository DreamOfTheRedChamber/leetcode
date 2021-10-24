
# Topological sort
* There are basically two categories of methods for topological sort. The first one is greedy algorithm with O\(\|V\|^2 + \|E\|\) time complexity. The second is based on depth first search with O\(\|V\| + \|E\|\) time complexity. Here only discusses DFS based approach. 

## DFS
* When using DFS based approach, there are two cases which should be taken care of. The first one is what if there exists no topological order at all. The second is how to return topological order.
  * What if there exists no topological order - a cycle is detected. 
    * How to detect cycle: use UNDISCOVERED, DISCOVERED, VISITED to represent three possible states of graph nodes. Use a Set&lt;?&gt; isDiscovered and Set&lt;?&gt; isVisited to record all history info. If met up with a node which has been discovered but not visited, then a cycle is detected. 
    * How to handle cycle: return a boolean value \(preferred\) or throw an exception \(not really suitable because they are expected cases\)
  * What if need to return topological order
    * If do not need to detect cycle, could simply use a Stack&lt;&gt; order to record the visited node, namely using Set&lt;?&gt; discovered, Stack&lt;?&gt; visited 
    * If need to detect cycle, namely using Set&lt;?&gt; discovered, LinkedHashSet&lt;?&gt; visited

```java
public int[] getTopoOrder(Map graph) 
{
    Set discovered = new HashSet<>(); 
    Set visited = new LinkedHashSet<>(); 
    for (Integer node : graph.keySet()) 
    { 
        if (!discoverd.contains(node)) 
        { 
            if (!topoSort(graph, node, discovered, visited)) 
            { // a cycle is detected....error handling 
            } 
        } 
    }
    
    return visited.stream().reverse().collect( Collectors.toList(); 
    int[] topoOrder = new int[visited.size()];
    int pos = topoOrder.length - 1; 
    for (Integer node : visited) 
    {
        topoOrder[pos] = node; 
        pos--; 
    }

    return topoOrder; 
}

// @return whether a cycle is detected
private boolean topoSort(Map graph, Integer startNode, Set discovered, Set visited)
{
    discovered.add(startNode);
    for (Integer neighbor : graph.get(startNode))
    {
        if (!discovered.contains(neighbor))
        {
            if (topoSort(graph, neighbor, discovered, visited))
            {
                return true;
            }
        }
        else if (discovered.contains(neighbor) 
                    && !visited.contains(neighbor))
        {
            return true;
        }
        else
        {
            // already visited, do nothing
            ;
        }
    }

    visited.add(startNode);
    return false;
}
```

## BFS