/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

 class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostname = breakUrl(startUrl);
        Stack<String> stack = new Stack();
        stack.push(startUrl);
        Set<String> visited = new HashSet();
        visited.add(startUrl);

        while (!stack.isEmpty()) {
            String url = stack.pop();
            for (String child: htmlParser.getUrls(url)) {
                if (hostname.equals(breakUrl(child)) && !visited.contains(child)) {
                    visited.add(child);
                    stack.push(child);
                }
            }
            
        }

        return new ArrayList(visited);
    }

    private String breakUrl(String url) {
        return url.split("/")[2];
    }
}