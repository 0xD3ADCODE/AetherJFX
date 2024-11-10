package javafx.iio;

import com.sun.javafx.iio.ImageFormatDescription;
import com.sun.javafx.iio.ImageLoader;
import com.sun.javafx.iio.ImageLoaderFactory;
import com.sun.javafx.iio.ImageStorage;
import com.sun.javafx.iio.common.ImageLoaderImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.function.Function;

public class IIO {

    public static void registerImageLoader(String formatName, List<String> extensions, List<IIOSignature> signatures, List<String> mimeSubtypes, Function<InputStream, IIOLoader> loaderFunction) {
        ImageStorage.getInstance().addImageLoaderFactory(
                createImageLoaderFactory(
                        createImageFormatDescription(formatName, extensions, signatures, mimeSubtypes),
                        loaderFunction
                )
        );
    }

    private static ImageLoaderFactory createImageLoaderFactory(ImageFormatDescription imageFormatDescription, Function<InputStream, IIOLoader> loaderFunction) {
        return new ImageLoaderFactory() {
            @Override
            public ImageFormatDescription getFormatDescription() {
                return imageFormatDescription;
            }

            @Override
            public ImageLoader createImageLoader(InputStream input) throws IOException {
                return IIO.createImageLoader(imageFormatDescription, loaderFunction.apply(input));
            }
        };
    }

    private static ImageFormatDescription createImageFormatDescription(String formatName, List<String> extensions, List<IIOSignature> signatures, List<String> mimeSubtypes) {
        return new ImageFormatDescription() {
            @Override
            public String getFormatName() {
                return formatName;
            }

            @Override
            public List<String> getExtensions() {
                return extensions;
            }

            @Override
            public List<Signature> getSignatures() {
                return signatures.stream()
                        .map(Signature.class::cast)
                        .toList();
            }

            @Override
            public List<String> getMIMESubtypes() {
                return mimeSubtypes;
            }
        };
    }

    private static ImageLoader createImageLoader(ImageFormatDescription imageFormatDescription, IIOLoader loader) {
        return new ImageLoaderImpl(imageFormatDescription) {

            @Override
            public void dispose() {
                loader.dispose();
            }

            @Override
            public IIOImageFrame load(int imageIndex, int width, int height, boolean preserveAspectRatio, boolean smooth) throws IOException {
                return loader.decode(imageIndex, width, height, preserveAspectRatio, smooth);
            }
        };
    }
}
