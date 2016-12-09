//
//  dictionary.cpp
//  babel
//
//  Created by Kjartan Kjartansson on 29/11/16.
//  Copyright (c) 2016 k. All rights reserved.
//


/*
 dictionary();
 
 void insert(string eng, string bab);
 void find(string bab);
 */


#include "dictionary.h"
#include <string>
#include <iostream>

using namespace std;

dictionary::dictionary()
{
    root = NULL;
}

dictionary::~dictionary()
{
    delete root;
}

void dictionary::insert(string eng, string bab)
{
    WordPtr newWord = new word;
    newWord->putEng(eng);
    newWord->putBab(bab);
    newWord->putLeft(NULL);
    newWord->putRight(NULL);
    
    
    if (root == NULL)
    {
        root = newWord;
        return;
    }
    
    WordPtr curr = root;
    
    while (true)
    {
        if (newWord->getBab().compare(curr->getBab()) < 0)
        {
            if (curr->getLeft() != NULL)
            {
                curr = curr->getLeft();
            }
            else
            {
                curr->putLeft(newWord);
                return;
            }
        }
        else
        {
            if (curr->getRight() != NULL)
            {
                curr = curr->getRight();
            }
            else
            {
                curr->putRight(newWord);
                return;
            }
        }
    }
    
}

string dictionary::find(string bab)
{
    WordPtr curr = root;
    
    while (curr != NULL)
    {
        if (bab.compare(curr->getBab()) < 0)
        {
            curr = curr->getLeft();
        }
        else if (bab.compare(curr->getBab()) > 0)
        {
            curr = curr->getRight();
        }
        else
        {
            return curr->getEng();
        }
    }
    
    return "eh";
}








