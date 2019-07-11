package algorithms;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NumberSort {
	//私有构造方法，禁止实例化  
    private NumberSort() {   
        super();   
    }    
    
//    private static int[] numbers= {1,5,3,2,7};
    private static int[] numbers= {0,1,3,2,4,5,0,0,0};
    private static int[] numbers2= {6,1,3,2,4,5,9,8,7};
    public static void main(String[] args) {
    	System.out.println(Arrays.toString(numbers));
    	bucketSort(numbers, 5);
    	System.out.println(Arrays.toString(numbers));
    	
    	System.out.println("=======================");
    	System.out.println(Arrays.toString(numbers2));
    	int[] newNum=superBucketSort(numbers2, 9);
    	System.out.println(Arrays.toString(newNum));
	}
    
    
    public static void perDown(int[] a) {
    	int s=5;
    	int hole=1,child;
    	for(;(child=hole*2)<=s;hole=child) {
    		if(child!=s&&a[child+1]<a[child])
    			child++;
    		a[hole]=a[child];
    	}
    	a[hole]=a[s];
    }
    //桶排序
    public static void bucketSort(int[] nums, int maxNum){
    	System.out.println("桶排序");
        int[] sorted = new int[maxNum+1];

        for(int i=0; i<nums.length; i++){
            sorted[nums[i]]++;
        }
        int k=0;
        for (int i = 0; i < sorted.length; i++)
	        for(int j=0;j<sorted[i];j++)
	        	nums[k++]=i;
        
    }
    
    //超级桶排序，除了满足桶的基本要求，还得满足，没有重复的数据
    public static int[] superBucketSort(int[] nums, int maxNum){
    	System.out.println("超级桶排序");
        int[] sorted = new int[maxNum];
        for(int i=0; i<nums.length; i++){
            sorted[nums[i]-1] = nums[i];//把数据放到对应索引的位置
        }
        return sorted;
    }
    
    
    
    //插入排序（直接插入排序）  
    // @param numbers  
    public static void insertSort(int[] numbers) {   
        int size = numbers.length, temp, j;   
        for (int i = 1; i < size; i++) {   
            temp = numbers[i];   
            for (j = i; j > 0 && temp > numbers[j - 1]; j--) {
            	numbers[j] = numbers[j - 1];   
            }
            numbers[j] = temp;   
        }   
    } 
    
    //选择排序 
    public static void selectSort(int[] numbers) {   
        int size = numbers.length, temp;   
        for (int i = 0; i < size; i++) {   
            int k = i,j;   
            for (j = i+1; j < size; j++) {   
            	if(numbers[j] < numbers[k])
                    k = j;   
            } 
            if(k!=i) {
            	temp = numbers[i];   
            	numbers[i] = numbers[k];   
            	numbers[k] = temp;   
            }
        }   
    }
    //冒泡法排序 
    public static void bubbleSort(int[] numbers) {   
        int temp; // 记录临时中间值   
        int size = numbers.length; // 数组大小   
        for (int i = 0; i < size - 1; i++) {   
            for (int j = i + 1; j < size; j++) {   
                if (numbers[i] > numbers[j]) { // 交换两数的位置   
                    temp = numbers[i];   
                    numbers[i] = numbers[j];   
                    numbers[j] = temp;   
                }   
            }   
        }   
    }
    
 
    //希尔排序
    public static void shellSort(int[] ins){
		int n = ins.length,temp,i,j;
		for(int k=n/2;k > 0;k/= 2){
			for(i = k; i < n; i++){
				temp = ins[i];
				for(j=i;j>=k && temp > ins[j-k] ;j-=k)
					ins[j]=ins[j-k];
				ins[j]=temp;
			}
		}
	}
    //快速排序
    public static void quickSort(int[]a,int start,int end){
        if(start<end){
            int baseNum=a[2];//选基准值
            int midNum;//记录中间值
            int i=start;
            int j=end;
            do{
            	while((a[j]>baseNum)&&j>start){
            		j--;
            	}
                while((a[i]<baseNum)&&i<end){
                    i++;
                }
                if(i<=j){
                    midNum=a[i];
                    a[i]=a[j];
                    a[j]=midNum;
                    i++;
                    j--;
                }
                System.out.println(i);
                System.out.println(j);
            }while(i<=j);
//             if(start<j){
//                 quickSort(a,start,j);
//             }       
//             if(end>i){
//                 quickSort(a,i,end);
//             }
        }
    }  

    
    public static void quickSort2(int[]a,int start,int end){
        if(start<end){
//        	a[0]=a[start];
        	int temp;
        	int i=start,j=end;
        	int k=start;
            int baseNum=a[start];//选基准值
            System.out.println("-------------------");
            System.out.println(Arrays.toString(a));
            while(start<end) {
            	
           
            	while((a[end]>=baseNum)&&end>start){
            		end--;
            	}
            	temp=a[end];
            	a[end]=baseNum;
            	a[start]=temp;
            	k=end;
                while((a[start]<=baseNum)&&start<end){
                    start++;
                }
                temp=a[start];
            	a[start]=a[k];
            	a[k]=temp;
//            	k=start;
            }
            System.out.println(i);
            System.out.println(j);
            System.out.println(k);
            System.out.println(Arrays.toString(a));
            if(i<k) {
            	quickSort2(a,i,k-1);
            }
            if(j>k) {
            	System.out.println(Arrays.toString(a));
            	quickSort2(a,k+1,j);
            }
        }
    }  
    
    
    private static void QuickSort(int[] array,int start,int end)
    {
        if(start<end)
        {
            int key=array[start];//初始化保存基元
            int i=start,j;//初始化i,j
            for(j=start+1;j<=end;j++)
            {
                if(array[j]<key)//如果此处元素小于基元，则把此元素和i+1处元素交换，并将i加1，如大于或等于基元则继续循环
                {
                    int temp=array[j];
                    array[j]=array[i+1];
                    array[i+1]=temp;
                    i++;
                }
                
            }
            array[start]=array[i];//交换i处元素和基元
            array[i]=key;
            QuickSort(array, start, i-1);//递归调用
            QuickSort(array, i+1, end);
            
        }
        
    }
    
    //归并排序  
    public static void mergeSort(int[] numbers, int left, int right) {   
        int t = 1;// 每组元素个数   
        int size = right - left + 1;   
        while (t < size) {   
            int s = t;// 本次循环每组元素个数   
            t = 2 * s;   
            int i = left;   
            while (i + (t - 1) < size) {   
                merge(numbers, i, i + (s - 1), i + (t - 1));   
                i += t;   
            }   
            if (i + (s - 1) < right)   
                merge(numbers, i, i + (s - 1), right);   
        }   
    }    
    //归并算法实现  
    private static void merge(int[] data, int p, int q, int r) {   
        int[] B = new int[data.length];   
        int s = p;   
        int t = q + 1;   
        int k = p;   
        while (s <= q && t <= r) {   
            if (data[s] <= data[t]) {   
                B[k] = data[s];   
                s++;   
            } else {   
                B[k] = data[t];   
                t++;   
            }   
            k++;   
        }   
        if (s == q + 1)   
            B[k++] = data[t++];   
        else  
            B[k++] = data[s++];   
        for (int i = p; i <= r; i++)   
            data[i] = B[i];   
    }   
    
    
    
    public static void MaxHeapify(int[] a,int index,int size){
 	   int l=2*index;
 	   int r=2*index+1;
 	   int largest=index;
 	   if(l<=size && a[l]>a[index]){
 		   largest=l;
 	   }
 	   if(r<=size && a[r]>a[largest]){
 		   largest=r;
 	   }
 	   if(largest!=index){
 		   int temp=a[largest];
 		   a[largest]=a[index];
 		   a[index]=temp;
 		   MaxHeapify(a,largest,size);
 	   }
    }
    public static void HeapBuild(int[] a,int size){
 	   for(int i=size/2;i>=1;i--){
 		   MaxHeapify(a,i,size);
 	   }
    }
    public static void heapSort(int[] a,int size){
 	   HeapBuild(a,size);
 	   for(int i=size;i>=2;i--){
 		   int temp=a[i];
 		   a[i]=a[1];
 		   a[1]=temp;
 		   MaxHeapify(a,1,i-1);
 	   }
    }

}
