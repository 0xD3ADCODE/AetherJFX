package javafx.iio;

import com.sun.javafx.iio.ImageStorage;

public enum IIOImageType {

    /**
     * An image with a single channel of 8-bit valued gray levels.
     */
    GRAY,
    /**
     * An image with with two 8-bit valued channels, one of gray levels,
     * the other of non-premultiplied opacity, ordered as GAGAGA...
     */
    GRAY_ALPHA,
    /**
     * An image with with two 8-bit valued channels, one of gray levels,
     * the other of premultiplied opacity, ordered as GAGAGA...
     */
    GRAY_ALPHA_PRE,
    /**
     * An image with with one 8-bit channel of indexes into a 24-bit
     * lookup table which maps the indexes to 8-bit RGB components.
     */
    PALETTE,
    /**
     * An image with with one 8-bit channel of indexes into a 32-bit
     * lookup table which maps the indexes to 8-bit RGBA components
     * wherein the opacity is not-premultiplied.
     */
    PALETTE_ALPHA,
    /**
     * An image with with one 8-bit channel of indexes into a 32-bit
     * lookup table which maps the indexes to 8-bit RGBA components
     * wherein the opacity is premultiplied.
     */
    PALETTE_ALPHA_PRE,
    /**
     * An image with with one 8-bit channel of indexes into a 24-bit
     * lookup table which maps the indexes to 8-bit RGB components, and
     * a single transparent index to indicate the location of transparent
     * pixels.
     */
    PALETTE_TRANS,
    /**
     * An image with with three 8-bit valued channels of red, green, and
     * blue, respectively, ordered as RGBRGBRGB...
     */
    RGB,
    /**
     * An image with with four 8-bit valued channels of red, green, blue,
     * and non-premultiplied opacity, respectively, ordered as
     * RGBARGBARGBA...
     */
    RGBA,
    /**
     * An image with with four 8-bit valued channels of red, green, blue,
     * and premultiplied opacity, respectively, ordered as
     * RGBARGBARGBA...
     */
    RGBA_PRE;

    ImageStorage.ImageType toImageType() {
        return switch (this) {
            case GRAY -> ImageStorage.ImageType.GRAY;
            case GRAY_ALPHA -> ImageStorage.ImageType.GRAY_ALPHA;
            case GRAY_ALPHA_PRE -> ImageStorage.ImageType.GRAY_ALPHA_PRE;
            case PALETTE -> ImageStorage.ImageType.PALETTE;
            case PALETTE_ALPHA -> ImageStorage.ImageType.PALETTE_ALPHA;
            case PALETTE_ALPHA_PRE -> ImageStorage.ImageType.PALETTE_ALPHA_PRE;
            case PALETTE_TRANS -> ImageStorage.ImageType.PALETTE_TRANS;
            case RGB -> ImageStorage.ImageType.RGB;
            case RGBA -> ImageStorage.ImageType.RGBA;
            case RGBA_PRE -> ImageStorage.ImageType.RGBA_PRE;
            default -> throw new IllegalArgumentException("Unsupported image type: " + this);
        };
    }
}
