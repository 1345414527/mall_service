package top.codekiller.mall.controller.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @author codekiller
 * @date 2021/7/14 10:15
 * @Description 用于文件上传
 */
@Controller
@Slf4j
public class FileController extends BaseController{

    @RequestMapping("/product/logo")
    public void logo(MultipartFile file, HttpServletResponse resp) {
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);

        String path = this.getClass().getResource("/").getPath();
        String mall_path = path.substring(1, path.indexOf("/mall/") + 6);
        String img_path = mall_path+"src/main/resources/img/"+fileName;

        try {
            System.out.println(img_path);
            file.transferTo(new File(img_path));
        } catch (Exception e) {
            log.error("路径错误！"+img_path);
        }
        // 输出图片路径给页面，少了D:/create，为什么要少了这个东西?
        outRespJson("/img/"+fileName, resp);
    }

}
