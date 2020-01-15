public class $709 {
    public String toLowerCase(String str) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            //判断是否为大写字母
            if (x >= 'A' && x <= 'Z') {
                res.append((char) (x + 32));
            } else {
                res.append(x);
            }
        }
        return res.toString();
    }
}
