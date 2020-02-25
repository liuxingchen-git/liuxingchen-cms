package com.liuxingchen.cms.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

public class ImageUtil {

	public String ImageUpload(MultipartFile file,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		String savePaths = "";
		if(file!=null) {
			String path = null;
			String type = null;
			String fileName = file.getOriginalFilename();
			System.out.println("上传文件原名称:"+fileName);
			type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1,fileName.length()):null;
			if(type!=null) {
				if("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
					String realPath = request.getSession().getServletContext().getRealPath("/");
					String trueFileName = String.valueOf(System.currentTimeMillis())+fileName;
					path = realPath+trueFileName;
					System.out.println("存放图片文件的路径"+path);
					file.transferTo(new File(path));
					savePaths = path;
				}else {
					System.out.println("不是我们想要的文件类型，请按要求上传类型!");
					return null;
				}
			}else {
				System.out.println("文件类型为空");
				return null;
			}
		}else {
			System.out.println("没有找到对应的文件");
			return null;
		}
		return savePaths;
	}
	
}
