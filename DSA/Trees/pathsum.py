# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = 

# note: this approach uses a helper function and mutates a master list. the other approach
# which I personally find simpler was to recursively call pathSum to find valid paths in the subtree,
# then push the root node to each found path at the end. this general approach works to find all root-to-leaf paths.

# the time complexity is O(NlogN) since we traverse N nodes, and for each node there's a list.copy() operation that occurs,
# causing the copying of up to logN nodes (the height of tree/length of a path). 

# note: I initially did 2 copy operations per call, but it's now clear that only one is needed. we can keep passing the same
# path down the left side of the tree, but if we attempted to pass it to theright side, then we'd be passing an already mutated
# curr path down. 
class Solution:
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        if not root:
            return []
        all_paths = []
        self.helper(root, sum, [], all_paths)
        return all_paths
        
    
    def helper(self, root, sum, curr_path, all_paths): 
        if not root:
            return []
        curr_path.append(root.val)
        if not (root.left or root.right):
            if root.val == sum:
                all_paths.append(curr_path)
        curr2 = curr_path.copy() 
        self.helper(root.left, sum - root.val, curr_path, all_paths)
        self.helper(root.right, sum - root.val, curr2, all_paths)
