package javafx.iio;

import com.sun.javafx.iio.ImageMetadata;

public class IIOImageMetadata extends ImageMetadata {
    /**
     * @param gamma             the image gamma
     * @param blackIsZero       whether smaller values represent darker shades
     * @param backgroundIndex   a palette index to use as background
     * @param backgroundColor   the color to be used as background.
     *                          The color format, in Integer, is packed as ARGB with 8 bits per channel.
     * @param transparentIndex  a palette index to be used as transparency.
     * @param delayTime         the amount of time to pause at the current image
     *                          (milliseconds).
     * @param loopCount         the amount of times to loop the animation
     *                          (zero for infinite loop).
     * @param imageWidth
     * @param imageHeight
     * @param imageLeftPosition
     * @param imageTopPosition
     * @param disposalMethod
     */
    public IIOImageMetadata(Float gamma, Boolean blackIsZero, Integer backgroundIndex, Integer backgroundColor,
                            Integer transparentIndex, Integer delayTime, Integer loopCount, Integer imageWidth,
                            Integer imageHeight, Integer imageLeftPosition, Integer imageTopPosition,
                            Integer disposalMethod) {
        super(gamma, blackIsZero, backgroundIndex, backgroundColor, transparentIndex, delayTime, loopCount, imageWidth,
                imageHeight, imageLeftPosition, imageTopPosition, disposalMethod);
    }
}
