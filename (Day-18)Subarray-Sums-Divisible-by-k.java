class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        
        int prefixSum =0;
        int SubarraySumsDivisiblebyK = 0;
        
        for(int i=0;i<nums.length;i++){
            prefixSum += nums[i];
            int remainder =prefixSum%k;
            if(remainder<0){
                remainder = remainder+k;
            }
            if(map.containsKey(remainder)){
                SubarraySumsDivisiblebyK += map.get(remainder);
            }
            map.put(remainder,map.getOrDefault(remainder,0)+1);
        }
        return SubarraySumsDivisiblebyK;
    }
}
