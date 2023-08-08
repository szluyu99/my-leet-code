package main

func isStraight(nums []int) bool {
	var set map[int]bool = make(map[int]bool)
	min, max := 14, nums[0]
	for i := 0; i < len(nums); i++ {
		if nums[i] == 0 {
			continue
		}
		if _, ok := set[nums[i]]; ok {
			return false
		}
		set[nums[i]] = true
		if nums[i] < min {
			min = nums[i]
		}
		if nums[i] > max {
			max = nums[i]
		}
	}
	if max-min >= 5 {
		return false
	}
	return true
}
