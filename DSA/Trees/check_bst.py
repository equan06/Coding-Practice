""" Node is defined as
class node:
  def __init__(self, data):
      self.data = data
      self.left = None
      self.right = None
"""
def check_binary_search_tree_(root):
    """
    Not enough to check if left and right are BSTs.
    Need to also ensure that every left node < root,
    and every right node > root. 
    """
    if not root:
        return True
    left = _max_value(root.left) < root.data
    if not (left and check_binary_search_tree_(root.left)):
        return False
    right = _min_value(root.right) > root.data
    if not(right and check_binary_search_tree_(root.right)):
        return False
    return True
    
def _max_value(root):
    """Return the max value of the tree at root."""
    if not root:
        return float('-inf')
    return max(root.data, _max_value(root.left),
               _max_value(root.right))

def _min_value(root):
    """Return the min value of the tree at root."""
    if not root:
        return float('inf')
    return min(root.data, _min_value(root.left), 
               _min_value(root.right))
