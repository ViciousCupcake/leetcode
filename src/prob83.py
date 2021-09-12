class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def deleteDuplicates(head: ListNode) -> ListNode:
    if head is None:
        return None
    start = head
    prevValue = head.val
    prevNode = head
    head = head.next
    while head is not None:
        if head.val == prevValue:
            prevNode.next = head.next
            head = head.next
        else:
            prevValue = head.val
            prevNode = head
            head = head.next
    return start
