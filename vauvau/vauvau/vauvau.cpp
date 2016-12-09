#include <iostream>

using namespace std;


void dogCheck(int a, int b, int c, int d, int M) {
    
    
    bool active = true;
    bool one = false;
    bool two = false;
    
    bool loop = true;
    
    int totalOne = a;
    int totalTwo = c;
    
    //loop for dog one
    while (loop) {
        if (active) {
            if (M > (totalOne - a) && M <= totalOne) {
                one = true;
                loop = !loop;
                continue;
            }
            totalOne += b;
        } //end if active
        else {
            if (M > (totalOne - b) && M <= totalOne) {
                loop = !loop;
                continue;
                //one[bool] remains false
            }
            totalOne += a;
        } //end else
        active = !active;
    }
    
    loop = true;
    active = true;
    //loop for dog two
    while (loop) {
        if (active)
        {
            if (M > (totalTwo - c) && M <= totalTwo) {
                two = true;
                loop = !loop;
                continue;
            }
            totalTwo += d;
        } //end if active
        else {
            if (M > (totalTwo - d) && M <= totalTwo) {
                loop = !loop;
                continue;
                //two[bool] remains false;
            }
            totalTwo += c;
        } //end else
        active = !active;
    }
    
    if (one == false && two == true)
        cout << "one" << endl;
    else if (one == true && two == false)
        cout << "one" << endl;
    else if (one == true && two == true)
        cout << "both" << endl;
    else
        cout << "none" << endl;
    
}

int main() {
    
    int a,b,c,d,p,m,g;
    
    cin >> a;
    cin >> b;
    cin >> c;
    cin >> d;
    cin >> p;
    cin >> m;
    cin >> g;
    
    dogCheck(a, b, c, d, p);
    dogCheck(a, b, c, d, m);
    dogCheck(a, b, c, d, g);
    
    
    return 0;
}
