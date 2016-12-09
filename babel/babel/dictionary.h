//
//  dictionary.h
//  babel
//
//  Created by Kjartan Kjartansson on 29/11/16.
//  Copyright (c) 2016 k. All rights reserved.
//

#ifndef babel_dictionary_h
#define babel_dictionary_h

#include <string>
#include "word.h"

using namespace std;

class dictionary
{
public:
    dictionary();
    ~dictionary();
    
    void insert(string eng, string bab);
    string find(string bab);
    
private:
    WordPtr root;
    
};

#endif
