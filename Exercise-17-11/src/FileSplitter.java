import java.io.*;

/**
 * Provides capability to split a file into the given number of pieces.
 *
 * @author Joey Davis
 */
public class FileSplitter {

  private File sourceFile;
  private int pieces = 1;

  /**
   * No-arg constructor
   */
  public FileSplitter() {
  }

  /**
   * Constructor allowing specification and number of pieces during initialization
   */
  public FileSplitter(File sourceFile, int pieces) {
    this.sourceFile = sourceFile;
    this.pieces = pieces;
  }

  /**
   * Write the file pieces to the filesystem
   */
  public void writePieces() throws IOException {
    if (sourceFile == null || !sourceFile.exists() || !sourceFile.isFile()) {
      throw new FileNotFoundException();
    }
    long pieceSize = sourceFile.length() / pieces;
    BufferedInputStream in = new BufferedInputStream(new FileInputStream(sourceFile));
    for (int i = 1; i <= pieces; i++) {
      long count = 0;
      // create output file with the pattern FILE.n, where n is current data block enumeration
      FileOutputStream fileOutputStream = new FileOutputStream(new File(sourceFile.getAbsolutePath() + "." + i));
      BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
      int b;
      // write the current data block to the filesystem
      while (count < pieceSize && ((b = in.read()) != -1)) {
        bufferedOutputStream.write(b);
        count++;
      }
      bufferedOutputStream.flush();
    }
  }

  /**
   * Getter for sourceFile
   */
  public File getSourceFile() {
    return sourceFile;
  }

  /**
   * Setter for sourceFile
   */
  public void setSourceFile(File sourceFile) {
    System.out.println(sourceFile.getAbsolutePath());
    this.sourceFile = sourceFile;
  }

  /**
   * Getter for pieces
   */
  public int getPieces() {
    return pieces;
  }

  /**
   * Setter for pieces
   */
  public void setPieces(int pieces) {
    this.pieces = pieces;
  }

}
