/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var maxUncrossedLines = function (nums1, nums2) {
    const [n, m] = [nums1.length, nums2.length];
    let dp = new Array(n + 1).fill(0).map((x) => new Array(m + 1).fill(0));
    for (let i = 1; i <= n; i++)
        for (let j = 1; j <= m; j++)
			if (nums1[i - 1] === nums2[j - 1])
				dp[i][j] = dp[i - 1][j - 1] + 1;
			else
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
    return dp[n][m];
};