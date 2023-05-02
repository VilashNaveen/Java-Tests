import java.util.ArrayList;

public class Syntax_Checker {
    int B,G,S;
    public Boolean Check (ArrayList<Character> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (B < 0 || G <0 || S < 0) {
                return false;
            }
            switch (arr.get(i)) {
                case '(':
                    B--; continue;
                case ')':
                    B++; continue;
                case '>':
                    G++; continue;
                case '<':
                    G--; continue;
                case ']':
                    S++; continue;
                case '[':
                    S--; continue;
            }
        }
        if (S==0 && B==0 && G==0) {
            return true;
        }
        else {
            return false;
        }
    }

}
