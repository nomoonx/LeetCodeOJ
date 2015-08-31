import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by noMoon on 2015-08-30.
 */
public class RectangleArea {
    public static void main(String[] args){
        System.out.println(computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
    }
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int minXOne=Math.min(A,C);
        int maxXOne=Math.max(A, C);
        int minYOne=Math.min(B, D);
        int maxYOne=Math.max(B, D);
        int minXTwo=Math.min(E, G);
        int maxXTwo=Math.max(E, G);
        int minYTwo=Math.min(F, H);
        int maxYTwo=Math.max(F,H);
        int aeraOne=(maxXOne-minXOne)*(maxYOne-minYOne);
        int aeraTwo=(maxXTwo-minXTwo)*(maxYTwo-minYTwo);
        //no overlap
        if(maxXOne<minXTwo||maxXTwo<minXOne||maxYOne<minYTwo||maxYTwo<minYOne){
            return aeraOne+aeraTwo;
        }
        else{
            List<Integer> xlist=new ArrayList<Integer>();
            xlist.add(A);
            xlist.add(C);
            xlist.add(E);
            xlist.add(G);
            Collections.sort(xlist);
            List<Integer> ylist=new ArrayList<Integer>();
            ylist.add(B);
            ylist.add(D);
            ylist.add(F);
            ylist.add(H);
            Collections.sort(ylist);
            return aeraOne+aeraTwo-(xlist.get(2)-xlist.get(1))*(ylist.get(2)-ylist.get(1));
        }
    }

}
