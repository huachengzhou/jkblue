package cn.blue.jk.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.UnsupportedEncodingException;

public class DownloadUtil {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public  ResponseEntity<byte[]> createResponse(String fileName, byte[] bodys) {
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<byte[]> responseEntity = null;
        String downloadFileName = null;
        try {
            downloadFileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            logger.error("抛出异常:" + e.getMessage());
        }
        //解决下载显示的文件名问题
        headers.setContentDispositionFormData("attachment", downloadFileName);
        //二进制流数据(最常见的文件下载)
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        responseEntity = new ResponseEntity<byte[]>(bodys, headers, HttpStatus.CREATED);
        return responseEntity;
    }
}
