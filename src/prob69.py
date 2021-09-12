def mySqrt(x: int) -> int:
    if x < 2:
        return x
    first = 0
    last = x
    while first != last:
        mid = (first + last) // 2
        if mid * mid == x:
            return mid
        elif mid * mid < x:
            first = mid + 1
        else:
            last = mid
        #print(first, last)

    return first - 1

if __name__ == "__main__":
    for i in range(0,26):
        print(i, mySqrt(i))
