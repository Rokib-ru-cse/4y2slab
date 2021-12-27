#include<bits/stdc++.h>
using namespace std;
int main(){
    string text;
    int s;
    cout<<"enter text ";
getline(cin,text);
    cin>>s;

    string result = "";
    string original = "";
    for(int i=0;i<text.length();i++){
        if(isalpha(text[i])){
           if(isupper(text[i])){
            result += char(int(text[i]+s-65)%26 +65);
        }else{
            result += char(int(text[i]+s-97)%26 +97);
        }}
        else{
            result += text[i];
        }


    }
        for(int i=0;i<result.length();i++){
                if(isalpha(text[i])){
        if(isupper(result[i])){
            original += char(int(result[i]-s-65)%26 +65);
        }else{
            original += char(int(result[i]-s-97)%26 +97);
        }}
                else{
            original += text[i];
        }
    }
    cout<<result<<endl;
    cout<<original;

    return 0;
}
