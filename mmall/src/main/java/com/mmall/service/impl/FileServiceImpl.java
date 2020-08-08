package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author arbonkeep
 * @date 2020/8/6 - 14:51
 */
@Service("iFileService")

public class FileServiceImpl implements IFileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    /**
     * 上传文件
     * @param file
     * @param path
     * @return
     */
    public String upload(MultipartFile file, String path) {
        String fileName = file.getOriginalFilename();//获取原始文件名
        //扩展名   abc.jpg
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        //此处截取从后向前数到第一个.的后面内容(即.jpg),+1表示不需要.最终结果为jpg
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;//文件名，使用UUID防止重复

        logger.info("开始上传文件，上传的文件名为:{},上传的路径为:{},新文件名为:{}", fileName, path, uploadFileName);//打印日志

        File fileDir = new File(path);
        if (!fileDir.exists()) {
            fileDir.setWritable(true);//赋予可写权限
            fileDir.mkdirs();
        }

        File targetFile = new File(path,uploadFileName);

        try {
            //文件上传
            file.transferTo(targetFile);

            //将targetFile上传到ftp服务器
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));

            //上传成功后，删除webapp下的upload文件夹
            targetFile.delete();


        } catch (IOException e) {
            logger.error("上传文件异常",e);
            return null;
        }

        return targetFile.getName();

    }


}
