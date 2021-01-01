package leetcode.深度及广度优先;

import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 **/
public class _127_单词接龙 {


    /**
     * 这一题其实就是搜索匹配，给定了单词列表，我们可以拿出其进行广度优先的搜索
     **/
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (wordList.isEmpty()) {
            return 0;
        }


        // 我们准备进行搜索
        int step = 1;


        // 定一个是否访问过标识，如果其已经被访问过了，我们就直接跳过，因为他不在这个分支里面
        Set<String> visited = new HashSet<>();

        Queue<String> wordsQueue = new LinkedList<>();
        wordsQueue.add(beginWord);


        // 构建数据集，方便查找
        Set<String> wordsTable = new HashSet<>(wordList);

        if (!wordsTable.contains(endWord)) {
            return 0;
        }

        while (!wordsQueue.isEmpty()) {
            // 判断其是否交换后能得到结束单词
            int size = wordsQueue.size();
            for (int i = 0; i < size; i++) {
                if (isSameWithEndWord(visited, wordsQueue, endWord, wordsTable)) {
                    return step + 1;
                }
            }

            step++;
        }

        return 0;
    }

    private boolean isSameWithEndWord(Set<String> visited, Queue<String> wordsQueue, String endWord, Set<String> wordsTable) {
        String currentWord = wordsQueue.poll();


        // 每修改一个字符，
        char[] currentChars = currentWord.toCharArray();

        for (int i = 0; i < endWord.length(); i++) {
            char originChar = currentChars[i];
            // 依次取26个字母
            for (char j = 'a'; j <= 'z' ; j++) {
                if (originChar != j)
                    // 组成单词后，判断是否包含,先构成临时数组，构建字符
                    currentChars[i] = j;
                    String stepWord = String.valueOf(currentChars);
                    if (wordsTable.contains(stepWord)) {

                        // 如果包含这个结束单词返回true；
                        if ( stepWord.equals(endWord)){
                            return true;
                        }

                        // 标记为单词路径已经被使用
                        if (!visited.contains(stepWord)){
                            wordsQueue.add(stepWord);
                            visited.add(stepWord);
                        }
                    }
                }
            // 恢复原始字符，进行下一轮判断
            currentChars[i] = originChar;
            }

        return false;
        }

    }





