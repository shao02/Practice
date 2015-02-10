public class Solution {
    public int maxSubArray(int[] A) {
        if(A==null || A.length == 0)
        	return 0;
        int sum=A[0];
        int max=A[0];
        for(int i=1;i<A.length;i++){
        	if((sum+A[i]) > A[i]){
        		sum+=A[i];
        	}
        	else{
        		sum=A[i];
        	}
        	if(sum>max)
        		max=sum;
        }

        return max;
    }

    public int removeDuplicates(int[] A) {
        if(A == null || A.length ==0)
            return 0;
            
        int i=1; j=1;
        int cnt=1;
        while(j<A.length){
        	if(A[j]!=A[j-1]){
        		cnt=1;
        		A[i++]=A[j];
        	}
        	else{
        		if(cnt<2){
        			A[i++]=A[j];
        			cnt++;
        		}
        	}
        	j++;
        }
       	return i; 
    }

    public int maxProduct(int[] A) {
    	if(A==null || A.length == 0)
    		return -1;
    	int prod = A[0];
    	int max = A[0];

    	for(int i=1; i< A.length; i++){
    		if(A[i]*prod>A[i]){
    			prod=A[i]*prod;
    		}else{
    			prod=A[i];
    		}
    		if(prod > max){
    			max=prod;
    		}
    	}
    	return max;
    }
}