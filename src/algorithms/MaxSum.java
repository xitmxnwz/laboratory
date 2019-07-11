package algorithms;

public class MaxSum {
	public static void main(String[] args) {
		int[] l = {4,-3,5,-2,-1,2,6,-2};
		int max = four(l);
		System.out.println(max);
	}
	
	
	public static int first(int[] a) {
		int maxSum = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				int thisSum = 0;
				for (int k = i; k <= j; k++)
					thisSum += a[k];
				if (thisSum > maxSum)
					maxSum = thisSum;
			}
		}
		return maxSum;
	}
	
	public static int second(int[] a) {
		int maxSum = 0;
		for (int i = 0; i < a.length; i++) {
			int thisSum = 0;
			for (int j = i; j < a.length; j++) {
				thisSum += a[j];
				if (thisSum > maxSum)
					maxSum = thisSum;
			}
		}
		return maxSum;
	}
	
	public static int four(int[] a) {
		int maxSum = 0,thisSum = 0;
		for (int i = 0; i < a.length; i++) {
				thisSum += a[i];
				if (thisSum > maxSum)
					maxSum = thisSum;
				else if(thisSum<0)
					thisSum = 0;
		}
		return maxSum;
	}
	
}
