import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            dfs(root, new StringBuilder(), paths);
        }
        return paths;
    }

    private void dfs(TreeNode node, StringBuilder currentPath, List<String> paths) {
        int lengthBefore = currentPath.length();
        currentPath.append(node.val);

        // Check if current node is a leaf
        if (node.left == null && node.right == null) {
            paths.add(currentPath.toString());
        } else {
            currentPath.append("->");
            if (node.left != null) {
                dfs(node.left, currentPath, paths);
            }
            if (node.right != null) {
                dfs(node.right, currentPath, paths);
            }
        }

        // Backtrack: reset StringBuilder to previous state
        currentPath.setLength(lengthBefore);
    }
}