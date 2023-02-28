import java.awt.Color;

public class ImageEditor1 {
    public static double luminance(Color color) {
        return 0.299 * color.getRed() + 0.587 * color.getGreen() + 0.114 * color.getBlue();
    }

    public static Color toGrey(Color color) {
        int grey = (int) Math.round(luminance(color));
        return new Color(grey, grey, grey);
    }

    public static Picture makeGreyscale(Picture pic) {
        int width = pic.width();
        int height = pic.height();
        Picture picture = new Picture(width, height);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color grey = toGrey(pic.get(i,j));
                picture.set(i,j,grey);
            }
        }
        return picture;
    }

    public static void main(String[] args) {
        Picture picture = new Picture("lion1.jpg");
        makeGreyscale(picture).show();
    }

}
