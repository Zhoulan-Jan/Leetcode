#define _CRT_SECURE_NO_WARNINGS 1

//51.N皇后

#include<cstdio>
#include<cstdlib>
#include<vector>
using namespace std;

class Solution {
public:
	//判断位置是否合法
	bool isValid(vector<pair<int, int>>& solution, int row, int col) {
		//不在同一列，同一斜线
		for (auto& pos : solution) {
			//first表示横坐标，second表示纵坐标
			if (pos.second == col
				|| pos.first + pos.second == row + col
				|| pos.first - pos.second == row - col) {
				return false;
			}
		}
		return true;
	}

	//pair<int, int> C++内部的结构体 
	//solutions放的是坐标集合， solution放的是一次成功皇后的坐标
	void DFS(vector<vector<pair<int, int>>>& solutions,
		vector<pair<int, int>>& solution, int curRow, int n) {
		//所有行的皇后位置已确定，存下这种解决方案 ，然后向前回退
		if (curRow == n) {
			solutions.push_back(solution);
			return;
		}
		//每一行尝试每一列的位置
		for (int i = 0; i < n; i++) {
			//如果位置不冲突，将当前位置保存
			if (isValid(solution, curRow, i)) {
				solution.push_back(make_pair(curRow, i));
				DFS(solutions, solution, curRow + 1, n);
				solution.pop_back();
			}
		}
	}
	vector<vector<string>> solveNQueens(int n) {
		vector<vector<string>> ret;
		vector<vector<pair<int, int>>> solutions;
		vector<pair<int, int>> solution;
		DFS(solutions, solution, 0, n);
		for (auto& e : solutions) {
			vector<string> retStr(n, string(n, '.'));
			for (auto& pos : e) {
				retStr[pos.first][pos.second] = 'Q';
			}
			ret.push_back(retStr);
		}
		return ret;
	}
};