#include <iostream>
#include <vector>
using namespace std;
vector<vector<int>> generate(int numRows) {
    vector<vector<int>> rows;
    rows.push_back({1});
    for (int i = 1; i < numRows; i++) {
        vector<int> row;
        for (int j = 0; j <= i; j++) {
            int s1, s2;
            if (j - 1 < 0)
                s1 = 0;
            else
                s1 = rows[i - 1][j - 1];

            if (j >= rows[i - 1].size())
                s2 = 0;
            else
                s2 = rows[i - 1][j];
            row.push_back(s1 + s2);
        }
        rows.push_back(row);
    }
    return rows;
}
int main() {
    auto a = generate(5);
    for (auto b : a) {
        for (int c : b) {
            cout << c << ' ';
        }
        cout << endl;
    }
}