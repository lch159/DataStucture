package LAB6;

import java.io.*;
import java.util.LinkedList;
import java.util.Stack;


/**
 * Created by 11611423 李晨昊 on 2017/11/24.13:11
 */
public class FindThePreOrderTraversal {
    private static InputReader in;
    private static PrintWriter out;


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    private static TreeNode buildTree(int[] inorder, int[] postorder) {
        return btConstruct(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    private static TreeNode btConstruct(int[] inorder, int[] postorder, int index, int l, int r) {

        if (index < 0 || l > r) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[index]);

        if (l == r) {
            root.left = null;
            root.right = null;
            return root;
        }

        int j;
        for (j = l; j <= r; j++) {
            if (postorder[index] == inorder[j]) {
                break;
            }
        }

        if (j <= r) {
            if (j == r) {
                root.left = btConstruct(inorder, postorder, index - 1, l, j - 1);
                root.right = null;
            } else if (j == l) {
                root.right = btConstruct(inorder, postorder, index - 1, j + 1, r);
                root.left = null;
            } else {
                int tmp = -1;
                for (int i = l; i < j; i++) {
                    for (int k = 0; k < postorder.length; k++) {
                        if (inorder[i] == postorder[k] && k > tmp) {
                            tmp = k;
                        }
                    }
                }
                root.left = btConstruct(inorder, postorder, tmp, l, j - 1);
                root.right = btConstruct(inorder, postorder, index - 1, j + 1, r);
            }
        }
        return root;
    }


    public static void main(String[] args) throws IOException {
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);
        int T = in.nextInt();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int num = in.nextInt();
            int[] inOrder = new int[num];
            for (int j = 0; j < num; j++) {
                inOrder[j] = in.nextInt();
            }
            int[] postOrder = new int[num];
            for (int j = 0; j < num; j++) {
                postOrder[j] = in.nextInt();
            }

            TreeNode preOrder_root = buildTree(inOrder, postOrder);

            Stack<TreeNode> s = new Stack<>();
            s.push(preOrder_root);
            while (!s.isEmpty()) {
                TreeNode temp = s.pop();
                result.append(temp.val).append(" ");
                if (temp.right != null) s.push(temp.right);
                if (temp.left != null) s.push(temp.left);
            }
            result.append("\n");
        }

        out.print(result);
        out.close();
    }

    static class InputReader {
        BufferedReader br;

        InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        public int nextInt() throws IOException {
            int c = br.read();
            while (c <= 32) {
                c = br.read();
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = br.read();
            }
            int x = 0;
            while (c > 32) {
                x = x * 10 + c - '0';
                c = br.read();
            }
            return negative ? -x : x;
        }


    }
}
