#define _CRT_SECURE_NO_WARNINGS 1

#include<cstdio>
#include<cstdlib>
#include<vector>
using namespace std;

//130.��Χ�Ƶ�����
class Solution {
public:
	// row col ��ֹԽ��
	void DFS(vector<vector<char>>& board, int row, int col, int x, int y) {
		static int pos[4][2] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		//���
		board[x][y] = 'Z';
		//����
		for (int i = 0; i < 4; i++) {
			int nx = x + pos[i][0];
			int ny = y + pos[i][1];
			//�Ƿ�Խ��
			if (nx >= row || nx < 0 || ny >= col || ny < 0) {
				continue;
			}
			//�ж��Ƿ�Ϊ'O'
			if (board[nx][ny] == 'O') {
				DFS(board, row, col, nx, ny);
			}
		}
	}
	void solve(vector<vector<char>>& board) {
		//�������б��ϵ� 'O'
		if (board.empty()) {
			return;
		}
		int row = board.size();
		int col = board[0].size();
		//�ڵ�һ�к����һ������'O'
		for (int i = 0; i < col; i++) {
			if (board[0][i] == 'O') {
				DFS(board, row, col, 0, i);
			}
			if (board[row - 1][i] == 'O') {
				DFS(board, row, col, row - 1, i);
			}
		}
		//�ڵ�һ�к����һ������'O'
		for (int i = 0; i < row; i++) {
			if (board[i][0] == 'O') {
				DFS(board, row, col, i, 0);
			}
			if (board[i][col - 1] == 'O') {
				DFS(board, row, col, i, col - 1);
			}
		}
		//�������󣬰����е� Z ��Ϊ X
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