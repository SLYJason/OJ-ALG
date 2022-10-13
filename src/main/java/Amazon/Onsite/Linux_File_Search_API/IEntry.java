package Amazon.Onsite.Linux_File_Search_API;

public interface IEntry {
    String getName();

    void setName(String name);

    long getSize();

    void setSize(long size);

    long getCreatedAt();

    void setCreatedAt(long createdAt);

    long getUpdatedAt();

    void setUpdatedAt(long updatedAt);

    boolean isDirectory();
}
