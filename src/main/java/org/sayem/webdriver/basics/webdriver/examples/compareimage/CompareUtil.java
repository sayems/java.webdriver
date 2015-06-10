package org.sayem.webdriver.basics.webdriver.examples.compareimage;

import java.awt.*;
import java.awt.image.PixelGrabber;

public class CompareUtil {

    public static Result CompareImage(String baseFile, String actualFile) {

        Result compareResult = Result.PixelMismatch;
        Image baseImage = Toolkit.getDefaultToolkit().getImage(baseFile);
        Image actualImage = Toolkit.getDefaultToolkit().getImage(actualFile);
        try {
            PixelGrabber baseImageGrab = new PixelGrabber(baseImage, 0, 0, -1, -1, false);
            PixelGrabber actualImageGrab = new PixelGrabber(actualImage, 0, 0, -1, -1, false);

            int[] baseImageData = null;
            int[] actualImageData = null;

            if (baseImageGrab.grabPixels()) {
                int width = baseImageGrab.getWidth();
                int height = baseImageGrab.getHeight();
                baseImageData = new int[width * height];
                baseImageData = (int[]) baseImageGrab.getPixels();
            }

            if (actualImageGrab.grabPixels()) {
                int width = actualImageGrab.getWidth();
                int height = actualImageGrab.getHeight();
                actualImageData = new int[width * height];
                actualImageData = (int[]) actualImageGrab.getPixels();
            }


            System.out.println(baseImageGrab.getHeight() + "<>" + actualImageGrab.getHeight());
            System.out.println(baseImageGrab.getWidth() + "<>" + actualImageGrab.getWidth());

            if ((baseImageGrab.getHeight() != actualImageGrab.getHeight()) || (baseImageGrab.getWidth() != actualImageGrab.getWidth()))
                compareResult = Result.SizeMismatch;
            else if (java.util.Arrays.equals(baseImageData, actualImageData))
                compareResult = Result.Matched;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return compareResult;
    }

    ;

    public enum Result {Matched, SizeMismatch, PixelMismatch}
}

