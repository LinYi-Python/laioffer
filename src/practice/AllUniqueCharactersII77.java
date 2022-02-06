package practice;

public class AllUniqueCharactersII77 {
}


class AllUniqueCharactersII77A {
    public boolean allUnique(String word) {
        // Write your solution here
        int[] vec = new int[8];
        char[] array = word.toCharArray();
        for(char c: array){
            if((vec[c / 32] >>> (c % 32) & 1) != 0){
                return false;
            }
            vec[c / 32] |= 1 << (c % 32);
        }
        return true;
    }

    public static void main(String[] args) {
        AllUniqueCharactersII77A test = new AllUniqueCharactersII77A();
        String word = "abA+8";
        boolean result = test.allUnique(word);
        System.out.print(result);
    }
}
//TC O(N)
//SC O(1)