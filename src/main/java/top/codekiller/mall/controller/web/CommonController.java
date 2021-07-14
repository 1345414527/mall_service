package top.codekiller.mall.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author codekiller
 * @date 2021/7/14 14:59
 * @Description TODO
 */
@Controller
@RequestMapping("toPage")
public class CommonController {

    @RequestMapping("/{page}")
    public String toPage(@PathVariable String page){
        return page;
    }
}
