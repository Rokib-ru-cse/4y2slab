#include <iostream>
#include <string>
using namespace std;
int main()
{
    string text = "aaabbbcdddeee";
    text+='0';
    string result = "";
    string temp = "";
    int cnt = 0;
    int i=0;
    int k = 0;
    while(i<text.length()){
        for(int j=k;j<text.length();j++){
            if(text[k]==text[j]){
                cnt++;
                i++;
            }else{
                result +=text[k]+to_string(cnt);
                cnt=0;
                k=i;
                break;
            }
        }
    }
    cout<<result<<endl;
    return 0;
}
