# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# collections.queue is a fast implementation of a queue. this is an iterative BFS sol, taking O(N) space and time.

from collections import deque
class Solution:
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        queue = deque([root.left, root.right])
        while len(queue) > 0:
            left = queue.popleft()
            right = queue.popleft()
            if (not left and right) or (left and not right):
                return False
            elif left and right:
                if left.val != right.val:
                    return False
                queue.extend([left.left, right.right])
                queue.extend([left.right, right.left])
        return True
              
        
