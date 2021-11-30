class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU(accounts.size());
        
        // use this HashMap to store the mapping between email: id
        // where id is the index of root account in accounts
        Map<String, Integer> email_id = new HashMap<>();
        
        // use this HashMap to store the mapping between id: emails
        // name is accounts[i][0], emails are from iterating email_id
        Map<Integer, List<String>> id_email = new HashMap<>();
        
        // use this list to store the output from iterating id_email
        // so we'll get it in the form: [name, emails]
        // and we need to sort emails
        List<List<String>> answer = new ArrayList<>();
        
        for(int i=0; i<accounts.size(); i++){
            
            // get the emails, index is from 1 to the end of the list
            // and map the email to the id, which is i
            for(int j=1; j<accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                
                // email is already visited
                if(email_id.containsKey(email)){
                    // update the root of id
                    dsu.union(i, email_id.get(email));
                }else{
                    email_id.put(email, i);
                }
            }
            
        }
        
        // make the mapping between id: [name, emails]
        for(String email: email_id.keySet()){
            
            // find the root of email's mapping and update it if possible
            int root = email_id.get(email);
            root = dsu.find(root);
            
            // if root is not in id_email yet, add it to the hash map
            // and use a hash set to store the emails
            if(!id_email.containsKey(root)){
                id_email.put(root, new ArrayList<String>());
            }
            
            id_email.get(root).add(email);
        }
        
        // sort the emails in id_email and add it to the answer list
        for(int id: id_email.keySet()){
            List<String> emails = id_email.get(id);
            Collections.sort(emails);
            emails.add(0, accounts.get(id).get(0));
            answer.add(emails);
        }
        
        return answer;
        
    }
}


// define the DSU
class DSU{
    
    // store the parent index
    private int[] parent;
    // store the rank of parents
    private int[] rank;
    
    DSU(int size){
        parent = new int[size];
        rank = new int[size];
        
        for(int i=0; i<size; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }
    
    // find the root of x
    public int find(int x){
        return x == parent[x] ? x : (parent[x] = find(parent[x]));
    }
    
    // merge two roots
    public void union(int a, int b){
        int x = find(a);
        int y = find(b);
        
        // different roots, need to merge one to another who has larger rank
        if(x != y){
            if(rank[x] < rank[y]){
                parent[x] = y;
            }else if(rank[x] > rank[y]){
                parent[y] = x;
            }else{
                parent[x] = y;
                rank[y]++;
            }
        }
    }
    
}