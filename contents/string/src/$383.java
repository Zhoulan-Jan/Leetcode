/**
 * 把 magazine 里的字母放在字符数组 str 中 (str 存放每个字母的个数)
 * 再遍历 ransomNode 里的字母，每遍历一个字母 对应的str就 --，出现负数就返回false
 */
public class $383 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        //把 magazine 里的字母放在字符数组 str 中
        int[] str = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            str[magazine.charAt(i) - 'a']++; //字母转为ascii
        }
        //再遍历 ransomNode 里的字母，每遍历一个字母 对应的str就 --，出现负数就返回false
        for (int j = 0; j < ransomNote.length(); j++) {
            int index = ransomNote.charAt(j) - 'a';
            str[index]--;
            if (str[index] < 0) {
                return false;
            }
        }
        return true;
    }

    //大佬解法
    public boolean canConstruct2(String ransom, String magazine) {
        //ransom 的长度大于 magazine 的长度 就返回false
        if (magazine.length() < ransom.length())
            return false;
        int caps[] = new int[26];
        for (char c : ransom.toCharArray()) {
            //magazine.indexOf(int ch, int fromIndex) 返回某个字母从fromIndex开始搜索 第一次出现的位置
            //caps[] 对应该字母遍历的起始位置
            int index = magazine.indexOf(c, caps[c - 'a']);
            if (index == -1)
                return false;
            caps[c - 97] = index + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }
}
