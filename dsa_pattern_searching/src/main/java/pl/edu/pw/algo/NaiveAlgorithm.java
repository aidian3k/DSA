package pl.edu.pw.algo;

import pl.edu.pw.algo.Interfaces.Pattern;

public class NaiveAlgorithm implements Pattern {

    @Override
    public void search(String P, String T) {
        int n=T.length();
        int m=P.length();

        if(n < m){
            throw new IllegalArgumentException("Nieprawidlowe wielkosci wczytanych napisow!");
        }

        for(int s=0 ; s < n-m+1 ; ++s){
            if(P.charAt(0)==T.charAt(s)){

                boolean isEqual=true;

                for(int i=s+1;i<s+m;++i){
                    if(P.charAt(i-s)!=T.charAt(i)){
                        isEqual=false;
                        break;
                    }
                }

                if(isEqual){
                    System.out.println("Wystapienie wzorca o przesunieciu: "+(s+1));
                }
            }
        }
    }
}
