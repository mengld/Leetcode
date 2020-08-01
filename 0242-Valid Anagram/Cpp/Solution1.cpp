//Source: https://leetcode-cn.com/problems/valid-anagram/
//Author: mengld
//Time:   2020-3-22


#include <iostream>
#include <string>
#include <algorithm>
#include <ctime>
using namespace std;

class Solution {
public:

    void insertionSort(string& s, int l, int r) {
        for (int i = l+1; i <= r; i++) {
            char temp = s[i];
            int j;
            for (j = i; j > 0 && temp < s[j-1]; j--) {
                    s[j] = s[j - 1];
            }
            s[j] = temp;
        }
    }

    void __quickSort3Ways(string& arr, int l, int r) {

        if (r - l <= 15) {
            insertionSort(arr, l, r);
            return;
        }

        swap(arr[l], arr[rand() % (r - l + 1) + l]);

        char v = arr[l];

        int lt = l;     // arr[l+1...lt] < v
        int gt = r + 1; // arr[gt...r] > v
        int i = l + 1;    // arr[lt+1...i) == v
        while (i < gt) {
            if (arr[i] < v) {
                swap(arr[i], arr[lt + 1]);
                i++;
                lt++;
            }
            else if (arr[i] > v) {
                swap(arr[i], arr[gt - 1]);
                gt--;
            }
            else { // arr[i] == v
                i++;
            }
        }

        swap(arr[l], arr[lt]);

        __quickSort3Ways(arr, l, lt - 1);
        __quickSort3Ways(arr, gt, r);
    }

    void quickSort3Ways(string& arr, int n) {

        srand(time(NULL));
        __quickSort3Ways(arr, 0, n - 1);
    }


    bool isAnagram(string s, string t) {
        
        quickSort3Ways(s, s.length());
        quickSort3Ways(t, t.length());
        if (s == t)
            return true;
        else
            return false;
    }

};
