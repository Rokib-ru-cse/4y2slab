#include<bits/stdc++.h>
using namespace std;
int main(){
    string text = "ABCDEF",otp = "UVWXYZ",encryp = "",decryp = "";

    for(int i=0;i<text.length();i++){
        encryp+= ((int(text[i])-65)+(int(otp[i])-65))>26?char((int(text[i])-65)+(int(otp[i])-65)%26):char((int(text[i])-65)+(int(otp[i])-65));
    }
    for(int i=0;i<text.length();i++){
            //decryp+= char((int(encryp[i])-65)+(int(otp[i])-65));
    }

    cout<<encryp<<endl;
    cout<<decryp<<endl;
    return 0;
}

