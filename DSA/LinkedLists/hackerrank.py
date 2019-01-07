# Complete the mergeLists function below.

#
# For your reference:
#
# SinglyLinkedListNode:
#     int data
#     SinglyLinkedListNode next
#
#

def mergeLists(head1, head2):
    if not head1:
        return head2
    if not head2:
        return head1
    # find smaller/larger of current lists
    if head1.data < head2.data:
        head, smaller = head1, head1
        larger = head2
    else:
        head, smaller = head2, head2
        larger = head1
    prev = smaller
    # smaller/larger represent what's currently left.
    # smaller is the list who has the smaller data
    while smaller or larger:
        if not smaller:
            prev.next = larger 
            break

        if smaller.data > larger.data:
            prev.next = larger
            smaller, larger = larger, smaller
        else:
            prev = smaller
            smaller = smaller.next
    return head
    
    
    
 
