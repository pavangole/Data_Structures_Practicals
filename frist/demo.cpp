#include<iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    char *top;
    char data[4];

    top = &data[0];
    --top;
    --top;
    cout << (int) *top << endl;
   
}
