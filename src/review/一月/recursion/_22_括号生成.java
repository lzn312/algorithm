package review.一月.recursion;

import java.util.ArrayList;
import java.util.List;

public class _22_括号生成 {

    public static List<String> generateParenthesis(int n) {
        List<String>  res = new ArrayList<>();
        innerGenerateParenthesis(res,"",0,n,0,0);
        return res;
    }

    private static void innerGenerateParenthesis(List<String> res, String currStr,int level,int max,int left,int right) {

        if (currStr.length() == 2 * max) {
            res.add(currStr);
            return;
        }

        if (left < max){
        innerGenerateParenthesis(res, currStr+ '(', level + 1, max,left + 1, right);
        }
        if (right < left){
        innerGenerateParenthesis(res, currStr+ ')', level + 1, max,left, right + 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
