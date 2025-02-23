class Solution {
    fun constructFromPrePost(preorder: IntArray, postorder: IntArray): TreeNode? {
        if (preorder.isEmpty() || postorder.isEmpty()) return null

        val root = TreeNode(preorder[0])
        if (preorder.size == 1) return root  // 노드가 하나면 그대로 반환

        val leftRootVal = preorder[1]  // 왼쪽 서브트리 루트 값
        val leftSubtreeSize = postorder.indexOf(leftRootVal) + 1  // 왼쪽 서브트리 크기 계산

        // 재귀적으로 왼쪽, 오른쪽 서브트리 생성
        root.left = constructFromPrePost(
            preorder.copyOfRange(1, leftSubtreeSize + 1),
            postorder.copyOfRange(0, leftSubtreeSize)
        )
        root.right = constructFromPrePost(
            preorder.copyOfRange(leftSubtreeSize + 1, preorder.size),
            postorder.copyOfRange(leftSubtreeSize, postorder.size - 1)
        )

        return root
    }

}