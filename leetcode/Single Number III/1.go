func singleNumber(nums []int) []int {
	m := make(map[int]int)
	for _, num := range nums {
		m[num]++
	}

	result := []int{}
	for num, count := range m {
		if count == 1 {
			result = append(result, num)
		}
		if len(result) == 2 {
			break
		}
	}
	return result
}