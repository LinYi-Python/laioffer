package practice;

public class EditDistance100 {
    public int editDistance(String word1, String word2){
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        //dp[i][j] means for substring word1 [0, i] and substring word2 [0, j]
        // the edition distance

        //case 1
        //is word1[i] == word2[j]
        // dp[i][j] = dp[i - 1][j - 1]

        //case 2
        // !=. and replace
        //dp[i][j] = dp[i - 1][j - 1] + 1

        //case 3
        // != and delete word1
        //dp[i][j] = dp[i - 1][j] + 1

        //case 4
        // != and insert word1
        //dp[i][j] = dp[i][j - 1] + 1


        //Initialization
                 //word 2
        // word1  x x x x
        //        x x x x
        //        x x x x

        //Initialization
        for(int i = 0; i <= word1.length() + 1; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j <= word2.length() + 1; j++){
            dp[0][j] = j;
        }

        for(int i = 1; i <= word1.length(); i++){
            for(int j = 1; j <= word2.length(); j++){
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        EditDistance100 test = new EditDistance100();
        String word1 = "sigh";
        String word2 = "asith";
        int result = test.editDistance(word1, word2);
        System.out.println(result);
    }
}

class EditDistance100C {
    public int editDistance(String word1, String word2) {
        //  word1 " "
        //  word2 " "
        // 0

        //  word1 "a b c"
        //  word2 " "
        // 3   len(word1)

        //  word1 " "
        //  word2 "a b c "
        // 3   len(word2)


//find the connect between original problem with sub problem
        //   i
        //  word1 "a b c"
        //  word2 "a b c"
        //    j
        //  a == a
        // (i, j) = (i -1 + j - 1)

        //else
        //            i
        //  word1 "a c b"
        // word2 "a c d"
        //            j


        //insert (i, j + 1) = (i ,j) + 1
        //delete  (i + 1, j) = (i, j) + 1;
        //replace  (i + 1, j + 1) = (i, j) + 1;

        // case1 a = a
        // (i, j) = (i - 1, j - 1)

        // case2 insert
        //(i, j + 1) = (i, j) + 1

        //case 3 delete
        //(i + 1, j) = (i, j) + 1

        //case 4 replace
        //(i + 1, j + 1) = (i, j) + 1;

        //dp the min operation number of subString (o, i);

        //TC O(N M)
        //SC O(N M)
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        // " " -  "a" -..... "a b c"

        //Initialization the dp

        //   j
        // i x x x
        //   x x x
        //   x x x
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        //dp opera
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //min dp[i - 1][j - 1] dp[i -1][j] and dp[i][j - 1]
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[n][m];

    }

    public static void main(String[] args) {
        EditDistance100C test = new EditDistance100C();
        String word1 = "abc";
        String word2 = "acd";
        int result = test.editDistance(word1, word2);
        System.out.println(result);
    }
}



class EditDistance100F {
    public int editDistance(String word1, String word2){
        //word1 " "
        //word2 " "
        //0

        //word1 "abc"
        //word2 " "
        //lem(word1)

        ////word1 " "
        //word2 "abc"
        //len(word2)

        //         i
        //word1 "acb"
        //word2 "acd"
        //         j

        //case 1 a == a
        // (i + 1, j + 1) = (i , j)

        //case 2 insert
        //(i, j +1) = (i, j) + 1

        //case 3 delete
        // (i + 1, j) = (i, j) + 1

        //case 4 replace
        //(i + 1, j + 1) = (i, j) + 1

        //TC O(M * N)
        //SC O(M * N)

        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        //dp[i][j] the min opreation number between word1.substring(0, i) and word2.substring(0, j)

        //    j
        // i  x x x
        //    x x x
        //    x x x

        //initialization
        for(int i = 0; i <= n ; i++){
            dp[i][0] = i;
        }

        for(int j = 0; j <= m ; j++){
            dp[0][j] = j;
        }

        //dp operation
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j- 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[n][m];
    }
}


