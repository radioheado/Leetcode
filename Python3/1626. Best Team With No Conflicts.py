class Solution:
    def bestTeamScore(self, scores: List[int], ages: List[int]) -> int:
        age_score = [(age, score) for (age, score) in zip(ages, scores)]
        age_score.sort()
        
        def helper():
            N = len(age_score)
            dp = [score for age, score in age_score]
            ans = max(dp)

            for i in range(N):
                for j in range(i - 1, -1, -1):
                    # if i-th player and j-th player can be in the same team
                    # add j-th player's best score to dp[i] if applicable
                    if age_score[i][1] >= age_score[j][1]:
                        dp[i] = max(dp[i], age_score[i][1] + dp[j])

                # update ans if applicable
                ans = max(ans, dp[i])   

            return ans

        return helper()