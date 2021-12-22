import java.math.BigDecimal;
import java.math.BigInteger;

public class RSA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p,q,n,z,e,i,d=0;
		int msg=15;
		double c;
		BigInteger msgback;
		p=3;
		q=11;
		n=p*q;
		z=(p-1)*(q-1);
		System.out.println("Value of z : "+z);
		for(e=2;e<z;e++){
			if(gcd(e,z)==1){
				break;
			}
		}
		System.out.println("Value of e : "+e);
		for(i=0;i<=9;i++){
			int x=1+(i*z);
			if(x%e==0){
				d=x/e;
				break;
			}
		}
		System.out.println("Value of d : "+d);
		c=(Math.pow(msg, e))%n;
		System.out.println("Encrypted msg : "+c);
		BigInteger N = BigInteger.valueOf(n);
		BigInteger C = BigDecimal.valueOf(c).toBigInteger();
		msgback=(C.pow(d)).mod(N);
		System.out.println("Decrypted msg : "+msgback);
	}
	static int gcd(int e, int z){
		if(e==0){
			return z;
		}else{
			return gcd(z%e,e);
		}
	}

}
