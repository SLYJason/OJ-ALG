package LeetCode.LC_401_600.LC588;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Collections;

public class Solution {
    class FileSystem {
        Directory root;
        public FileSystem() {
            this.root = new Directory();
        }

        public List<String> ls(String path) {
            Directory r = root;
            List<String> files = new ArrayList<>();
            String[] dirs = path.split("/");
            if (!path.equals("/")) {
                for (int i = 1; i < dirs.length - 1; i++) {
                    r = r.dirs.get(dirs[i]);
                }
                // it is file path, just return the file name.
                if (r.files.containsKey(dirs[dirs.length - 1])) {
                    files.add(dirs[dirs.length - 1]);
                    return files;
                } else {
                    r = r.dirs.get(dirs[dirs.length - 1]);
                }
            }
            files.addAll(new ArrayList<>(r.dirs.keySet()));
            files.addAll(new ArrayList<>(r.files.keySet()));
            Collections.sort(files);
            return files;
        }

        public void mkdir(String path) {
            Directory r = root;
            String[] dirs = path.split("/");
            for (int i = 1; i < dirs.length; i++) {
                if (!r.dirs.containsKey(dirs[i])) {
                    r.dirs.put(dirs[i], new Directory());
                }
                r = r.dirs.get(dirs[i]);
            }
        }

        public void addContentToFile(String filePath, String content) {
            Directory r = root;
            String[] dirs = filePath.split("/");
            for (int i = 1; i < dirs.length - 1; i++) {
                r = r.dirs.get(dirs[i]);
            }
            r.files.put(dirs[dirs.length - 1], r.files.getOrDefault(dirs[dirs.length - 1], "") + content);
        }

        public String readContentFromFile(String filePath) {
            Directory r = root;
            String[] dirs = filePath.split("/");
            for (int i = 1; i < dirs.length - 1; i++) {
                r = r.dirs.get(dirs[i]);
            }
            return r.files.get(dirs[dirs.length - 1]);
        }
    }

    class Directory {
        public Map<String, Directory> dirs;
        public Map<String, String> files;
        public Directory() {
            this.dirs = new HashMap<>();
            this.files = new TreeMap<>();
        }
    }
}
