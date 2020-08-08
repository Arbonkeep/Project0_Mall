package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author arbonkeep
 * @date 2020/8/6 - 14:50
 */
public interface IFileService {
    String upload(MultipartFile file, String path);

}
