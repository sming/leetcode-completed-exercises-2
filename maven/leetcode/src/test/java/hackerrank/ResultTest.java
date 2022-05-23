package hackerrank;

import java.util.List;
import junit.framework.TestCase;

public class ResultTest extends TestCase {

  public void testProcessLogs() {
    var input = List.of("9 7 50", "22 7 20", "33 7 50", "22 7 30");
    assertEquals(List.of("7"), Result.processLogs(input, 3));

  }
}