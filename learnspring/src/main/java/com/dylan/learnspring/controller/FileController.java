package com.dylan.learnspring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @author Dylan
 * @Date : 2021/6/5 - 10:56
 * @Description : 文件管理
 * @Function :
 */
@RestController
@RequestMapping("file")
public class FileController {

    @RequestMapping("download")
    public void downloadFile(String fileName, HttpServletResponse response){
        File file = new File(fileName);
        if (!file.exists()){

        }
    }



}
