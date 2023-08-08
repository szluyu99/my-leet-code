class NumArray {
    int[] preSums;

    public NumArray(int[] nums) {
        preSums = new int[nums.length + 1];
        for (int i = 1; i < preSums.length; i++)
            preSums[i] = preSums[i - 1] + nums[i - 1];
        System.out.println(Arrays.toString(preSums));
    }

    public int sumRange(int left, int right) {
        return preSums[right + 1] - preSums[left];
    }
}