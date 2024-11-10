package javafx.iio;

import com.sun.javafx.iio.ImageFrame;

import java.nio.ByteBuffer;

public class IIOImageFrame extends ImageFrame {

    public IIOImageFrame(IIOImageType imageType, ByteBuffer imageData, int width,
                         int height, int stride, byte[][] palette, float pixelScale,
                         IIOImageMetadata metadata) {
        super(imageType.toImageType(), imageData, width, height, stride, palette, pixelScale, metadata);
    }

    public IIOImageFrame(IIOImageType imageType, ByteBuffer imageData, int width, int height, int stride,
                         byte[][] palette, IIOImageMetadata metadata) {
        super(imageType.toImageType(), imageData, width, height, stride, palette, metadata);
    }
}
