class Solution:
    def minimumHealth(self, damage: List[int], armor: int) -> int:
        maxDamage = max(damage)
        if maxDamage <= armor:
            return sum(damage) - maxDamage + 1

        else:
            return sum(damage) - armor + 1