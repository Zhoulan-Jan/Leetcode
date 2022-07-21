#define _CRT_SECURE_NO_WARNINGS 1

#include<cstdio>
#include<cstdlib>
#include<vector>
using namespace std;

//130.被围绕的区域
class Solution {
public:
	// row col 防止越界
	void DFS(vector<vector<char>>& board, int row, int col, int x, int y) {
		static int pos[4][2] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		//标记
		board[x][y] = 'Z';
		//搜索
		for (int i = 0; i < 4; i++) {
			int nx = x + pos[i][0];
			int ny = y + pos[i][1];
			//是否越界
			if (nx >= row || nx < 0 || ny >= col || ny < 0) {
				continue;
			}
			//判断是否为'O'
			if (board[nx][ny] == 'O') {
				DFS(board, row, col, nx, ny);
			}
		}
	}
	void solve(vector<vector<char>>& board) {
		//搜索所有边上的 'O'
		if (board.empty()) {
			return;
		}
		int row = board.size();
		int col = board[0].size();
		//在第一行和最后一行搜索'O'
		for (int i = 0; i < col; i++) {
			if (board[0][i] == 'O') {
				DFS(board, row, col, 0, i);
			}
			if (board[row - 1][i] == 'O') {
				DFS(board, row, col, row - 1, i);
			}
		}
		//在第一列和最后一列搜索'O'
		for (int i = 0; i < row; i++) {
			if (board[i][0] == 'O') {
				DFS(board, row, col, i, 0);
			}
			if (board[i][col - 1] == 'O') {
				DFS(board, row, col, i, col - 1);
			}
		}
		//遍历矩阵，把所有的 Z 改为 X
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == 'Z') {
					board[i][j] = 'O';
				}
				else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
	}
};

int main() {
	system("pause");
	return 0;
}