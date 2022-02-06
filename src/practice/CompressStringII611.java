package practice;


import java.util.ArrayList;
import java.util.List;

class CompressStringII611A {
    public String compress(String input) {
        // Write your solution here
        if(input == null || input.length() == 0){
            return input;
        }
        char[] array = input.toCharArray();
        List<Node> result = new ArrayList<>();
        int begin = 0;
        int fast = 0;
        while(fast < array.length){
            //case 1 more than two char
            begin = fast;
            int value = 0;
            if((fast + 1 < array.length) && (array[fast + 1] == array[fast])){
                while(fast < array.length && array[fast] == array[begin]){
                    fast++;
                    value++;
                }
                result.add(new Node(array[begin], value));
                continue;
            }


            //case 2 just one char
            if((fast + 1 == array.length)|| (array[fast + 1] != array[fast])){//fast is the last one
                result.add(new Node(array[fast], 1));
                fast++;
                continue;
            }

        }
        //compress the result
        StringBuilder sb = new StringBuilder();
        for(Node cur: result){
            sb.append(cur.value);
            sb.append(cur.time);
        }
        return new String(sb);
    }

    class Node{
        char value;
        int time;
        Node(char value, int time){
            this.value = value;
            this.time = time;
        }
    }
    //TC: O(n)
    //SC: O(n)

    public static void main(String[] args) {
        CompressStringII611A test = new CompressStringII611A();
        String input = "nsgzrfgqunfxykffoqjrvg";
        String result = test.compress(input);
        System.out.println(result);
    }
}

//简化
class CompressStringII611B {
    public String compress(String S) {
        if (S.length() == 0) { // 空串处理
            return S;
        }
        StringBuffer ans = new StringBuffer();
        int cnt = 1;
        char ch = S.charAt(0);
        for (int i = 1; i < S.length(); ++i) {
            if (ch == S.charAt(i)) {
                cnt++;
            } else {
                ans.append(ch);
                ans.append(cnt);
                ch = S.charAt(i);
                cnt = 1;
            }
        }
        ans.append(ch);
        ans.append(cnt);
        return ans.length() >= S.length() ? S : ans.toString();
    }

    //TC: O(n)
    //SC: O(n)
    public static void main(String[] args) {
        CompressStringII611B test = new CompressStringII611B();
        String input = "nsgzrfgqunfxykffoqjrvg";
        String result = test.compress(input);
        System.out.println(result);
    }
}


class CompressStringII611C {
    public String compress(String input) {
        // Write your solution here
        if(input == null || input.isEmpty()){
            return input;
        }
        char[] array = input.toCharArray();
        return encode(array);
    }

    private String encode(char[] input){
        int slow = 0;
        int fast = 0;
        int newLength = 0;
        while(fast < input.length){
            int begin = fast;
            while(fast < input.length && input[fast] == input[begin]){
                fast++;
            }
            input[slow++] = input[begin];
            if(fast - begin == 1){
                newLength += 2;
            }else{
                int len = copyDigits(input, slow, fast - begin);
                slow += len;
                newLength += len + 1;
            }
        }

        char[] result = new char[newLength];
        fast = slow - 1;
        slow = newLength - 1;
        while(fast >= 0){
            if(Character.isDigit(input[fast])){
                while(fast >= 0 && Character.isDigit(input[fast])){
                    result[slow--] = input[fast--];
                }
            }else {
                result[slow--] = '1';
            }
            result[slow--] = input[fast--];
        }
        return new String(result);
    }

    private int copyDigits(char[] input, int index, int count){
        int len = 0;
        for(int i = count; i > 0; i /= 10){
            index++;
            len++;
        }

        for(int i = count; i > 0; i /= 10){
            int digit = i % 10;
            input[--index] = (char)('0' + digit);
        }
        return len;
    }

    public static void main(String[] args) {
        CompressStringII611C test = new CompressStringII611C();
        String input = "abbcccdeee";
        String result = test.compress(input);
        System.out.println(result);
    }
}
