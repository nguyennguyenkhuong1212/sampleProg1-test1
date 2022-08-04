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
        double preLocation = locations[0];
        for (int i = 1; i < locations.length; i++){
            if (locations[i] - preLocation < min && !Protected[i]) return false;
            if (!Protected[i]) preLocation = locations[i];
        }
        return true;
    }

    public static void main(String[] args) {
        // method 1
        System.out.println(canFollowRule(9, 6, 2));
        System.out.println(canFollowRule(10.0, 6, 2.0));
        System.out.println(canFollowRule(10.0, 7, 2.0));
        System.out.println(canFollowRule(10.0, 6, 2.5));
        System.out.println(canFollowRule(0.1, 1, 0.0001));

        // method 2
        System.out.println(isFollowingRule(new double[]{2, 3, 4, 5, 7, 9}, 2.021));
        System.out.println(isFollowingRule(new double[]{0.0, 2.1, 4.5, 10.0}, 2.0));
        System.out.println(isFollowingRule(new double[]{0.0, 1.5, 4.5, 10.0}, 2.0));
        System.out.println(isFollowingRule(new double[]{-10.0, -7.5, 0.0}, 2.4));

        // method 3
        System.out.println(isFollowingRealRule(new double[]{2, 3, 4, 5, 7, 9}, new boolean[]{true, false, true, false, false, false}, 3.21));
        System.out.println(isFollowingRealRule(new double[]{0.0, 1.5, 4.5, 10.0}, new boolean[]{false, true, false, false}, 2.0));
        System.out.println(isFollowingRealRule(new double[]{0.0, 1.5, 1.9, 10.0}, new boolean[]{false, true, false, false}, 2.0));
        System.out.println(isFollowingRealRule(new double[]{0.0, 0.5, 1.0, 1.5, 2.1}, new boolean[]{false, true, true, true, false}, 2.0));
    }
}
