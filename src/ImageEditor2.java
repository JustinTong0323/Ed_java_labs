import java.awt.*;

public class ImageEditor2 {
    public static Picture threshold(Picture p, int thresh) {
        int width = p.width();
        int height = p.height();
        Picture picture = new Picture(width, height);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color grey = ImageEditor1.toGrey(p.get(i,j));
                if (grey.getRed() >= thresh) {
                    picture.set(i,j,grey);
                } else {
                    picture.set(i,j,Color.BLACK);
                }
            }
        }
        return picture;
    }
}
