def getPrimes(limit, primes = [2,3,7]):
    '''Memoized prime generator'''
    i = primes[-1] + 1
    while i < limit:
        for prime in primes:
            if prime > i/2: continue
            if i % prime == 0:
                break
        else: primes.append(i)
        i += 1
    
    return primes
