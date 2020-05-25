package Leetcode;


import java.util.*;

public class LeetCode210 {


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        /*
        我们先记录每个节点的入度，以及使用 map 记录每个节点所能到达的其他节点

        然后我们将入度为 0 的节点存储进队列中，将它和它所能到达的节点 next 的通路断开，即 next 的入度 -1，
        当减为 0 的时候，表示入度为 0，那么添加进队列中
        */

        List<Integer>[] lists = new List[numCourses];

        //存储每个节点的度
        int[] points = new int[numCourses];
        for(int[] p : prerequisites){
            points[p[0]]++;
            if(lists[p[1]] == null){
                lists[p[1]] = new ArrayList<>();
            }
            //记录某个点能够到达的其他的点
            lists[p[1]].add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        //找到入度为 0 的点，入队
        for(int i = 0; i < numCourses; i++){
            if(points[i] == 0){
                queue.add(i);
            }
        }

        int[] res = new int[numCourses];
        int idx = 0;

        int visited = 0;
        while(!queue.isEmpty()){
//            int size = queue.size();
//            while(size-- > 0){
                int p = queue.poll();
                visited++;
                res[idx++] = p;
                List<Integer> list = lists[p];
                if(list == null){
                    continue;
                }


                for(int next : list){
                    points[next]--;
                    if(points[next] == 0){
                        queue.add(next);
                    }
                }
//            }
        }
        return visited == numCourses ?  res : new int[0];
    }

    public static void main(String[] args) {
        LeetCode210 leetCode210 = new LeetCode210();
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        leetCode210.findOrder(4, prerequisites);
    }
}
