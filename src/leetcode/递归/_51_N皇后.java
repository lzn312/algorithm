package leetcode.递归;

import java.util.*;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：4
 * 输出：[
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *  
 * <p>
 * 提示：
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 **/
public class _51_N皇后 {

    // 用来存储其是否包含在元素里面
    private Set<Integer> columns = new HashSet<>();
    private Set<Integer> pie = new HashSet<>();
    private Set<Integer> na = new HashSet<>();


    public List<List<String>> solveNQueens(int n) {

        if (n < 1) {
            return null;
        }

        List<List<String>> res = new ArrayList<>();

        int[] queues = new int[n];
        innerSolveNQueens(res, queues, 0, n);


        return res;

    }

    private void innerSolveNQueens(List<List<String>> res, int[] queues, int level, int max) {

        // terminator
        if (level >= max) {
            List<String> currentRes = generateCheckerBoard(queues, max);
            res.add(currentRes);
            return;
        }


        // process 选取每列出来，看看会不会包含
        for (int col = 0; col < max; col++) {

            // 撇和捺 其实就是两个函数， x=y, x=-y ; 两条函数曲线
            if (columns.contains(col)
                    || na.contains(level + col)
                    || pie.contains(level - col)) {
                continue;
            }

            columns.add(col);
            na.add(level + col);
            pie.add(level - col);

            // 当前行 列赋值
            queues[level] = col;

            innerSolveNQueens(res, queues, level + 1, max);

            // reverse 重置当前行的下标
            queues[level] = -1;
            columns.remove(col);
            na.remove(level + col);
            pie.remove(level - col);
        }
    }


    public static void main(String[] args) {
        _51_N皇后 test = new _51_N皇后();
        System.out.println(test.solveNQueens(4));
    }

    private List<String> generateCheckerBoard(int[] queues, int size) {

        List<String> checkBoard = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            char[] currentChars = new char[size];
            Arrays.fill(currentChars, '.');
            currentChars[queues[i]] = 'Q';
            checkBoard.add(new String(currentChars));
        }

        return checkBoard;

    }
}
