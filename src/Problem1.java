import java.lang.Integer.*;

public class Problem1 {
    public static boolean canFollowRule(double length, int n, double min){
        int possibleSlot = (int) (Math.floor(length/min) + 1);
        return (possibleSlot >= n);
    }

    public static boolean isFollowingRule(double[] locations, double min){
        for (int i = 0; i < locations.length - 1; i++){
            if (locations[i+1] - locations[i] < min) return false;
        }
        return true;
    }

    public static boolean isFollowingRealRule(double[] locations, boolean[] Protected, double min){
        for (int i = 0; i < locations.length - 1; i++){
            if (locations[i+1] - locations[i] < min && !Protected[i+1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canFollowRule(9, 6, 2));
        System.out.println(isFollowingRule(new double[]{2, 3, 4, 5, 7, 9}, 2.021));
        System.out.println(isFollowingRealRule(new double[]{2, 3, 4, 5, 7, 9}, new boolean[]{true, false, true, false, false, false}, 3.21));
    }
}
