public class Two_Keys_Keyboard {
//    int n;
//    public int minSteps(int n) {
//        if(n == 1) return 0;
//        this.n = n;
//        int[][] memo = new int[n+1][(n/2 )+ 1];
//
//
//        return 1 + minStepsHelper(1, 1, memo);
//    }
//
//    public int minStepsHelper(int currLen, int pasteLen, int[][] memo){
//        if(currLen == n) return 0;
//        if(currLen > n) return 1000;
//        if(memo[currLen][pasteLen] != 0) return memo[currLen][pasteLen];
//
//        int opt1 = 1 + minStepsHelper(currLen + pasteLen, pasteLen, memo);
//        int opt2 = 2 + minStepsHelper(currLen * 2, currLen, memo);
//
//        return Math.min(opt1, opt2);
//
//    }
//
    public int minSteps(int n){
        if(n == 1) return 0;
        int prime = 2;
        int operations = 0;
        while(n > 1){
            while(n % prime == 0) {
                n /= prime;
                operations += prime;

            }
            prime++;
        }

//        System.out.println(prime);

        return operations;
    }
}
