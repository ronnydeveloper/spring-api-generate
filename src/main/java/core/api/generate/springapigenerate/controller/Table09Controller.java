package core.api.generate.springapigenerate.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/table09")
public class Table09Controller {

    final static Logger logger = Logger.getLogger(Table09Controller.class);

    @RequestMapping(value="/content", method = RequestMethod.GET)
    public ModelAndView doView() {
        logger.info("Call doView");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fico/table09 :: content");
        return modelAndView;
    }
} 