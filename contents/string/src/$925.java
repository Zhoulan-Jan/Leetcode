import java.util.HashMap;
import java.util.Map;

/**
 * 要求：1.typed 的每个字母个数 >= name 的对应的字母个数
 * 2.name 存在的字母，typed 也要存在
 * 3.有序
 */
public class $925 {
    //双指针
    public static boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) {
            return false;
        }
        char[] names = name.toCharArray();
        char[] typeds = typed.toCharArray();
        int cnt1 = 1;
        int cnt2 = 1;
        int i = 0;
        int j = 0;
        for (; i < names.length && j < typeds.length; ++i, ++j) {
            while (i < names.length-1 && names[i] == names[i+1]) {
                i++;
                cnt1++;
            }
            while (j < typeds.length-1 && typeds[j] == typeds[j+1]) {
                j++;
                cnt2++;
            }
            if (names[i] != typeds[j] || cnt1 > cnt2 ) {
                return false;
            }
            cnt1 = cnt2 = 1;
        }
        return (i >= names.length);
    }

    //哈希表 错误
    public static boolean isLongPressedName2(String name, String typed) {
        char[] names = name.toCharArray();
        char[] typeds = typed.toCharArray();
        HashMap<Character, Integer> nameMap = new HashMap<>();
        HashMap<Character, Integer> typedMap = new HashMap<>();
        //建立 map
        for (char ch : names) {
            int cnt = nameMap.getOrDefault(ch, 0);
            nameMap.put(ch,cnt + 1);
        }

        for (char ch : typeds) {
            int cnt = typedMap.getOrDefault(ch, 0);
            typedMap.put(ch, cnt + 1);
        }

        //name 存在的字母，typed 也要存在
        if (nameMap.size() > typedMap.size()) {
            return false;
        }

        //遍历 map
        int i = 0;
        for (Map.Entry<Character, Integer> n : nameMap.entrySet()) {
            for (Map.Entry<Character, Integer> t : typedMap.entrySet()) {
                if (n.getKey() == t.getKey()) {
                    if (n.getValue() > t.getValue()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex","aaleex") + " true");
        System.out.println(isLongPressedName("saeed","ssaaedd") + " false");
        System.out.println(isLongPressedName("xnhtq","xhhttqq") + " false" );
        System.out.println(isLongPressedName("leelee", "lleeelee") + " true");
        System.out.println(isLongPressedName("mvzi", "mmvvzz") + " false");
    }
}
