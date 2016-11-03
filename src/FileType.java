import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by LENOVO on 8/31/2016.
 */
public class FileType extends FileFilter {
    @Override
    public boolean accept(File file) {
        String name = file.getName();
        String extension = GlobalVariable.fileExtension(name);
        if(extension == null)
            return false;
        if(extension == "jpg" || extension == "JPEG")
            return true;
        return false;
    }

    @Override
    public String getDescription() {
        return "Paint Image File (*.jpg)";
    }
}
