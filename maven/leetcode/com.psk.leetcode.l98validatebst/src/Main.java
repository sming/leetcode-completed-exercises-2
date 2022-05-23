import java.util.HashSet;
import java.util.Set;

/**
 * Definition for a binary tree node.
 */

class IsValidBST {

  /**
   * ALL Values of LHS Nodes of Node N < N
   * <p>
   * ALL Values of RHS Nodes of Node N > N so what info do we need to pass down on each recurse?
   * <p>
   * - do you need to pass the entire history of ancesctors: YES, because let's say you have
   *
   * <p>------5
   * <p>--3--------8
   * <p>----7----4
   *
   * <p>that breaks the rules
   *
   * <p>
   * and where must one store those rules? every fucking level down what do you need to know to
   * validate 7? that it must be less than 5 that it must be more than 3
   * <p>
   * so could have 2 sets, mustBeLessThan, mustBeGreaterThan
   * </p>
   */
  public boolean isValidBST(TreeNode root) {
    // TODO this won't work as we need to basically store the "path" down to the number in question,
    // checking that it's greater-than or less-than it in turn.

    var mustBeLessThan = new HashSet<Integer>();
    var mustBeMoreThan = new HashSet<Integer>();
    return doop(mustBeLessThan, mustBeMoreThan, root);
  }

  private boolean doop(Set<Integer> mustBeLessThan, Set<Integer> mustBeMoreThan, TreeNode val) {
    if (mustBeLessThan.stream().anyMatch(x -> x <= val.val)) {
      return false;
    } else if (mustBeMoreThan.stream().anyMatch(x -> x >= val.val)) {
      return false;
    }
    boolean res = true;
    // For LHS
    if (val.left != null) {
      mustBeLessThan.add(val.val);
      res = doop(mustBeLessThan, mustBeMoreThan, val.left);
      if (!res) {
        return false;
      }
    }
    // For LHS
    if (val.right != null) {
      mustBeMoreThan.add(val.val);
      return doop(mustBeLessThan, mustBeMoreThan, val.right);
    }

    return true;
  }
}

