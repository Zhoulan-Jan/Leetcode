#define _CRT_SECURE_NO_WARNINGS 1

#include<cstdio>
#include<cstdlib>
#include<vector>
#include<iostream>
#include<queue>
using namespace std;

//BFS
//迷宫问题

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
	//起始位置入队
	queue<position> q;
	q.push(position(startx,starty));
	//搜索
	while (!q.empty()) {
		//取队首元素
		position curPos = q.front();
		q.pop();
		//向四周搜索
		for (int i = 0; i < 4; i++) {
			int nx = curPos.x + pos[i][0];
			int ny = curPos.y + pos[i][1];
			if (nx < 0 || nx >= row || ny < 0 || ny > col) {
			}
		}
}
