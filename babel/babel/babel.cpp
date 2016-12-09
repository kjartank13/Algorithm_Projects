
#include <iostream>
#include <string>
#include "dictionary.h"

using namespace std;


int main() {
    
    dictionary Dict;
    
    string line;
    
    for (getline(cin, line); line.size() != 0; getline(cin, line))
    {
        //line < english, space, bab >
        string eng = "";
        string bab = "";
        bool space = false;
        
        for (int i = 0; i < line.length(); i++)
        {
            if (line[i] == ' ')
            {
                space = true;
                i++;
            }
            
            if (!space)
                eng += line[i];
            else
                bab += line[i];
        }

        Dict.insert(eng, bab);
    }
    
    string the_word;
    
    for (getline(cin, the_word); the_word.size() != 0; getline(cin, the_word))
    {
        cout << Dict.find(the_word) << endl;
    }
    
//    Dict.~dictionary();
    
    return 0;
}
