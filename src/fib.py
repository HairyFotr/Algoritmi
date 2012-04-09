#red 2
memo = {0:0, 1:1}
def fib(n):
    if not n in memo:
        memo[n] = fib(n-1) + fib(n-2)
    return memo[n]

#red k
memok = {}
def fib(n,k):
    if not k in memok:
        memok[k] = dict(zip(range(k), [0]*(k-1)+[1]))
    if not n in memok[k]:
        memok[k][n] = sum([fib(n-i-1, k) for i in range(k)])
    return memok[k][n]