package com.fulan.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;

/**
 * @author 13862
 */
@Controller
public class DownLoadController {

    @RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
    @ResponseBody
    public void downloadFile(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String downloadPath = req.getSession().getServletContext().getRealPath("/") + "upload/";
        String name = "业务梳理.txt";
        download(res, name, downloadPath);
    }

    private void download(HttpServletResponse res, String name, String downloadPath) throws IOException {
        String filePath = null;
        try {
            filePath = URLDecoder.decode(downloadPath, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String path = filePath + File.separator + name;
        File file = new File(path);
        if (!file.exists()) {
            throw new IOException("文件不存在");
        }
        name = new String(name.getBytes("GBK"), "ISO-8859-1");
        res.reset();
        res.setContentType("application/octet-stream");
        res.setCharacterEncoding("utf-8");
        res.setContentLength((int) file.length());
        res.setHeader("Content-Disposition", "attachment;filename=" + name);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(file));
            int i;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
