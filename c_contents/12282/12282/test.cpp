#define _CRT_SECURE_NO_WARNINGS 1

//39.组合总和
//回溯 + dfs
#include<cstdio>
#include<cstdlib>
#include<vector>
using namespace std;

class Solution {
public:
	void DFS(vector<int>& candidates, int target, int curSum, 
		vector<int>& solution, vector<vector<int>>& solutions, int pos) {
		if (curSum >= target) {
			if (curSum == target) {
				solutions.push_back(solution);
			}
			return;
		}
		for (int i = pos; i < candidates.size(); i++) {
			solution.push_back(candidates[i]);
			DFS(candidates, target, curSum + candidates[i], solution, solutions, i);
			solution.pop_back();
		}
	}

	vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
		vector<vector<int>> solutions;
		vector<int> solution;
		if (candidates.empty()) {
			return solutions;
		}
		DFS(candidates, target, 0, solution, solutions, 0);
		return solutions;
	}
};