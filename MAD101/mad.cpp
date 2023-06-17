#include<bits/stdc++.h>
#define pb push_back
#define ft first
#define sc second
#define sqr(x) ((x)*(x))
using namespace std;
typedef int64_t ll;
typedef pair<int,int> pii;
typedef vector<int> vi;
typedef vector<vector<int>> vii;

int gcd(int a, int b) {
    cout<<a<<' '<<b<<endl;
    return a%b==0 ? b : gcd(b, a%b);
}

int pow(int a, int n, int m) {
    if(n==1) return a%m;
    ll tmp = pow(a, n/2, m);
    tmp = sqr(tmp) % m;
    if(n%2) return tmp * a % m;
    return tmp;
}

vi mergesort(vi &array, int left, int right) {
    if(right-left == 1) return {array[left]};

    int mid = (left + right) / 2;
    int l_index = 0, r_index = 0;
    vi l_array = mergesort(array, left, mid);
    vi r_array = mergesort(array, mid, right);

    vi ret(right-left);
    for(int &i: ret) {
        if(l_index == l_array.size()) i = r_array[r_index++];
        else if(r_index == r_array.size()) i = l_array[l_index++]; 
        else if(l_array[l_index] < r_array[r_index]) i = l_array[l_index++];
        else i = r_array[r_index++];
    }
    return ret;
}

int main() {
    gcd(1982, 1872);
    // cout<<pow(2, 10, 5)<<endl;
    // vi a = {1,2,4,7,2,345,1,5,1,5,5643,2,3,5,1,5};
    // a = mergesort(a, 0, a.size());
    // for (int i: a) cout<<i<<' ';
    // cout<<endl;
}