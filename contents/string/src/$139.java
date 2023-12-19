import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class $139 {
    String s;
    int len;
    Set<String> set = new HashSet<>();

    int[] dp;

    //法一：递归
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.len = s.length();
        this.set.addAll(wordDict);

        return process(0);
    }

    //[index, len)及其子串是否在字典中
    //超过时间限制，不断递归，有一些子串被重复计算
    public boolean process(int index) {
        //index遍历完字符串，则全部与字典中的单词匹配
        if (index == len) {
            return true;
        }


        boolean res = false;
        for (int i = index; i < len; i++) {
            if (set.contains(s.substring(index, i+1))) {
                res |= process(i+1);
            }
        }
        return res;
    }

    //法二：非递归，使用dp[]保存子串的结果
    public boolean wordBreak2(String s, List<String> wordDict) {
        this.s = s;
        this.len = s.length();
        this.set.addAll(wordDict);
        this.dp = new int[len+1];

        //1.初始化dp[]
        Arrays.fill(dp, -1);

        return process2(0);
    }

    public boolean process2(int index) {
        //2.查表，子串是否已计算过
        //-1表示未计算，1表示子串在字典中，0表示子串不在字典中
        if (dp[index] != -1) {
            return dp[index] == 1;
        }

        //index遍历完字符串，则全部与字典中的单词匹配
        if (index == len) {
            return true;
        }

        //否则进行计算dp[]
        boolean res = false;
        for (int i = index; i < len; i++) {
            if (set.contains(s.substring(index, i+1))) {
                res |= process2(i+1);
            }
        }
        //3.写表
        dp[index] = res ? 1 : 0;

        return res;
    }

    //法三：非递归，从后往前遍历
    public boolean wordBreak3(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len+1];

        //空串，默认在字典中
        dp[len] = true;

        for (int i = len-1; i >= 0; i--) {
            boolean res = false;
            for (int j = i; j < len; j++) {
                //若前缀子串[i,j]在字典中，则判断[j+1,len)及其子串是否在字典中
                if (set.contains(s.substring(i, j+1))) {
                    //[j+1,len)及其子串只要有一个在字典中，则为true
                    res |= dp[j + 1];
                }
            }
            dp[i] = res;
        }
        return dp[0];
    }
}
