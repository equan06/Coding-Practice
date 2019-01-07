"""
Node is defined as
self.left (the left child of the node)
self.right (the right child of the node)
self.info (the value of the node)
"""
def preOrder(root):
    #Write your code here
    if not root:
        return 
    s = [root]
    while len(s) > 0:
        curr = s.pop()
        print(curr.info, end=' ')
        if curr.right:
            s.append(curr.right)
        if curr.left:
            s.append(curr.left)
