//
//  word.cpp
//  babel
//
//  Created by Kjartan Kjartansson on 29/11/16.
//  Copyright (c) 2016 k. All rights reserved.
//


#include "word.h"

using namespace std;

word::word()
{
    eng = "";
    bab = "";
    left = NULL;
    right = NULL;
}

word::word(string e, string b, word* l, word* r)
{
    eng = e;
    bab = b;
    left = l;
    right = r;
}

string word::getEng()
{
    return eng;
}

string word::getBab()
{
    return bab;
}

word* word::getLeft()
{
    return left;
}

word* word::getRight()
{
    return right;
}

void word::putEng(string e)
{
    eng = e;
}

void word::putBab(string b)
{
    bab = b;
}

void word::putLeft(word* l)
{
    left = l;
}

void word::putRight(word* r)
{
    right = r;
}

