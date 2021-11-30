# Make the disjoint set union
class DSU:
    def __init__(self, size):
        self.parent = [i for i in range(size)]
        self.rank = [1]*size
    
    # find the root of x
    def find(self, x):
        # if x is its own root, return itself
        # else, find its root recursively
        return x if x==self.parent[x] else self.find(self.parent[x])
    
    # union two sets
    def union(self, x, y):
        rootx = self.find(x)
        rooty = self.find(y)
        # different roots, need to merge one to another who has larger rank
        if rootx != rooty:
            if self.rank[rootx] < self.rank[rooty]:
                self.parent[rootx] = rooty
            elif self.rank[rootx] > self.rank[rooty]:
                self.parent[rooty] = rootx
            else:
                # x and y have the same rank
                # merge x to y, and increment y's rank
                self.parent[rootx] = rooty
                self.rank[rooty] += 1
        

class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        # make a DSU to perform find and union operations
        dsu = DSU(len(accounts))
        
        # use this dict to store the mapping between email: id
        # where id is the index of root account in accounts
        email_id = {}
        
        # use this dict to store the mapping between id: [name, emails]
        # name is accounts[i][0], emails are from iterating email_id
        id_name_email = {}
        
        # use this list to store the output from iterating id_name_email
        # so we'll get it in the form: [name, emails]
        # and we need to sort emails
        res = []
        
        for i in range(len(accounts)):
            # get the emails
            emails = accounts[i][1:]
            #print(emails)
            
            # make the mapping between email: id
            for email in emails:
                
                # if email is already visited and has a root
                # update it's root 
                if email in email_id:
                    dsu.union(email_id[email], i)
                # else, make i it's root    
                else:
                    email_id[email] = i
                    
        # make the mapping between id: [name, emails]        
        for email, i in email_id.items():
            i = dsu.find(i)
            #print(email, i)
            # use set to store the emails
            if i not in id_name_email:
                id_name_email[i] = [accounts[i][0], set()]
                
            id_name_email[i][1].add(email)
                
        # iterate the items out of id_name_email and store it to res
        for name, emails in id_name_email.values():
            #print(name, emails)
            res.append([name] + list(sorted(list(emails))))
                
        return res
