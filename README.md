# algorithms

## Sorting
In Java we use 
* Dual-Pivot Quick Sort for primitives (reordering not important)
* Timsort for objects.

### Quick sort
Quick Sort avg time ~10-20 n log(n) = O(n log(n))
Quick Sort 2-3 times faster than Merge Sort.

### Timsort

Insertion Sort working slow for arrays with size > 256.

Merge Sort working slow for arrays with size < 8.

Timsort evaluates int minrun. Minrun is size of sorted subarrays ([32, 64]).

Any Stream.sort or Collections.sort comes down to Arrays.sort.

### Segment Tree
[Booking concert tickets](https://leetcode.com/problems/booking-concert-tickets-in-groups/)

