package com.psk;

/**
 * beginning -> <p> \n -> <br /> \n\n -> </p> \n> -> <blockquote> next when doesn't begin with >,
 * spit out </blockquote>
 */
public class Main {

  public static final String BR = "<br /> ";

  public static void main(String args) {
    mdToHtmlPrint(args);
  }

  private static void mdToHtmlPrint(String args) {
    boolean inABlock = false;
    var sb = new StringBuilder("<p>");

    for (var line : args.split("\n")) {
      if (line.length() == 0) {
        if (inABlock) {
          inABlock = false;
          sb.append(line).append("</blockquote>");
        } else {
          sb.append(line).append("</p");
        }
      } else if (line.startsWith(">")) {
        if (!inABlock) {
          inABlock = true;
          sb.append("<blockquote>").append(line.substring(1));
        } else {
          sb.append(line);
        }
      }
      // if nothing else at all applies
      sb.append(line).append(BR);
    }

    System.out.println(sb);
  }


}