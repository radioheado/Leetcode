# """
# This is HtmlParser's API interface.
# You should not implement it, or speculate about its implementation
# """
#class HtmlParser(object):
#    def getUrls(self, url):
#        """
#        :type url: str
#        :rtype List[str]
#        """

class Solution:
    def crawl(self, startUrl: str, htmlParser: 'HtmlParser') -> List[str]:

        def breakUrl(url: str):
            return url.split('/')[2]

        hostname = breakUrl(startUrl)
        seen = set([startUrl])
        stack = deque([startUrl])
        while stack:
            url = stack.pop()
            for child in htmlParser.getUrls(url):
                if breakUrl(child) == hostname and child not in seen:
                    seen.add(child)
                    stack.append(child)

        return seen