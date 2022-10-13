package Amazon.Onsite.Linux_File_Search_API;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FileSearch {
    Directory root;
    public FileSearch(Directory dir) {
        this.root = dir;
    }

    public List<File> find(Directory directory, IFilter filter, String params) {
        List<File> res = new ArrayList<>();
        Queue<Directory> queue = new LinkedList<>();
        queue.offer(root);

        // BFS.
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Directory cur = queue.poll();
                for (File file : cur.getFiles()) {
                    if (filter.match(params, file)) {
                        res.add(file);
                    }
                }
                for (Directory d : cur.getDirectories()) {
                    queue.offer(d);
                }
                size--;
            }
        }
        return res;
    }
}
