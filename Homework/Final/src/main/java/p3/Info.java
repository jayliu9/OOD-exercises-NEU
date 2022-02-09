package p3;

public class Info {

  private String originalVer;
  private String refactoredVer;
  private Integer numOfReplacement;

  public Info(String originalVer, String refactoredVer, Integer numOfReplacement) {
    this.originalVer = originalVer;
    this.refactoredVer = refactoredVer;
    this.numOfReplacement = numOfReplacement;
  }

  @Override
  public String toString() {
    return "Info{" +
        "originalVer='" + originalVer + '\'' +
        ", refactoredVer='" + refactoredVer + '\'' +
        ", numOfReplacement=" + numOfReplacement +
        '}';
  }
}
