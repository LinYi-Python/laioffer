package practice;

public class StringReplacebasic649 {
    public String replace(String input, String s, String t) {
        // Write your solution here
        if (input.length() == 0 || s.length() == 0) {
            return input;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (i > input.length() - s.length()) {
                sb.append(input.charAt(i));
                continue;
            }
            for (int j = 0; j < s.length(); j++) {
                if (input.charAt(i + j) != s.charAt(j)) {
                    sb.append(input.charAt(i));
                    break;
                }
                if (j == s.length() - 1) {
                    sb.append(t);
                    i = i + j;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringReplacebasic649 test = new StringReplacebasic649();
        String input = "appledogapple", s = "apple", t = "cat";
        String result = test.replace(input, s, t);
        System.out.println(result);
    }
}
