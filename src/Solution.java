import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */

    static public void main(String[] args){

        Solution s = new Solution();
        int [] nums = {1,1,2};
        System.out.println(s.permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        List<Integer> permutations = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null){
            return result;
        }
        if(nums.length == 0){
            result.add(permutations);
            return result;
        }
        helper(nums,visited,permutations,result);
        return result;
    }

    private void helper(int[] nums, int [] visited, List<Integer> permutations, List<List<Integer>> result){

        if(permutations.size() == nums.length){
            result.add(new ArrayList<>(permutations));
            return;
        }
        for(int i = 0 ; i < nums.length; i++){

            if(visited[i] == 1){
                continue;
            }
            if(i != 0 && nums[i-1] == nums[i] && visited[i-1] == 0){
                continue;
            }

            permutations.add(nums[i]);
            visited[i] = 1;
            helper(nums,visited,permutations,result);
            permutations.remove(permutations.size()-1);
            visited[i] = 0;
        }
    }
};