package javafx.iio;

import com.sun.javafx.iio.ImageFormatDescription;

public class IIOSignature extends ImageFormatDescription.Signature {

    public IIOSignature(final byte... bytes) {
        super(bytes);
    }

    public IIOSignature(int skipBytes, final byte... bytes) {
        super(skipBytes, bytes);
    }
}
