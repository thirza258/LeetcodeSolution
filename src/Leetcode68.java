import java.util.List;
import java.util.ArrayList;

public class Leetcode68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> newList = new ArrayList<String>();

        int len = 0;
        int start = 0;
        int end = 0;
        double space = 0;
        boolean isLast = false;
        for(int i = 0; i < words.length; i++) {
            len += words[i].length();
            if(len + i - start > maxWidth || i == words.length - 1) {
                if(len +  i - start > maxWidth) {
                    len -= words[i].length();
                    end = i - 1;
                    isLast = false;
                }
                else {
                    end = i;
                    isLast = true;
                }

                space = (double) maxWidth - (double) len;
                double spaceBetween = 0;
                double spaceCount = 0;
                if(isLast) {
                    spaceBetween = 0;
                    spaceCount = 1;
                }
                else {
                    spaceCount = Math.floor(space / (end - start));
                    spaceBetween = space - spaceCount * (end - start);
                }

                StringBuilder line = new StringBuilder(words[start]);
                for(int j = start + 1; j <= end; j++) {
                    for(int k = 0; k < spaceCount && space > 0; k++, space--) {
                        line.append(" ");
                    }
                    if(j-start-1 < spaceBetween) {
                        line.append(" ");
                        space--;
                    }
                    line.append(words[j]);
                }

                if(space > 0) {
                    for(; space > 0; space--) {
                        line.append(" ");
                    }

                }
                newList.add(line.toString());
                start = i;
                i = end;
                len = 0;
            }
        }
        return newList;
    }

    public static void main(String[] args) {
        Leetcode68 lc = new Leetcode68();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> result = lc.fullJustify(words, 16);
        for(String s : result) {
            System.out.println(s);
        }
    }
}