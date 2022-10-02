package strings;

public class FrogMinJumps {

    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};

        System.out.println(minJumps(arr));
    }

    static int minJumps(int[] arr) {
        int n = arr.length;
        if (arr[0] == 0)
            return -1;
        int jumps = 1, leftSteps = arr[0], canReachUpto = arr[0];
        for (int i = 0; i < n; i++) {
            if (i > canReachUpto)
                return -1;
            canReachUpto = Math.max(canReachUpto, i + arr[i]);
            if (canReachUpto >= n - 1) {
                if(leftSteps == 0)
                    return jumps + 2;
                else
                    return jumps + 1;
            }
            if (leftSteps == 0) {
                jumps++;
                leftSteps = canReachUpto - i;
            } else
                leftSteps--;
        }
        return -1;
    }
}
