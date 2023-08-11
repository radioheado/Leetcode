public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        String delim = "/:";

        for (String s: strs) {
            sb.append(s.length()).append(delim).append(s);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decoded = new ArrayList();
        int i = 0;

        while (i < s.length()) {
            int delim = s.indexOf("/:", i);
            int l = Integer.parseInt(s.substring(i, delim));
            String str = s.substring(delim + 2, delim + 2 + l);
            decoded.add(str);
            i = delim + 2 + l;
        }

        return decoded;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));