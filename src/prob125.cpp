#include <iostream>
#include <string>
using namespace std;

bool isPalindrome(string s) {
    size_t first = 0;
    size_t last = s.size() - 1;
    while (first < last) {
        if (!isalnum(s[first]))
            first++;
        else if (!isalnum(s[last]))
            last--;
        else if (tolower(s[first]) == tolower(s[last])) {
            first++;
            last--;
        } else
            return false;
    }
    return true;
}
int main() {
    cout << isPalindrome("A man, a plan, a canal: Panama") << endl;
}