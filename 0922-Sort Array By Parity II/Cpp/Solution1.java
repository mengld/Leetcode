//Source:https://leetcode-cn.com/problems/sort-array-by-parity-ii/
//Author:mengld
//Time:  2020-3-23


#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> sortArrayByParityII(vector<int>& A) {
        int i = 0;
        int j = 0;
        while (i < A.size() && j < A.size()) {
            while (i < A.size()) {
                if (A[i] % 2 != 0 && i % 2 == 0)
                    break;
                i++;
            }

            while (j < A.size()) {
                if (A[j] % 2 == 0 && j % 2 != 0)
                    break;
                j++;
            }

            if (i < A.size() && j < A.size())
                swap(A[i], A[j]);
        }
        return A;
    }
};
