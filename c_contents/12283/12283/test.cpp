#define _CRT_SECURE_NO_WARNINGS 1

//51.N�ʺ�

#include<cstdio>
#include<cstdlib>
#include<vector>
#include<string>
#include<iostream>
#include<ctime>
using namespace std;

class Solution {
public:
	//�ж�λ���Ƿ�Ϸ�
	bool isValid(vector<pair<int, int>>& solution, int row, int col) {
		//����ͬһ�У�ͬһб��
		for (auto& pos : solution) {
			//first��ʾ�����꣬second��ʾ������
			if (pos.second == col
				|| pos.first + pos.second == row + col
				|| pos.first - pos.second == row - col) {
				return false;
			}
		}
		return true;
	}

	//pair<int, int> C++�ڲ��Ľṹ�� 
	//solutions�ŵ������꼯�ϣ� solution�ŵ���һ�γɹ��ʺ������
	void DFS(vector<vector<pair<int, int>>>& solutions,
		vector<pair<int, int>>& solution, int curRow, int n) {
		//�����еĻʺ�λ����ȷ�����������ֽ������ ��Ȼ����ǰ����
		if (curRow == n) {
			solutions.push_back(solution);
			return;
		}
		//ÿһ�г���ÿһ�е�λ��
		for (int i = 0; i < n; i++) {
			//���λ�ò���ͻ������ǰλ�ñ���
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
			vector<string> retStr(n, string(n, '#'));
			for (auto& pos : e) {
				retStr[pos.first][pos.second] = 'Q';
			}
			ret.push_back(retStr);
		}
		return ret;
	}
};

int main() {
	clock_t run_start = clock();
	Solution s;
	vector<vector<string>> res = s.solveNQueens(8);
	for (int i = 0; i < res.size(); i++) {
		for (int j = 0; j < res[i].size(); j++) {
			cout << res[i][j] << endl;
		}
		cout << endl;
	}
	clock_t run_end = clock();
	double runtime = ((double)run_end - (double)run_start) / CLOCKS_PER_SEC;
	printf("Run Time: %.3f s \n", runtime);
	system("pause");
	return 0;
}