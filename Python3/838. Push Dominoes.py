class Solution(object):
    def pushDominoes(self, dominoes):
        temp = ''
        
        while dominoes != temp:
            temp = dominoes
            dominoes = dominoes.replace('R.L', 'xxx')
            dominoes = dominoes.replace('.L', 'LL')
            dominoes = dominoes.replace('R.', 'RR')
            
        return dominoes.replace('xxx', 'R.L')