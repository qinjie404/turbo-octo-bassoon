package com.fulan.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @author 13862
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping("/index")
    public String uploadPage(){
        return "uploadPage";
    }

    @RequestMapping("/realUpload")
    @ResponseBody
    public String upLoad(HttpServletRequest request,MultipartFile file){
        try {
            //上传目录地址
            String uploadDir=request.getSession().getServletContext().getRealPath("/")+"upload/";
            File dir=new File(uploadDir);
            if(!dir.exists()){
                dir.mkdir();
            }
            //上传文件名
            String fileName=file.getOriginalFilename();
            //服务器端保存的文件对象
            File serverFile=new File(uploadDir+fileName);
            file.transferTo(serverFile);
        }catch (Exception e){
            //打印错误信息
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }
}
