package Amazon.Onsite.Linux_File_Search_API;

import java.util.List;

public class Directory implements IEntry {

    private List<File> files;
    private List<Directory> directories;
    private String name;
    private long size;
    private long createdAt;
    private long updatedAt;

    public List<File> getFiles() {
        return files;
    }

    public List<Directory> getDirectories() {
        return directories;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public long getCreatedAt() {
        return createdAt;
    }

    @Override
    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public long getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }
}
