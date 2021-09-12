#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>
using namespace std;

vector<char> getPossibleCharacters(char i) {
    vector<char> v;
    switch (i) {
        case '7':
            v.push_back('p');
            v.push_back('q');
            v.push_back('r');
            v.push_back('s');

            break;
        case '8':
            v.push_back('t');
            v.push_back('u');
            v.push_back('v');
            break;
        case '9':
            v.push_back('w');
            v.push_back('x');
            v.push_back('y');
            v.push_back('z');
            break;
        default:
            i -= '2';
            for (char c = 'a' + 3 * i; c < 'a' + 3 * i + 3; c++) {
                v.push_back(c);
            }
    }

    return v;
}
vector<string> letterCombinations(string digits) {
    if (digits.empty()) {
        vector<string> v;
        return v;
    }
    vector<string> prev = letterCombinations(digits.substr(1, digits.size()));
    if(prev.empty()) {
        prev.push_back("");
    }
    vector<char> possible = getPossibleCharacters(digits[0]);
    vector<string> v;
    for (string p : prev) {
        for (char i : possible) {
            string copy(p);
            copy.insert(copy.begin(), i);
            v.push_back(copy);
        }
    }
    return v;
}

int main() {
    cout << "hello world" << endl;
    auto a = letterCombinations("");
    for (string s : a) {
        cout << s << endl;
    }
}
