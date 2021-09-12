def plusOne(digits: list[int]) -> list[int]:
    for i in reversed(range(0, len(digits))):
        value = digits[i] + 1
        if value != 10:
            digits[i] = value
            break
        else:
            digits[i] = 0
            if i == 0:
                digits.insert(0, 1)
    return digits

if __name__ == "__main__":
    print(plusOne([9,9,9]))
