package Amazon.Onsite.Linux_File_Search_API;

public class ExtensionFilter implements IFilter {
    @Override
    public boolean match(String extension, File file) {
        return extension.equals(file.getExtension());
    }
}
