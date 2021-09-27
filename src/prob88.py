def merge(nums1: list[int], m: int, nums2: list[int], n: int) -> None:
    idx1 = 0
    idx2 = 0
    buffer = []
    
    while idx1 < m and idx2 < len(nums2):
        if nums1[idx1] < nums2[idx2]:
            buffer.append(nums1[idx1])
            idx1 = idx1 + 1
        else:
            buffer.append(nums2[idx2])
            idx2 = idx2 + 1
    buffer.extend(nums1[idx1:m])
    buffer.extend(nums2[idx2:])
    
    for i in range(len(buffer)):
        nums1[i] = buffer[i]

if __name__ == "__main__":
    a = [0]
    print(merge(a, 0, [1], 1), a)