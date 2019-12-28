#define _CRT_SECURE_NO_WARNINGS 1

//127.单词接龙

#include<cstdio>
#include<cstdlib>
#include<vector>
#include<queue>
#include<unordered_set>
using namespace std;

class Solution {
public:
	int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
		//把字典用哈希表表示，方便查找
		unordered_set<string> wdict;
		for (auto& e : wordList) {
			wdict.insert(e);
		}
		//如果endWord不在字典序中 直接返回0
		if (wdict.find(endWord) == wdict.end()) {
			return 0;
		}
		int minLen = 1;
		queue<string> q;
		q.push(beginWord);
		//标记？
		unordered_set<string> book;
		book.insert(beginWord);
		while (!q.empty()) {
			//获取一次转换的所有单词
			int sz = q.size();
			while (sz--) {
				string curWord = q.front();
				q.pop();
				//对于每一个单词一次转换的结果 次数：curWord.size() * 26
				for (int i = 0; i < curWord.size(); i++) {
					string tmpWord = curWord;
					//进行变换
					for (char j = 'a'; j <= 'z'; j++) {
						tmpWord[i] = j;
						if (tmpWord == endWord) {
							return minLen + 1;
						}
						//如果在字典里面且没有访问过
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

