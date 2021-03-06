import java.util.*;

public class WordLadder127 {
    // 127. 单词接龙 https://leetcode-cn.com/problems/word-ladder/

    /*
    解法

     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) dict.add(word);

        if (!dict.contains(endWord)) return 0;

        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add(beginWord);
        q2.add(endWord);

        int steps = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            ++steps;

            if (q1.size() > q2.size()) {
                Set<String> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }

            Set<String> q = new HashSet<>();

            for (String w : q1) {
                char[] chs = w.toCharArray();
                for (int i = 0; i < w.length(); ++i) {
                    char ch = chs[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chs[i] = c;
                        String t = new String(chs);
                        if (q2.contains(t)) return steps + 1;
                        if (!dict.contains(t)) continue;
                        dict.remove(t);
                        q.add(t);
                    }
                    chs[i] = ch;
                }
            }

            q1 = q;
        }
        return 0;
    }

    /*
    解法
    1. 将wordList放入set并判断是否包含endWord
    2. 将beginWord放入队列
    3. 开始循环队列，每次循环时记录是第几次
    4. 将beginWord的每个字母逐一替换，并在wordList中匹配
      4.1. 匹配到 = true：从wordList中删除，并将该词添加到队列中；循环第几次+1
      4.2. 匹配到 = false：继续替换字母
    5. 直到找到endWord或者wordList遍历完
     */
    /*public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) dict.add(word);

        if (!dict.contains(endWord)) return 0;

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        int steps = 0;
        while (!queue.isEmpty()) {
            ++steps;
            for (int s = queue.size(); s > 0; --s) {
                String w = queue.poll();
                char[] chs = w.toCharArray();
                for (int i = 0; i < chs.length; ++i) {
                    char ch = chs[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == ch) continue;
                        chs[i] = c;
                        String t = new String(chs);
                        if (t.equals(endWord)) return steps + 1;
                        if (!dict.contains(t)) continue;
                        dict.remove(t);
                        queue.offer(t);
                    }
                    chs[i] = ch;
                }
            }
        }
        return 0;
    }*/
}
