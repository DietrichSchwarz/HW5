import edu.hillel.FileData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileDataTest {


  @Test
  void FileDataConstructorTest() {
    FileData file1 = new FileData("file1.txt", 100, "homework14/out/file1");

    Assertions.assertEquals("file1.txt", file1.getName());
    Assertions.assertEquals(100, file1.getSize());
    Assertions.assertEquals("homework14/out/file1", file1.getPath());
  }
}