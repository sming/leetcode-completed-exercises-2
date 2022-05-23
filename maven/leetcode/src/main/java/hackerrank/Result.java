package hackerrank;

import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;


/**
 * sender_user_id recipient_user_id amount ". Each of the values is separated by a space. sender and
 * recipient: both consist only of digits, are at most 9 digits long and start with non-zero digit
 * amount: consists only of digits, is at most 9 digits long and starts with non-zero digit
 * <p>
 * we need to read all the lines, counting each occurrence of a user id in a map userId:count
 * <p>
 * if we encounter a user with > threshold instances, we ... keep counting?
 */
class Result {

  /*

   */

  public static List<String> processLogs(List<String> logs, int threshold) {
    var userIdToCount = new TreeMap<String, Integer>();

    for (var line : logs) {
      var elements = line.split(" ");
      String sender = elements[0];
      String recipient = elements[1];

      if (sender.equals(recipient)) {
        countUserId(userIdToCount, sender);
      } else {
        countUserId(userIdToCount, sender);
        countUserId(userIdToCount, recipient);
      }
    }

    var suspiciousUserIds = userIdToCount.entrySet().stream().filter(x -> x.getValue() >= threshold)
        .map(Entry::getKey).collect(
            Collectors.toList());

    return suspiciousUserIds.stream().map(x -> Integer.parseInt(x)).sorted()
        .map(x -> Integer.toString(x)).collect(
            Collectors.toList());
  }

  private static void countUserId(TreeMap<String, Integer> userIdToCount, String userId) {
    if (userIdToCount.containsKey(userId)) {
      userIdToCount.put(userId, userIdToCount.get(userId) + 1);
    } else {
      userIdToCount.put(userId, 1);
    }
  }
}
