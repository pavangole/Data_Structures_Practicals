#include <iostream>
#include <cstring>
using namespace std;

class StackApp
{
private:
    /* data */
    
    char data[10] = {-2,-2,-2,-2,-2,-2,-2,-2,-2,-2};
    char *top = &data[0];

public:
    bool isEmpty()
    {
        if ((int) *top != -1)
        {
            return false;
        }
        return true;
    }

    bool isFull()
    {
        if (*(++top) != 0)
        {
            return false;
        }
        return true;
    }

    char push(char item)
    {
        if (isFull())
        {
            cout << "Stack Overflowed" << endl;
            return 0;
        }
        ++top;
        *top = item;
        return 0;
    }

    char pop()
    {
        if (isEmpty())
        {
            return 0;
        }
        char temp = *top;
        --top;
        return temp;
    }

    char peek()
    {
        if (isEmpty())
        {
            return -1;
        }
        return  *top;
    }
};

int precedence(char ope)
{
    if (ope == '(' || ope == ')')
    {
        return 3;
    }
    if (ope == '/' || ope == '*')
    {
        return 2;
    }
    return 1;
}

bool isOperator(char ope)
{
    if (ope == '+' || ope == '-' || ope == '/' || ope == '*' || ope == '(' || ope == ')')
    {
        return true;
    }
    return false;
}

void infixTopostfix(char array[], int n)
{
    StackApp *stack = new StackApp();
   
    for (int i = 0; i < n; i++)
    {
        if (!isOperator(array[i]))
        {
            cout << (char) array[i];
        }
        else if (stack->isEmpty())
        {   
            stack->push(array[i]);
        }
        else
        {
            
            
            if (precedence((char) stack->peek()) < (char) precedence(array[i]))
            {
                stack->push(array[i]);
            }
            else
            {
                while (!stack->isEmpty())
                {
                    cout <<  (char) stack->pop();
                }
                stack->push(array[i]);
            }
        }
    }
    while (!stack->isEmpty())
    {
        cout << (char) stack->pop();
    }
    cout << endl;
}

int main(int argc, char const *argv[])
{
    string s;
    cin >> s;
    int n = s.length();
    char char_array[n];
    strcpy(char_array, s.c_str());
    infixTopostfix(char_array, n);

}
