# 518. Coin Change 2

* You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
* Return the number of combinations that make up that amount. 
  * If that amount of money cannot be made up by any combination of the coins, return 0.
* You may assume that you have an infinite number of each kind of coin.
* The answer is guaranteed to fit into a signed 32-bit integer.



Example 1:

```
Input: amount = 5, coins = [1,2,5]
Output: 4
```

Explanation: there are four ways to make up the amount:

```
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
```

Example 2:

```
Input: amount = 3, coins = [2]
Output: 0
```

Explanation: the amount of 3 cannot be made up just with coins of 2.

Example 3:

```
Input: amount = 10, coins = [10]
Output: 1
```

Constraints:

```
1 <= coins.length <= 300
1 <= coins[i] <= 5000
All the values of coins are unique.
0 <= amount <= 5000
```


So, ostensibly, you try the maximum number of small coins, then the next largest and so on but I know that won't work.

I also know that it will time out if I keep recomputing the different number of ways N (where N < amount) can be calculated.

So what if I stored the number of ways that N can be reached. Then, working out how many ways lower down elements would have would be trivial.

BUT how do we know when we've the "correct" number of ways for N? Do we just keep a map and keep updating it? Right 'til the end'

How do we represent the relationship between neighboring squares?

A B C
D E F
G H I

If you consider E, then F only has 2 possible additional routes. One of H's routes is through E but there could be a million others.

Ah so maybe #routes X,Y = E routes X,Y-1 + routes X-1,Y

Do we start from the end or the beginning? So we usually look for a basecase. 

numRoutes(N-1,M-1) = numRoutes(N-1,Y-2) + numRoutes(N-2,Y-1)