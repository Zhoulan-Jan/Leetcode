#define _CRT_SECURE_NO_WARNINGS 1

//51.N�ʺ�

#include<cstdio>
#include<cstdlib>
#include<vector>
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
			vector<string> retStr(n, string(n, '.'));
			for (auto& pos : e) {
				retStr[pos.first][pos.second] = 'Q';
			}
			ret.push_back(retStr);
		}
		return ret;
	}
};