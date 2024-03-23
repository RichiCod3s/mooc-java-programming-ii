
public class Checker {

    //returns true if the parameter string is an abbreviation of a day of the week (mon, tue, wed, thu, fri, sat, sun)
    public boolean isDayOfWeek(String string) {

        return string.matches("mon|tue|wed|thu|fri|sat|sun");
    }

    //checks whether all the characters in the parameter string are vowels.
    public boolean allVowels(String string) {
        // * means it the string can repeat the contained characters
        return string.matches("[aeiou]*");
    }

    //checks whether the parameter string expresses a time of day in the form hh:mm:ss
    public boolean timeOfDay(String string) {

        return string.matches("([0-1][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]");

        // ANOTHER WAY
        // return string.matches("([01][0123456789]|2[0123]):[012345][0123456789]:[012345][0123456789]");      
    }
    /*
^           Matches the beginning of a line
$           Matches the end of a line
.           Matches any single character except newline
\d          Matches any digit (0-9)
\w          Matches any word character (alphanumeric + underscore)
\s          Matches any whitespace character
\D          Matches any non-digit
\W          Matches any non-word character
\S          Matches any non-whitespace character
[a-z]       Matches any lowercase letter
[A-Z]       Matches any uppercase letter
[a-zA-Z]    Matches any letter
[0-9a-fA-F] Matches any hexadecimal digit
[abc]       Matches a, b, or c
[^abc]      Matches any character except a, b, or c
a|b         Matches a or b
()          Groups regular expressions and remembers matched text
\1, \2, ... Backreferences to group matched text
*           Matches zero or more occurrences of the preceding element
+           Matches one or more occurrences of the preceding element
?           Matches zero or one occurrence of the preceding element
{n}         Matches exactly n occurrences of the preceding element
{n,}        Matches n or more occurrences of the preceding element
{m,n}       Matches at least m and at most n occurrences of the preceding element
\b          Matches a word boundary
\B          Matches a non-word boundary

     */
}
