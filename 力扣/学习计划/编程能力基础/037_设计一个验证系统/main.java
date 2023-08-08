import java.util.Map;

/**
 * https://leetcode-cn.com/problems/design-authentication-manager/
 * 1797. 设计一个验证系统
 */
class AuthenticationManager {
    int timeToLive; // 过期时间
    Map<String, Integer> map; // 验证码与其过期时间

    public AuthenticationManager(int timeToLive) {
        this.map = new HashMap<>();
        this.timeToLive = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + this.timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
        // 没有这个验证码、验证码已经过期, 或者正好过期
        if (!map.containsKey(tokenId) || map.get(tokenId) <= currentTime) return;
        map.put(tokenId, currentTime + this.timeToLive);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() > currentTime) count++;
        }
        return count;
    }
}