package mian;

import java.util.Scanner;

public class Main {
	
	static double LING = 0.000001;
	static boolean flag = false; 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num[]=new int[4];
		
		
		num[0]=scanner.nextInt();
		num[1]=scanner.nextInt();
		num[2]=scanner.nextInt();
		num[3]=scanner.nextInt();
		scanner.close();
		//Ö»ÓÐ¼Ó¼õ
		find(num);
		if(flag){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
	}
	
	public static void find(int num[]){
		int aa[] = new int[2];
		
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(j==i){
					continue;
				}else{
					int z=0;
					for(int k=0;k<4;k++){
						if(k!=i&&k!=j){
							aa[z]=k;
							z++;
						}
					}
					X(num[i]+num[j],num[aa[0]],num[aa[1]]);
					X(num[i]-num[j],num[aa[0]],num[aa[1]]);
					X(num[i]*num[j],num[aa[0]],num[aa[1]]);
					X(num[j]-num[i],num[aa[0]],num[aa[1]]);
					X(((double)num[i]/num[j]),num[aa[0]],num[aa[1]]);
					X(((double)num[j]/num[i]),num[aa[0]],num[aa[1]]);
				}
			}
		}
	}
	public static void X(double a,double b,double c){
		X(a+b,c);
		X(a-b,c);
		X(a*b,c);
		X(b-a,c);
		X(a/b,c);
		X(b/a,c);
		
		X(a+c,b);
		X(a-c,b);
		X(a*c,b);
		X(c-a,b);
		X(a/c,b);
		X(c/a,b);
	}
	public static void X(double a,double b){
		if(Math.abs(a+b-24)<LING){
			flag=true;
		}else if(Math.abs(a-b-24)<LING){
			flag=true;
		}else if(Math.abs(b-a-24)<LING){
			flag=true;
		}else if(Math.abs(a*b-24)<LING){
			flag=true;
		}else if(Math.abs(a/b-24)<LING){
			flag=true;
		}else if(Math.abs(b/a-24)<LING){
			flag=true;
		}
	}
}