import java.util.*;

/**
 * @Description 图相关问题
 * @Author alice
 * @Date 2020/7/16 8:17
 **/
public class Graph {
    public boolean isBipartite(int[][] graph) {
        /**
         * @Description //785. 判断二分图 https://leetcode-cn.com/problems/is-graph-bipartite/
         * @Date 2020/7/16 8:21
         * @Param  * @param graph
         * @return boolean
         **/
        int n = graph.length;
        int[] color = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                deque.offer(i);
                while (!deque.isEmpty()) {
                    int head = deque.poll();
                    for (int j = 0; j < graph[head].length; j++) {
                        int h = graph[head][j];
                        if (color[h] == 0) {
                            color[h] = -color[head];
                            deque.offer(h);
                        } else if (color[h] == color[head]) {
                            return false;
                        }

                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Graph().isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}});
    }

}
