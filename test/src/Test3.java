import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

public class Test3 {
    public static void main(String[] args) throws IOException {
        File file = new File("d:/1.txt");
        BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        Date date = new Date(attr.creationTime().toMillis());
        System.out.println(date);
    }
}
