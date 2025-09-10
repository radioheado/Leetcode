class Solution:
    def minimumTeachings(self, n: int, languages: List[List[int]], friendships: List[List[int]]) -> int:
        user_languages = {}
        # Step 1: Convert each user's known languages to a set for fast lookup
        for user_id, langs in enumerate(languages, start=1):
            user_languages[user_id] = set(langs)

        # Step 2: Find the pairs that cannot communicate
        broken_pairs = []
        for u, v in friendships:
            if not user_languages[u].intersection(user_languages[v]):
                broken_pairs.append((u, v))

        # Step 3: Find all users involved in broken pairs
        users_to_consider = set()
        for u, v in broken_pairs:
            users_to_consider.add(u)
            users_to_consider.add(v)

        # Step 4: Try each language to teach, and find the minimal number of users who need it
        min_users_to_teach = inf
        for lang_id in range(1, n + 1):
            need_to_learn = 0
            for user in users_to_consider:
                if lang_id not in user_languages[user]:
                    need_to_learn += 1
            min_users_to_teach = min(min_users_to_teach, need_to_learn)

        return min_users_to_teach