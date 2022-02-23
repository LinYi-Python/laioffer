package practice;

public class RemoveAdjacentRepeatedCharactersIV82 {
}

class RemoveAdjacentRepeatedCharactersIV82A {
    public String deDup(String input) {
        // Write your solution here
        if (input == null || input.length() <= 1){
            return input;
        }
        char[] array = input.toCharArray();

        int end = 0;
        for (int i = 1; i < array.length; i++){
            if (end == -1 || array[i] != array[end]){
                array[++end] = array[i];
            } else {
                end--;
                while(i + 1 < array.length && array[i] == array[i + 1]){
                    i++;
                }
            }
        }
        return new String(array, 0, end + 1);
    }

    public static void main(String[] args) {
        RemoveAdjacentRepeatedCharactersIV82A test = new RemoveAdjacentRepeatedCharactersIV82A();
        String input = "abbbaaccz";
        String result = test.deDup(input);
        System.out.println(result);
    }
}

