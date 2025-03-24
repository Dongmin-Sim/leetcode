class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];

        // booking을 이용해서 차분 배열 구하기
        for (int[] booking : bookings) {

            int start = booking[0] - 1;
            int end = booking[1];
            int seats = booking[2];

            result[start] += seats;
            if (end< n) {
                result[end] -= seats;
            }
        }

        // 누적합으로 결과 구하기
        for (int i = 1; i < n; i++) {
            result[i] += result[i - 1];
        }

        return result;
    }
}