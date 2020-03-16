#define _CRT_SECURE_NO_WARNINGS 1

//127.���ʽ���

#include<cstdio>
#include<cstdlib>
#include<vector>
#include<queue>
#include<unordered_set>
using namespace std;

class Solution {
public:
	int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
		//���ֵ��ù�ϣ���ʾ���������
		unordered_set<string> wdict;
		for (auto& e : wordList) {
			wdict.insert(e);
		}
		//���endWord�����ֵ����� ֱ�ӷ���0
		if (wdict.find(endWord) == wdict.end()) {
			return 0;
		}
		int minLen = 1;
		queue<string> q;
		q.push(beginWord);
		//��ǣ�
		unordered_set<string> book;
		book.insert(beginWord);
		while (!q.empty()) {
			//��ȡһ��ת�������е���
			int sz = q.size();
			while (sz--) {
				string curWord = q.front();
				q.pop();
				//����ÿһ������һ��ת���Ľ�� ������curWord.size() * 26
				for (int i = 0; i < curWord.size(); i++) {
					string tmpWord = curWord;
					//���б任
					for (char j = 'a'; j <= 'z'; j++) {
						tmpWord[i] = j;
						if (tmpWord == endWord) {
							return minLen + 1;
						}
						//������ֵ�������û�з��ʹ�
						if (book.find(tmpWord) == book.end() ||
							wdict.find(tmpWord) != wdict.end()) {
							q.push(tmpWord);
							book.insert(tmpWord);
						}
					}
				}	
			}
			minLen++;
		}
		return 0;
	}
};

