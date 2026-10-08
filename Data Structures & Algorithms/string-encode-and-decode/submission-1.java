class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        // for each string, add its length + delimiter
        for (String str : strs) { // when does this work?
            int length = str.length();
            res.append(length);
            res.append('#');
            res.append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length; // at index after string
            res.add(str.substring(i, j));
            i = j;
        }    
        return res;
    }
}
