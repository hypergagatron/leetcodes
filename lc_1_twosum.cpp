
/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
*/

#include <unordered_map>
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> umap;
        vector<int> indicies;

        for (int i = 0; i<nums.size(); i++) {
            if (umap.find(target-nums[i]) != umap.end()) {
                    indicies.push_back(umap[target-nums[i]]);
                    indicies.push_back(i);
                    break;
            } else {
                umap[nums[i]] = i;
            };
        };
        return indicies;
};
};
