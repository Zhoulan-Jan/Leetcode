#define _CRT_SECURE_NO_WARNINGS 1

#include<cstdio>
#include<cstdlib>
#include<vector>
#include<iostream>
#include<queue>
using namespace std;

//BFS
//�Թ�����

class position
{
public:
	int x;
	int y;
	position(int xx, int yy) {
			x = xx;
			y = yy;
		}
	~position();

private:

};

//position::position(int xx, int yy)
//{
//}

position::~position()
{
}

bool BFS(vector<vector<int>>& grid, int startx, int starty, int endx, int endy) {
	static int pos[4][2] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	int row = grid.size();
	int col = grid[0].size();
	//��� ��֤�������ظ��ĵ㣬������ѭ��
	vector<vector<int>> visit(row, vector<int>(col, 0));
	//��ʼλ�����
	queue<position> q;
	q.push(position(startx,starty));
	visit[startx][starty] = 1; //��ʾ�������õ�
	//����
	while (!q.empty()) {
		//ȡ����Ԫ��
		position curPos = q.front();
		q.pop();
		//����������
		for (int i = 0; i < 4; i++) {
			int nx = curPos.x + pos[i][0];
			int ny = curPos.y + pos[i][1];
			if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
				continue;
			}
			//������յ�������ͬ��˵���ҵ�·����
			if (nx == endx && ny == endy) {
				return true;
			}
			//�����ߵ���δ�߹����ӵ���������
			if (grid[nx][ny] == 0 && visit[nx][ny] == 0) {
				q.push(position(nx, ny));
			}
		}
	}
}

int main() {
	vector<vector<int>> gird = {}
	system("pause");
	return 0;
}

