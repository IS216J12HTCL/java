package vn.edu.uit.dashboard.utils;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class ImageProcessor {

	public static BufferedImage resizeImage(BufferedImage image, int width, int height) {
		double thumbRatio = (double) width / (double) height;
		int imageWidth = image.getWidth(null);
		int imageHeight = image.getHeight(null);
		double aspectRatio = (double) imageWidth / (double) imageHeight;

//		if (thumbRatio < aspectRatio) {
//			height = (int) (width / aspectRatio);
//		} else {
//			width = (int) (height * aspectRatio);
//		}

		// Draw the scaled image
		BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = newImage.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.drawImage(image, 0, 0, width, height, null);
		g2d.dispose();
		image.flush();
		return newImage;
	}


	public static BufferedImage createTransparentImage(int width, int height) {
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = bufferedImage.createGraphics();
		
		g2d.setColor(Color.decode("#36FF1B"));
		g2d.drawImage(bufferedImage, 0, 0, null);
		g2d.dispose();

		return bufferedImage;
	}

	public static BufferedImage rotateImage(BufferedImage image, double angle) {
		Float radianAngle = (float) Math.toRadians(angle);

		float sin = (float) Math.abs(Math.sin(radianAngle));
		float cos = (float) Math.abs(Math.cos(radianAngle));

		int w = image.getWidth();
		int h = image.getHeight();

		int neww = (int) Math.round(w * cos + h * sin);
		int newh = (int) Math.round(h * cos + w * sin);

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		GraphicsConfiguration gc = gd.getDefaultConfiguration();

		BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
		//BufferedImage result = createTransparentImage(neww, newh);
		Graphics2D g2d = result.createGraphics();

		// -----------------------MODIFIED--------------------------------------
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		AffineTransform at = AffineTransform.getTranslateInstance((neww - w) / 2, (newh - h) / 2);
		at.rotate(radianAngle, w / 2, h / 2);
		// ---------------------------------------------------------------------

		g2d.drawRenderedImage(image, at);
		g2d.dispose();
		image.flush();
		return result;
	}
	
	public static BufferedImage rotateImage2(BufferedImage image, double angle) {
		Float radianAngle = (float) Math.toRadians(angle);

		float sin = (float) Math.abs(Math.sin(radianAngle));
		float cos = (float) Math.abs(Math.cos(radianAngle));

		int w = image.getWidth();
		int h = image.getHeight();

		int neww = (int) Math.round(w * cos + h * sin);
		int newh = (int) Math.round(h * cos + w * sin);
		
		BufferedImage output = new BufferedImage(neww, newh, Transparency.TRANSLUCENT);
		AffineTransform transform = AffineTransform.getTranslateInstance((neww - w) / 2, (newh - h) / 2);
		transform.rotate(radianAngle, w / 2, h / 2);

		AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
		op.filter(image, output);
		
		image.flush();
		return output;
	}

	public static BufferedImage clippingImage(BufferedImage image, BufferedImage mask) {
		if (image.getWidth() != mask.getWidth() || image.getHeight() != mask.getHeight()) {
			throw new IllegalArgumentException("Dimensions are not the same!");
		}
		BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB_PRE);

		for (int y = 0; y < image.getHeight(); ++y) {
			for (int x = 0; x < image.getWidth(); ++x) {
				int maskPixel = mask.getRGB(x, y);
				int maskAlpha = (maskPixel & 0xFF000000);
				int sourceRGB = image.getRGB(x, y);
				int newAlpha = (int) (((maskAlpha >> 24) * (sourceRGB >> 24)) / 255d);
				int imgPixel = (newAlpha << 24) | (sourceRGB & 0x00FFFFFF);
				int rgb = imgPixel | maskAlpha;
				result.setRGB(x, y, rgb);

			}
		}
		image.flush();
		mask.flush();
		return result;
	}

	public static BufferedImage mergeImage(BufferedImage image, BufferedImage overlay, double x, double y) {
		
		// paint both images, preserving the alpha channels
		Graphics g2d = image.getGraphics();
		g2d.drawImage(image, 0, 0, null);
		g2d.drawImage(overlay, (int)x, (int)y, null);
		g2d.dispose();
		overlay.flush();
		
		return image; 
	}
	
	public static Color hex2Rgb(String colorStr) {
	    return new Color(
	            Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
	            Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
	            Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
	}
}