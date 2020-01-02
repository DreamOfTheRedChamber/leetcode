class OptimizeWaterDistributionInAVillage:
    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:

        def find(x):
            return x if x == union_find[x] else find(union_find[x])

        def union(x, y):
            px = find(x)
            py = find(y)
            union_find[px] = py

        union_find = {i: i for i in range(n + 1)}

        graph_wells = [[cost, 0, i] for i, cost in enumerate(wells, 1)]
        graph_pipes = [[cost, i, j] for i, j, cost in pipes]
        min_costs = 0
        for cost, x, y in sorted(graph_wells + graph_pipes):
            if find(x) == find(y):
                continue
            union(x, y)
            min_costs += cost
            n -= 1
            if n == 0:
                return min_costs