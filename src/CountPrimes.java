/**
 * Created by noMoon on 2015-08-29.
 */
public class CountPrimes {
    public static void  main(String[] args){
        System.out.println(countPrimes(5));
    }

    public static int countPrimes(int n) {

        boolean[] primes=new boolean[n];
        for(int i=0;i<n;i++){
            primes[i]=true;
        }

        int count=0;
        for(int i=2;i<n;i++){
            if(primes[i]){
                count++;
                for(int j=2;j<n/i+1;j++){
                    int tempIndex=i*j;
                    if(tempIndex<n){
                        primes[tempIndex]=false;

                    }
                }
            }
        }
        return count;
    }
}
