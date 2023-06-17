import math

# a^b mod c
a = 2
b = 7
c = 7
x = 1
power = a%c
for i in range(math.trunc(math.log2(b))+1):
    print(power, x)
    if b & (1<<i):
        x = x*power % c
    power = power**2 % c

def mergesort(array, left, right):
    if right-left == 1:
        return [array[left]]

    mid = (left + right) // 2
    l_array = mergesort(array, left, mid)
    r_array = mergesort(array, mid, right)
    l_index = r_index = 0

    ret = list(range(right-left))
    for i in range(right-left):
        if l_index == len(l_array):
            ret[i] = r_array[r_index]
            r_index += 1

        elif r_index == len(r_array):
            ret[i] = l_array[l_index]
            l_index += 1

        elif l_array[l_index] < r_array[r_index] :
            ret[i] = l_array[l_index]
            l_index += 1

        else:
            ret[i] = r_array[r_index]
            r_index += 1
    return ret

# array = [1,4,5,2,6]
# print(mergesort(array, 0, 5))