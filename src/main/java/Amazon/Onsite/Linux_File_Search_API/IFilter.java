package Amazon.Onsite.Linux_File_Search_API;

public interface IFilter {
    boolean match(String params, File file);
}
