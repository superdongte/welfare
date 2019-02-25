package com.yi.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	
	public static String uploadFile(String uploadPath, //upload경로
									String originalName, //파일이름
									byte[] fileData) throws IOException {
		
		UUID uid = UUID.randomUUID();//중복되지 않는 고유한 키값을 만듬
		String saveName = uid.toString() + "_" + originalName;
		String savePath = calcPath(uploadPath);
		/*파일업로드되는 코드*/
		File target = new File(uploadPath+savePath, saveName);
		FileCopyUtils.copy(fileData, target);
		//-------
		// Thumbnail이미지
		//-------
		String thumPath = makeThumnail(uploadPath, savePath, saveName);

		return thumPath;
	}
	private static String makeThumnail(String uploadPath, //c:/zzz/upload
									   String path,// /2019/02/13
								       String fileName) throws IOException { //원본파일이름
		
		//원본 이미지의 데이타를 가져와서 가상 이미지를 만듬
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));
		//세로 100크기에 고정하여 가로 너비느 ㄴ자동 조절하도록 하여 thumbnail데이타를 만듬
		BufferedImage destImg = Scalr.resize(sourceImg, 
											Scalr.Method.AUTOMATIC,
											Scalr.Mode.FIT_TO_WIDTH, 200);
		//thumbnail 파일명을 만듬( s_ 를 붙임요)
		String thumbnailName = uploadPath + path + "/" + "s_" + fileName;
		
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		
		//만들어진 thumbnail 파일에 destImg 데이타를 넣음
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		
		return path + "/" + "s_" + fileName;//thumbnail용 파일 주소를 넘김
	}
	
	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		String yearPath = "/" + cal.get(Calendar.YEAR);
		String monthPath = String.format("%s/%02d", yearPath, cal.get(Calendar.MONTH)+1);
		String datePath = String.format("%s/%02d", monthPath, cal.get(Calendar.DATE));//년/월/일
		
		makeDir(uploadPath, yearPath, monthPath, datePath);
		
		return datePath;
	}
	
	private static void makeDir(String uploadPath, String... paths) {
		
		for(String path:paths) {
			File dirPath = new File(uploadPath + path);
			if(dirPath.exists() == false) {
				dirPath.mkdirs();
			}
		}
	}
}
