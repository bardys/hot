package app;

public class SimpleNumbers {
    public static void main(String[] args) {
        boolean result = checkSimple(2);
        System.out.println(result);
    }

    public static boolean checkSimple(int n){
        if(n==1){return false;}
        for( int d=2; d*d<=n; d++){
            if(n%d == 0){return false;}
        }
        return true;
    }
}
