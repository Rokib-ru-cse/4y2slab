#include<bits/stdc++.h>
using namespace std;
int main(){
    string text = "ATTACKATONCE";
    int s = 4;
    string result = "";
    for(int i=0;i<text.length();i++){
        if(isupper(text[i])){
            result += char(int(text[i]+s-65)%26 +65);
        }else{
            result += char(int(text[i]+s-97)%26 +97);
        }
    }
    cout<<result;

    return 0;
}
