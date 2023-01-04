class Solution {
    public int minimumRounds(int[] tasks) {
        int rounds=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(Integer task:tasks){
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        
        for(Map.Entry<Integer,Integer> counts : map.entrySet()){ // here counts represent the frequency of tasks appear in array
            int frequency = counts.getValue();
            
            if(frequency==1){
                return -1;
            }
            if(frequency %3 != 0){
                rounds += frequency/3 + 1;
            }
            if(frequency %3 == 0){
                rounds += frequency/3;
            }
        }
        return rounds;
    }
}
