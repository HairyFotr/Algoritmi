def primes(n):
    def prime(i, primes):
        for prime in primeSet:
            if not (i == prime or i % prime):
                return False
        primes.add(i)
        return i
    primeSet = set([2])
    i, p = 2, 0
    while True:
        if prime(i, primeSet):
            p += 1
            if p == n:
                return primeSet
        i += 1