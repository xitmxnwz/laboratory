package algorithms;

import java.util.Arrays;

public class Other {

	private static int[] numbers= {0,1,3,2,4,5,0,0,0};
	private static int[] numbers2= {-7,-7,-2,-3,-2,-9};
	public static void main(String[] args) {
		System.out.println(maxContainNegative(numbers2,6));
		System.out.println(maxContainNegative(numbers,6));
	}
	
	  
	  public static int maxContainNegative(int a[],int n){
		  	//数列有可能是全为负数的处理方式
	        boolean flag=false;
	        int max=Integer.MIN_VALUE;
	        for (int i = 0; i < n; i++) {
	            if (a[i]>0){
	                flag=true;
	                break;
	            }
	            if (a[i]>max){
	                max=a[i];
	            }
	        }
	        if (!flag){
	            return max;
	        }
	        //数列不是全为负数的处理方式
	        int maxSum = 0;
	        int thisSum = 0;
	        for( int j = 0; j < a.length; j++ )
	        {
	            thisSum += a[ j ];
	            if( thisSum > maxSum )
	                maxSum = thisSum;
	            else if( thisSum < 0 )
	                thisSum = 0;
	        }
	        return maxSum;
	    }

	    
	
}
