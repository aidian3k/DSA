package pl.edu.pw.algo;

import pl.edu.pw.algo.Interfaces.Pattern;
import pl.edu.pw.algo.Interfaces.Prefix;

public class KnuthMorrisPrattAlgorithm implements Pattern, Prefix {
    @Override
    public void search(String P, String T) {
        int n = T.length();
        int m = P.length();
        int [] pi = computePrefixFunction(P);
        int j=0 , i=0;

        if(n < m){
            throw new IllegalArgumentException("Nieprawidlowe wielkosci wczytanych napisow!");
        }

        while(i < n ){

            if(T.charAt(i) == P.charAt(j)){
                j++;
                i++;
            }

            if(j==m){
                System.out.println("Wystapienie wzorca o przesunieciu: "+(i-m+1));
                j=pi[j-1];
            }

            else if(i < n && T.charAt(i) != P.charAt(j) ){
                if(j!=0){
                    j=pi[j-1];
                }
                else{
                    i++;
                }
            }

        }
    }

    @Override
    public int[] computePrefixFunction(String P) {
        int m = P.length();
        int [] pi = new int [m];
        pi[0]=0;
        int sumAll=0;

        for(int i = 1 ; i < m ; ++i){

            if(P.charAt(i)!=P.charAt(sumAll)){
                continue;
            }
            else{

                while(i < m && P.charAt(i)==P.charAt(sumAll)){
                    ++sumAll;
                    pi[i]=sumAll;
                    i++;
                }

                sumAll=0;

            }

        }
        return pi;
    }

}
