package uit.quocnguyen.tikitesting.commons;

import android.graphics.Rect;
import android.widget.TextView;

public class Utils {
    public static String getTextWithTwoLineWithMinimunWidth(TextView textView, String originalText) {

        Rect boundTotal = new Rect();

        String[] strs = originalText.split(" ");

        if(strs != null && strs.length == 1)
            return originalText;

        textView.getPaint().getTextBounds(originalText, 0, originalText.length(), boundTotal);
        String testContent = "";
        String currentContent = "";
        for (int i = 0; i < strs.length; i++) {
            testContent += " " + strs[i];
            Rect boundsTest = new Rect();
            textView.getPaint().getTextBounds(testContent, 0, testContent.length(), boundsTest);
            if (boundsTest.width() >= boundTotal.width() / 2) {
                int range1 = Math.abs(boundsTest.width() - (boundTotal.width() -boundsTest.width()));

                Rect boundCurrent = new Rect();
                textView.getPaint().getTextBounds(currentContent, 0, currentContent.length(), boundCurrent);

                int range2 = Math.abs(boundCurrent.width() - (boundTotal.width() -boundCurrent.width()));
                if(range1 > range2)
                {
                    return currentContent +"\n"+ originalText.substring(currentContent.length(),originalText.length());
                }else {
                    return testContent +"\n"+ originalText.substring(currentContent.length(),originalText.length());

                }
            }else {
                currentContent = testContent;
            }
        }


        return originalText;
    }
}
