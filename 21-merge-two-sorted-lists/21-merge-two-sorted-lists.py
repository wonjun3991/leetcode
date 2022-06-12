# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        merged_list = ListNode()
        first = merged_list
        while list1 != None and list2 != None:
            if list1.val <= list2.val:
                merged_list.next = ListNode(list1.val)
                list1 = list1.next
            else:
                merged_list.next = ListNode(list2.val)
                list2 = list2.next
            merged_list = merged_list.next
                
                
        if list1 != None:
            merged_list.next = list1
        else:
            merged_list.next = list2
    
        return first.next
        