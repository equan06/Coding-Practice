# remove duplicates in place such that there are at most 2 duplicates left in the array. return length of array.
# idea is to keep a tail pointer at the place where we need to insert. 
# we increment the tail pointer in 3 cases (we trivially need it to start at i=3)
# Case 1: tail and curr are pointed at the first of two duplicates (curr != nums[tail-1])
# Case 2: tail and curr are pointed at the second of two duplicates (curr != nums[tail-2])
# Case 3: tail is pointed to the third or more of three+ duplicates, and curr is pointed to the next non-duplicate.
# In all 3 cases, we simply update nums[tail] == curr then increment tail.
# otherwise, we increment curr but keep tail where it is. 

class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        tail = 0
        for curr in nums:
            if tail < 2:
                tail += 1
            elif curr > nums[tail-1] or curr > nums[tail-2]:
                nums[tail] = curr
                tail += 1
        return tail 
