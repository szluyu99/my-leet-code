import java.util.Arrays;
import java.util.HashMap;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }
}