public class powXN {
    public double myPow(double x, int n) {
        long p=n;
        if(p<0){
            x=1/x;
            p=-p;
        }
        double result=1;
        while(p>0){
            if((p&1)==1){
                result=result*x;
            }
            x=x*x;
            p=p>>1;
        }
        return result;
    }
}

