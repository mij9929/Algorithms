#include<stdio.h>

int main()
{
    int fibo[1500000];
    fibo[0] = 0;
    fibo[1] = 1;
    int i;
    long long n;
    scanf("%lld",&n);
    for(i=2; i<=1500000; i++){
        fibo[i] = fibo[i-1] + fibo[i-2];
        fibo[i] %= 1000000;
    }
    
    printf("%d",fibo[n%1500000]);
    
}