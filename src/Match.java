import java.util.*;

/**
 * @Description 一些匹配问题
 * @Author alice
 * @Date 2020/6/22 17:09
 **/
public class Match {
    public boolean patternMatching(String pattern, String value) {
        /**
         * @Description // 18. 模式匹配 https://leetcode-cn.com/problems/pattern-matching-lcci/
         * @Date 2020/6/22 17:13
         * @Param pattern
         * @param value
         * @return boolean
         **/
        // 1.枚举la
        int ca = 0, cb = 0; // la*ca+(lp-la)*cb=lv
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'a') {
                ca++;
            } else {
                cb++;
            }
        }
        if (ca < cb) {
            int temp = cb;
            cb = ca;
            ca = temp;
            char[] p = pattern.toCharArray();
            for (int i = 0; i < p.length; i++) {
                p[i] = p[i] == 'a' ? 'b' : 'a';
            }
            pattern = new String(p);
        }
        if (value.length() == 0) {
            return cb == 0;
        }

        // 此时value.len必不为0
        if (pattern.length() == 0) {
            return false;
        }
        for (int lena = 0; lena * ca <= value.length(); lena++) {

            int rest = (value.length() - ca * lena);
            if ((rest == 0 && cb == 0) || cb != 0 && rest % cb == 0) {
                int lenb = rest == 0 ? 0 : rest / cb;
                int pos = 0;
                Map<String, String> abMap = new HashMap<>();
                int i = 0;
                for (; i < pattern.length(); i++) {
                    if (pattern.charAt(i) == 'a') {
                        if (pos + lena > value.length()) {
                            break;
                        }
                        String str_save = value.substring(pos, pos + lena);
                        pos += lena;
                        abMap.putIfAbsent("a", str_save);
                        if (!abMap.get("a").equals(str_save)) {
                            break;
                        }
                    } else {
                        if (pos + lenb > value.length()) {
                            break;
                        }
                        String str_save = value.substring(pos, pos + lenb);
                        pos += lenb;
                        abMap.putIfAbsent("b", str_save);
                        if (!abMap.get("b").equals(str_save)) {
                            break;
                        }
                    }

                }
                if (pos == value.length() && i == pattern.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        /**
         * @Description // 139. 单词拆分 https://leetcode-cn.com/problems/word-break/
         * @Date 2020/6/25 18:24
         * @Param s
         * @param wordDict
         * @return boolean
         **/
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];

    }

    public boolean isMatch(String s, String p) {
        /**
         * @Description // 44. 通配符匹配 https://leetcode-cn.com/problems/wildcard-matching/
         * @Date  2020/7/6 17:34
         * @Param s 字符串
         * @param p 字符模式
         * @return boolean
         **/
        boolean [][]dp=new boolean[s.length()+1][p.length()+1];

        dp[0][0]=true;
        for (int i = 1; i <= p.length(); ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i=1;i<=s.length();i++){
            for (int j=1;j<=p.length();j++){
                if (s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if (p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
//        System.out.println(new Match().patternMatching("bbb", "xxxxxx"));

    }
}
