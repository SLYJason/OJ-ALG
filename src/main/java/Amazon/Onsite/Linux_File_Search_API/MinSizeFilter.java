package Amazon.Onsite.Linux_File_Search_API;

public class MinSizeFilter implements IFilter {
    @Override
    public boolean match(String params, File file) {
        return file.getSize() >= Double.parseDouble(params);
    }
}
