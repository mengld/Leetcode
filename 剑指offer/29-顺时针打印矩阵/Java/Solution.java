class Solution {
    public int[] spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int[0];

        int[] array = new int[matrix.length * matrix[0].length];

        int k = 0;

        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;

        while (r1 <= r2 && c1 <= c2) {
            //上
            for (int i = c1; i <= c2; i ++) {
                array[k++] = matrix[r1][i];
            }

            //右
            for (int i = r1 + 1; i <= r2; i ++) {
                array[k++] = matrix[i][c2];
            }

            //下
            if (r1 != r2) {
                for (int i = c2 - 1; i >= c1; i --) {
                    array[k++] = matrix[r2][i];
                }
            }

            //左
            if (c1 != c2) {
                for (int i = r2 - 1; i > r1; i --) {
                    array[k++] = matrix[i][c1];
                }
            }

            r1++; r2--; c1++; c2--;

        }


        return array;
    }
}
