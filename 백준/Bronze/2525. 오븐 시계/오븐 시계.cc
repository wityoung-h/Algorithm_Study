#include <iostream>
using namespace std;

int main()
{
    int hour, min, cooking;
    cin >> hour >> min >> cooking;
    
    min += cooking;
    
    while(min >= 60)
    {
        min -= 60;
        hour++;
    } 
    
    while(hour >= 24)
    {
        hour -= 24;
    } 
    
    cout << hour << ' ' << min;
}