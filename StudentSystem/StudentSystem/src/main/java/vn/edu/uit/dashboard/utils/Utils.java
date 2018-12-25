package vn.edu.uit.dashboard.utils;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;



public class Utils {

	public static String buildBasePath(int type, int albumId, String frame_type, int position) {
		String basePath = "";
		String finalBasePath = "";
		switch (type) {
		case 1:// frame-category
			basePath = "frame_category/";
			break;
		case 2:// sticker-category
			basePath = "sticker_category/";
			break;
		case 3:// frame
			basePath = "frame/";
			break;
		case 4:// frame-avatar
			basePath = "frame_avatar/";
			break;
		case 5:// sticker
			basePath = "sticker/";
			break;
		case 6:// mask
			basePath = "mask/";
			break;
		case 7:// mask-item
			basePath = "mask_item/";
			break;
		case 8:// banner
			basePath = "banner/";
			break;
		case 9:// album
			basePath = "album/";
			break;
		case 10:// photo_temp
			basePath = "photo_temp/";
			break;

		default:
			break;
		}

		if (type == 9 || type == 10) {
			finalBasePath = basePath + albumId + "/";
		} else {
			if (frame_type != "" && position > -1) {
				finalBasePath = basePath + frame_type + "/" + position + "/";
			} else {
				finalBasePath = basePath + getCurrentDate() + "/";
			}

		}

		return finalBasePath;
	}
	

