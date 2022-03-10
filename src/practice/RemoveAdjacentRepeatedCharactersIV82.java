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



//same as laicode 118 =Remove Adjacent Repeated Characters IV
//https://app.laicode.io/app/problem/118?plan=3


class RemoveAdjacentRepeatedCharactersIV82B {
    public String deDup(String input) {
        // Write your solution here
        if(input == null || input.length() <= 1){
            return input;
        }
        char[] array = input.toCharArray();
        int end = -1;
        for(int i = 0; i < array.length; i++){
            if(end == -1 || array[end] != array[i]){
                array[++end] = array[i];
            } else{
                while(i + 1 < array.length && array[i + 1] == array[end]){
                    i++;
                }
                end--;
            }
        }
        return new String(array, 0, end + 1);
    }
}

// i and end defination different