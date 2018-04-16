package ua.springboot.web.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.multipart.MultipartFile;

import ua.springboot.web.entity.Car;

public class CustomFileUtils {

	private static String PROJECT_PATH = System.getProperty("user.dir");
	private static String SEPARATOR = System.getProperty("file.separator");
	private static String ROOT_PATH = PROJECT_PATH+ SEPARATOR + "src" + 
				SEPARATOR + "main" + SEPARATOR + "webapp";
	private static String USER_FILE = ROOT_PATH + SEPARATOR + "users-file";
	private static String CAR_PHOTO =  ROOT_PATH + SEPARATOR + "car-photo";
	
	
	public static File createFolderForUserData(Long id) {
		File uploadDir = new File(USER_FILE);
		if(!uploadDir.exists())
			uploadDir.mkdir();
		
		File userFolder = new File(uploadDir.getAbsolutePath() + 
					SEPARATOR + "user_" + id);
		if(!userFolder.exists()) 
			userFolder.mkdir();
		
		return userFolder;
			
	}
	
	public static void saveUserProfilePhoto(Long id, MultipartFile file) throws IOException {
		if(file != null && !file.isEmpty()) {
			
			BufferedImage photo = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
			File destination = new File(createFolderForUserData(id).getAbsolutePath() 
						+ SEPARATOR +  file.getOriginalFilename());
			ImageIO.write(photo, "png", destination);
		}
		
		
	}
	
	public static String getUserProfilePhoto(Long id, String photoName) throws IOException {
	//	File photo = new File(USER_FILE + SEPARATOR + "default-user-profile-photo.png"//"user_" + id + "userPhoto.png" );
		
		File photo = new File(USER_FILE + SEPARATOR + "user_" + id + SEPARATOR + photoName);
		byte[] encodeFileToByte = null;	
		
		if(!photo.exists()) {
			photo = new File(USER_FILE + SEPARATOR + "default-user-profile-photo.png");
		}
		
		encodeFileToByte = Base64.encode(FileUtils.readFileToByteArray(photo));
		
		return new String(encodeFileToByte);
	}
	
	public static File createFolderForCarPhoto(Long id) {
		File carDir = new File(CAR_PHOTO);
		if(!carDir.exists())
			carDir.mkdir();
		
		File carFolder = new File(carDir.getAbsolutePath() + 
					SEPARATOR + "car_" + id);
		if(!carFolder.exists()) 
			carFolder.mkdir();
		
		return carFolder;
			
	}
	
	public static void saveCarPhotos(Long id, MultipartFile[] files) throws IOException {
		if(files != null && files.length != 0) {
			for(MultipartFile file : files) {
				if(!file.isEmpty()) {
					System.out.println(file);
					BufferedImage photo = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
					System.out.println(photo);
					File destination = new File(createFolderForCarPhoto(id).getAbsolutePath() 
						+ SEPARATOR +  file.getOriginalFilename());
					System.out.println(destination);
					ImageIO.write(photo, "png", destination);
				}
			}
		}
		
		
	}
	
	public static String[] getCarPhotos(Long id, String[] names) throws IOException {
		//	File photo = new File(USER_FILE + SEPARATOR + "default-user-profile-photo.png"//"user_" + id + "userPhoto.png" );
			String[] files = new String[5];
			for(int i = 0; i < 5;i++) {
				File photo = new File(CAR_PHOTO + SEPARATOR + "car_" + id + SEPARATOR + names[i]);
			
				if(!photo.exists()) {
					photo = new File(CAR_PHOTO + SEPARATOR + "default-car-image.png");
				}
			
				files[i] = new String(Base64.encode(FileUtils.readFileToByteArray(photo)));
			}
				
			return files;
		}
	
	public static String getMainCarPhoto(Long id, String names[]) throws IOException {
		//	File photo = new File(USER_FILE + SEPARATOR + "default-user-profile-photo.png"//"user_" + id + "userPhoto.png" );
		String file = null;
		File photo = null;
		for(int i = 0; i < 5;i++) {
			photo = new File(CAR_PHOTO + SEPARATOR + "car_" + id + SEPARATOR + names[i]);
		
			if(photo.exists() && photo != null) {
				file = new String(Base64.encode(FileUtils.readFileToByteArray(photo)));
				return file;	
			}
		}

		if(!photo.exists() || photo == null) 
			photo = new File(CAR_PHOTO + SEPARATOR + "default-car-image.png");
		file = new String(Base64.encode(FileUtils.readFileToByteArray(photo)));
		return file;
		
		
	}
}
