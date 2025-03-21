class Solution:
    def findAllRecipes(self, recipes: List[str], ingredients: List[List[str]], supplies: List[str]) -> List[str]:
        ans = []
        supplies = set(supplies)
        # Map recipe to its index
        recipe_set = {recipe: i for i, recipe in enumerate(recipes)}

        # Map ingredient to recipes that need it
        dependency_graph = defaultdict(list)
        in_degree = [0] * len(recipes)

        for i, ingredient in enumerate(ingredients):
            for igtd in ingredient:
                if igtd not in supplies:
                    dependency_graph[igtd].append(recipes[i])
                    in_degree[i] += 1
        
        # Start with recipes that only require supplies
        queue = deque(i for i, count in enumerate(in_degree) if count == 0)

        while queue:
            recipe_idx = queue.popleft()
            recipe = recipes[recipe_idx]
            ans.append(recipe)

            for dependent in dependency_graph[recipe]:
                in_degree[recipe_set[dependent]] -= 1
                if in_degree[recipe_set[dependent]] == 0:
                    queue.append(recipe_set[dependent])

        return ans