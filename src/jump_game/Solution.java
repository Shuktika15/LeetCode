package jump_game;

class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            boolean check = true;
            if (nums[i] == 0) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] + j > i) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    return false;
                }
            }
        }
        return true;
    }
}
