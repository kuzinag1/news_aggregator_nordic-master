package ru.newsfront.app.controller;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.newsfront.app.feign.NewsFeignClient;
import ru.newsfront.app.model.News;
import ru.newsfront.app.service.AtomicIntegerService;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicInteger;


@Controller
@RequiredArgsConstructor
public class NewsController {
    private final NewsFeignClient backEndFeignClient;
    private final AtomicIntegerService atomicIntegerService;

    @GetMapping("/news/main")
    public String getNews(ModelMap modelMap, @RequestParam(value = "numberPage", defaultValue = "0", required = false) String numberPage) {
        News news = backEndFeignClient.getNews(numberPage);
        modelMap.addAttribute("news",news.getNewsFields());
        return "mainpage";
    }
    @PostMapping("/buttons")
    public String nextOrPrevPage(String previous,
                                  String next, HttpServletRequest request) {
        System.out.println(request.getRequestURL());
        if(previous!=null) {
            AtomicInteger pageNumber = atomicIntegerService.decrement();
            if(pageNumber.longValue()<=0L) {
                atomicIntegerService.setAtomicIntegerDefaultValue();
               return "redirect:/news/main?numberPage=0";
            }
           else return "redirect:/news/main?numberPage="+pageNumber;
        }
        return "redirect:/news/main?numberPage="+atomicIntegerService.increment();
    }


    @GetMapping("/")
    public String redirect() {
        return "redirect:/auth/login";
    }

    @GetMapping("/mynews")
    public String getPageHelloWorld() {
        return "redirect:/news/main";
    }
    @GetMapping("/privacy")
    public String getPagePrivacy() {
        return "privacy";
    }

    @GetMapping("/terms")
    public String getPageTerms() {
        return "terms";
    }
}