	public static RenderedImage renderImageFromUrl(String urlImage) {
		URL imageURL;
		try {
			imageURL = new URL(urlImage);
			RenderedImage img = ImageIO.read(imageURL);
			return img;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	public static float getselfieratio(float width) {

		return 2.0f;
	}

	public static float getratio(float width) {
		
		return 2.0f;
	}
	public static void prepareimagepng(BufferedImage image,float ratio) {
		float width = image.getWidth();
		float height = image.getHeight();
		float newWidth = width * ratio;
		float newHeight = height * ratio;
        int type = image.getType() == 0? BufferedImage.TYPE_INT_ARGB
                : image.getType();
	}
	
	public static String getContentType(String fileExtension) {
		switch(fileExtension.toLowerCase())	{
		case "png":
			return "image/png";
		case "jpg":
			return "image/jpeg";
		case "gif":
			return "image/gif";
		default:
			return "image/jpeg";
		}
	}

	public static float commissionAmount(float total_order) {
		if (total_order > 1000 && total_order <= 499000) {
			return 9000;
		} else if (total_order > 500000 && total_order <= 999000) {
			return 15000;
		} else if (total_order > 1000000 && total_order <= 1999000) {
			return 21000;
		} else if (total_order > 2000000 && total_order <= 2999000) {
			return 29000;
		} else if (total_order >= 3000000) {
			return 38000;
		}
		return 9000;
	}

	public static String getTime(Date date) {
		if(date == null) {
			date = new Date();
			return (new SimpleDateFormat("HH").format(date));
		} else {
			return (new SimpleDateFormat("HH").format(date));
		}
	}

	public static String getCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		System.out.println(dtf.format(localDate)); // 2016/11/16
		return dtf.format(localDate);
	}

	
	public static boolean createFolder(String path) {
		File theDir = new File(path);
		if (!theDir.exists()) {
			boolean result = false;

			try {
				System.out.println("Begin make dir: " + path);
				theDir.setWritable(true, false);
				theDir.mkdir();
				result = true;
			} catch (SecurityException se) {
				result = false;
				se.printStackTrace();
			}
			return result;
		} else {
			return true;
		}
	}

	public static void zip(List<String> fileList, String output) {
		try {
			System.out.println(output);
			// create byte buffer
			byte[] buffer = new byte[1024];

			FileOutputStream fos = new FileOutputStream(output);

			ZipOutputStream zos = new ZipOutputStream(fos);

			for (String file : fileList) {

				File srcFile = new File(file);

				FileInputStream fis = new FileInputStream(srcFile);

				// begin writing a new ZIP entry, positions the stream to the start of the entry
				// data
				zos.putNextEntry(new ZipEntry(srcFile.getName()));

				int length;

				while ((length = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, length);
				}

				zos.closeEntry();

				// close the InputStream
				fis.close();

			}

			// close the ZipOutputStream
			zos.close();

		} catch (IOException ioe) {
			System.out.println("Error creating zip file: " + ioe);
		}
	}

	public static String readHtmlFromFile(String filePath) {
		try {
			InputStream is = new FileInputStream(filePath);
			BufferedReader buf = new BufferedReader(new InputStreamReader(is));

			String line = buf.readLine();
			StringBuilder sb = new StringBuilder();

			while (line != null) {
				sb.append(line).append("\n");
				line = buf.readLine();
			}

			return sb.toString();
		} catch (IOException ioe) {
			System.out.println("Error creating zip file: " + ioe);
			return "";
		}
	}

	public static String stringVietnameseMoneyFormatWithFloat(float amount) {
		if (amount <= 1000) {
			return String.format("%s vnđ", amount);
		}
		try {
			NumberFormat formatter = new DecimalFormat("###,###");
			String resp = formatter.format(amount);
			resp = resp.replaceAll(",", ".");
			String str_price = String.format("%s vnđ", resp);
			return str_price;
		} catch (Exception e) {
			return "0vnđ";
		}

	}
	
	public static String stringVietnameseMoneyFormatWithDouble(Double amount) {
		if (amount <= 1000) {
			return String.format("%s vnđ", amount);
		}
		try {
			NumberFormat formatter = new DecimalFormat("###,###");
			String resp = formatter.format(amount);
			resp = resp.replaceAll(",", ".");
			String str_price = String.format("%s vnđ", resp);
			return str_price;
		} catch (Exception e) {
			return "0 vnđ";
		}

	}
	
	
	public static String encodePassword(String password) {
		ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder(256);
		String hashedPassword = passwordEncoder.encodePassword(password, null);
		return hashedPassword;
	}
	
	public static String decodePassword(String hashPassword) {
		return "";
	}
	
	public static String getYearFormatVN(Date date) {
		if(date == null) {
			date = new Date();
			return (new SimpleDateFormat("yyyy").format(date));
		} else {
			return (new SimpleDateFormat("yyyy").format(date));
		}
	}
	
	public static String getMonthYearFormatVN(Date date) {
		if(date == null) {
			date = new Date();
			return (new SimpleDateFormat("MM/yyyy").format(date));
		} else {
			return (new SimpleDateFormat("MM/yyyy").format(date));
		}
	}
	
	public static String getDateHourFormatVN(Date date) {
		if(date == null) {
			date = new Date();
			return (new SimpleDateFormat("dd/MM/yyyy HH:00").format(date));
		} else {
			return (new SimpleDateFormat("dd/MM/yyyy HH:00").format(date));
		}
	}
	
	public static String getDateFormatVN(Date date) {
		if(date == null) {
			date = new Date();
			return (new SimpleDateFormat("dd/MM/yyyy").format(date));
		} else {
			return (new SimpleDateFormat("dd/MM/yyyy").format(date));
		}
	}
	
	public static String getDatetimeFormatVN(Date date) {
		if(date == null) {
			date = new Date();
			return (new SimpleDateFormat("dd/MM/yyyy HH:mm").format(date));
		} else {
			return (new SimpleDateFormat("dd/MM/yyyy HH:mm").format(date));
		}
		
	}
	
	public static String getHourFormat(Date date) {
		if(date == null) {
			date = new Date();
			return (new SimpleDateFormat("HH:mm").format(date));
		} else {
			return (new SimpleDateFormat("HH:mm").format(date));
		}
	}
	
	public static Date getMondayOfLastWeek() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		c.add(Calendar.DATE, -7); 
		return c.getTime();
	}
	
