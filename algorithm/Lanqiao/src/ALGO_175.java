#include<stdio.h>
        #include<algorithm>
using namespace std;
        int main()
        {
        int w,n,a[30010],x;
        //freopen("Data.txt","r",stdin);
        while(scanf("%d",&w)!=EOF)
        {
        scanf("%d",&n);
        x=0;
        for(int i=0;i<n;i++)
        scanf("%d",&a[i]);
        sort(a,a+n);
        for(int i=0,j=n-1;i<j;)
        {
        if(a[i]+a[j]<=w)
        {
        i++;j--;x++;
        }
        else
        j--;
        }
        printf("%d\n",n-x);
        }
        return 0;
        }