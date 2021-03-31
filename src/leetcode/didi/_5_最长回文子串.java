package leetcode.didi;

public class _5_最长回文子串 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1 ) return s;
        String maxStr = "";

        for (int i = 0; i < s.length(); i++) {

            String oddStr = expendStr(s, i ,i);
            String evenStr = expendStr(s, i ,i+1);

            String curMaxStr = oddStr.length()  > evenStr.length() ? oddStr : evenStr;
            if (curMaxStr.length() > maxStr.length()) {
                maxStr = curMaxStr;
            }
        }

        return maxStr;
    }

    private String expendStr(String s, int left, int right) {
        int len = s.length();

        int l = left;
        int r = right;

        while (l >= 0 && r < len) {
            if (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }else {
                break;
            }
        }
        // l 跳出循环多--需要加， r不需要-，因为本身不包含
        return s.substring(l + 1, r);
    }
}
