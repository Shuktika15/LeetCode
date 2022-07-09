package first_bad_version;

class VersionControl {
    private int badVersion;

    public void setBadVersion(int badVersion) {
        this.badVersion = badVersion;
    }

    public boolean isBadVersion(int num) {
        return num >= badVersion;
    }
}

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        int low = 1;
        int high = n;

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return ans;
    }
}