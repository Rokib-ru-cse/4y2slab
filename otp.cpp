#include<bits/stdc++.h>
using namespace std;
int main(){
    string text = "Hello",otp = "uBV,;",encryp = "",decryp = "";
    for(int i=0;i<text.length();i++){
        encryp+= char(int(text[i])^int(otp[i]));
        decryp+= char(int(otp[i])^int(encryp[i]));
    }
cout<<encryp<<endl;
cout<<decryp<<endl;
    return 0;
}
