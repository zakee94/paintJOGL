import javax.swing.filechooser.FileFilter;
import java.io.File;

public class FileType extends FileFilter {
    @Override
    public boolean accept(File file) {
        String name = file.getName();
        //GlobalVariable.fileAddress = name;
        String extension = GlobalVariable.fileExtension(name);
        if(file.isDirectory()){
            return true;
        }
        if(extension == null)
            return false;
        if(extension.equals("jpg") || extension.equals("png") || extension.equals("jpeg"))
            return true;
        return false;
    }

    @Override
    public String getDescription() {
        return "Filter for (*.png), (*.jpg) & (*.jpeg) Files" ;
    }
}
