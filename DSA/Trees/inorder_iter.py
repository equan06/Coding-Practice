"""
Node is defined as
self.left (the left child of the node)
self.right (the right child of the node)
self.info (the value of the node)
"""
def inOrder(root):
    #Write your code here
    s = []
    curr = root
    while True:
        while curr:
            s.append(curr)
            curr = curr.left
        if len(s) > 0:
            curr = s.pop()
            print(curr.info, end=' ')
            curr = curr.right
        else:
            break
