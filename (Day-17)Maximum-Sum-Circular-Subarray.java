class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        
        int maximumSum = KadaneMax(nums);
        int minimumSum = KadaneMin(nums);
        int circularSum = totalSum - minimumSum;
        if(maximumSum>0){
            return Math.max(maximumSum , circularSum);
        }
        return maximumSum;
        
    }
    public int KadaneMin(int[] nums){
        int sum =nums[0];
        int minSum =nums[0];
        for(int i=1;i<nums.length;i++){
            sum = Math.min(sum+nums[i] , nums[i]);
             if(sum<minSum){
                 minSum = sum;
           }
        }
        return minSum;
    }
    public int KadaneMax(int[] nums){
        int sum = nums[0];
        int maxSum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum = Math.max(sum+nums[i] , nums[i]);
            if(sum>maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
