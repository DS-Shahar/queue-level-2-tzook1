public static boolean isOrdered(Node root) {
        if (root == null) return true;
        if (root.left != null) {
        if (root.left.range.high != root.range.low)
        return false;
        }
        if (root.right != null) {
        if (root.right.range.low != root.range.high)
        return false;
        }
        if (root.left != null && root.right != null) {
        if (root.left.range.high >= root.right.range.low)
        return false;
        }
        return isOrdered(root.left) && isOrdered(root.right);
    }