	public static Date getMondayOfThisWeek() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return c.getTime();
	}
	
	public static String getDateFormatWeek(Date date) {
		if(date == null) {
			date = new Date();
		}
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		if(dayOfWeek == 1) {
			return "Chủ nhật";
		} else {
			return "Thứ " + dayOfWeek;
		}
	}
	
	public static Date getDateWithoutTime(Date date) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.set(Calendar.HOUR_OF_DAY, 0);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.SECOND, 0);
	    cal.set(Calendar.MILLISECOND, 0);
	    return cal.getTime();
	}
	
	public static Date getTomorrowDate(Date date) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.DATE, 1);
	    return cal.getTime();
	}
	
	public static Date getFirstDateOfMonth(Date date) {
		Calendar c = Calendar.getInstance();   // this takes current date
	    c.set(Calendar.DAY_OF_MONTH, 1);
	    return c.getTime();
	}
	
	public static List<Integer> convertListStringToListInt(List<String> stringList){
		List<Integer> intList = new ArrayList<Integer>();
		for(String s : stringList) intList.add(Integer.valueOf(s));
		return intList;
	}
	
	public static List<String> convertListIntToListString(List<Integer> intList){
		List<String> stringList = new ArrayList<String>();
		for(Integer i : intList) stringList.add(String.valueOf(i));
		return stringList;
	}
	
	public static String convertStringToDate(Date indate)
	{
	   String dateString = null;
	   SimpleDateFormat sdfr = new SimpleDateFormat("MM/dd/yyyy");
	   
	   try{
		dateString = sdfr.format( indate );
	   }catch (Exception ex ){
		System.out.println(ex);
	   }
	   return dateString;
	}
	public static Date minDay(int month, int year) throws ParseException{
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, month);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DATE, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		//String todaytemp=Utils.convertStringToDate(toDay);
        Date day = cal.getTime();
		String todaytemp = format.format(day);
		Date toDay = format.parse(todaytemp);
		System.out.println(toDay);
		return toDay;
    }

    public static Date maxDay(int month, int year) throws ParseException{
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, month);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		//String todaytemp=Utils.convertStringToDate(toDay);
        Date day = cal.getTime();
		String todaytemp = format.format(day);
		Date toDay = format.parse(todaytemp);
		System.out.println(toDay);
		return toDay;
    }
    public static long getHoursTwoDay(Date startTime, Date endTime) {
 		long b= endTime.getTime() - startTime.getTime();
 		return (long) b/1000/3600;
	}
    
    public static long getMinTwoDay(Date startTime, Date endTime) {
 		long b= endTime.getTime() - startTime.getTime();
 		return (long) b/1000/60;
	}
    
    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        if (str.isEmpty()) {
            return false;
        }
        int i = 0;
        int length = str.length();
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if ((c < '0' || c > '9' )&&( c !='.') ) {
                return false;
            }
        }
        return true;
    }
    
    public static String correctPromotionCode(String code) {
    	return code.replaceAll("[^a-zA-Z\\d]+", "").trim().toUpperCase();
    } 
    
    public static boolean deleteFile(String filePath) {
    	boolean isSuccess = true;
    	try{
    		
    		File file = new File(filePath);
        	
    		isSuccess = file.delete();
    	   
    	} catch(Exception e){
    		e.printStackTrace();
    		isSuccess = false;
    	}
    	return isSuccess;
    }
    public static String createRandomString(int length) {
		String stringRanger = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    return new SecureRandom()
	            .ints(length, 0, stringRanger.length())
	            .mapToObj(stringRanger::charAt)
	            .map(Object::toString)
	            .collect(Collectors.joining());
	}
    
    public static String convertDateToDayOfWeek(String dateOfYear) {
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dayOfWeek = "";
		try {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		String ds2 = sdf2.format(sdf1.parse(dateOfYear));
		System.out.println(ds2); //will be 30/06/2007
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar calendar = Calendar.getInstance();
		
		if(dateOfYear != null && !dateOfYear.isEmpty()) {
		
				calendar.setTime(sdf.parse(ds2));
				int a = calendar.get(Calendar.DAY_OF_WEEK);
				
				switch (a) {
				case 1:
					dayOfWeek = "Thứ hai";
					break;
				case 2:
					dayOfWeek = "Thứ ba";
					break;
				case 3:
					dayOfWeek = "Thứ tư";
					break;
				case 4:
					dayOfWeek = "Thứ năm";
					break;
				case 5:
					dayOfWeek = "Thứ sáu";
					break;
				case 6:
					dayOfWeek = "Thứ bảy";
					break;
				case 7:
					dayOfWeek = "Chủ nhật";
					break;
				}
		}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		
		
		return dayOfWeek;
	}
		
}


