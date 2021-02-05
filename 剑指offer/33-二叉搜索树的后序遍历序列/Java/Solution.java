class Solution {
    public boolean verifyPostorder(int[] postorder) {

        if (postorder == null || postorder.length == 0)
            return true;

        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int start, int end) {

        if (end - start <= 0)
            return true;

        int rootVal = postorder[end];
        int curIndex = start;
        while (curIndex < end && postorder[curIndex] <= rootVal)
            curIndex++;

        for (int i = curIndex; i < end; i ++) {
            if (postorder[i] < rootVal)
                return false;
        }
        return verifyPostorder(postorder, start, curIndex - 1) && verifyPostorder(postorder, curIndex, end - 1);
    }
}
