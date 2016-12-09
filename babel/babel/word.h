//
//  word.h
//  babel
//
//  Created by Kjartan Kjartansson on 29/11/16.
//  Copyright (c) 2016 k. All rights reserved.
//

#ifndef babel_word_h
#define babel_word_h

#include <string>

using namespace std;

class word
{
public:
    word();
    word(string eng, string bab, word *left, word *right);

    string getEng();
    string getBab();
    word* getLeft();
    word* getRight();

    void putEng(string e);
    void putBab(string b);
    void putLeft(word* l);
    void putRight(word* r);

private:
    string eng;
    string bab;
    word* left;
    word* right;
};

typedef word* WordPtr;

#endif
