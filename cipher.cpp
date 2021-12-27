#include<bits/stdc++.h>
using namespace std;
int main(){
    string text = "abcd";
    int s = 2;
    string result = "";
    string original = "";
    for(int i=0;i<text.length();i++){
        if(isupper(text[i])){
            result += char(int(text[i]+s-65)%26 +65);
        }else{
            result += char(int(text[i]+s-97)%26 +97);
        }
    }
        for(int i=0;i<result.length();i++){
        if(isupper(result[i])){
            original += char(int(result[i]-s-65)%26 +65);
        }else{
            original += char(int(result[i]-s-97)%26 +97);
        }
    }
    cout<<result<<endl;
    cout<<original;

    return 0;
}
