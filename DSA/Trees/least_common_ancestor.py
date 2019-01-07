'''
node implementation
class Node:
      def __init__(self,info): 
          self.info = info  
          self.left = None  
          self.right = None 
BST implementation is a pointer to root node.
'''

def lca(root, v1, v2):
    #Enter your code here
    if root is None:
        return root
    v1, v2 = min(v1,v2), max(v1,v2)
    val = root.info
    if val == v1 or val == v2:
        return root
    if v1 < val and val < v2:
        return root
    if v1 < val and v2 < val:
        return lca(root.left, v1, v2)
    if v1 > val and v2 > val:
        return lca(root.right, v1, v2)
    return root
