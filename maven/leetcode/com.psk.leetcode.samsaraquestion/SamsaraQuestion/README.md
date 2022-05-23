# Convert Markdown string to HTML

Link: https://leetcode.com/discuss/interview-question/948848/samsara-phone-convert-markdown-string-to-html

Write logic to convert the input to expected output.

Input:

```text
This is a paragraph with a soft
line break.

This is another paragraph that has
> Some text that
> is in a
> block quote.

This is another paragraph with a ~~strikethrough~~ word.
```

Expected Output:

```markdown
<p>This is a paragraph with a soft<br />line break.</p>

<p>This is another paragraph that has <br />
  <blockquote>Some text that<br />is in a<br />block quote.</blockquote>
</p>

<p>This is another paragraph with a <del>strikethrough</del> word.</p>
Formatting of the output is not important - but must be valid HTML.

Any suggestions on the best approach to this?
```