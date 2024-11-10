package javafx.iio;

import java.io.IOException;
import java.io.InputStream;

public abstract class IIOLoader {
    protected final InputStream stream;

    public IIOLoader(InputStream stream) {
        this.stream = stream;
    }

    public abstract IIOImageFrame decode(int imageIndex, int width, int height, boolean preserveAspectRatio, boolean smooth) throws IOException;

    public void dispose() {
        if (stream != null) {
            try {
                stream.close();
            } catch (Exception ignored) {
                // close stream quietly
            }
        }
    }
}