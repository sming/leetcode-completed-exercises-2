import junit.framework.TestCase;

public class IsValidBSTTest extends TestCase {

  public void testIsValidBST() {
    var foo = new IsValidBST();
    var n = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
    assertEquals(false, foo.isValidBST(n));
  }

  /**
   * <p>------5
   * <p>--3--------8
   * <p>----7
   */
  public void testIsValidBST2() {
    var foo = new IsValidBST();
    var n = new TreeNode(5, new TreeNode(3, null, new TreeNode(7)), new TreeNode(8));
    assertEquals(false, foo.isValidBST(n));
  }

  public void testIsValidBST213() {
    var foo = new IsValidBST();
    var n = new TreeNode(2, new TreeNode(1), new TreeNode(3));
    assertEquals(true, foo.isValidBST(n));
  }

}