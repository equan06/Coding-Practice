'''
class Node:
      def __init__(self,info): 
          self.info = info  
          self.left = None  
          self.right = None 
           

       // this is a node of the tree , which contains info as data, left , right
'''
def height(root):
    """ -1 is used to ensure that the height of a single node is always 0. """
    if not root:
        return -1
    return 1 + max(height(root.left), height(root.right))
