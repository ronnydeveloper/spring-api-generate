package core.api.generate.springapigenerate.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/table03")
public class Table03Controller {

    final static Logger logger = Logger.getLogger(Table03Controller.class);

    @RequestMapping(value="/content", method = RequestMethod.GET)
    public ModelAndView doView() {
        logger.info("Call doView");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fico/table03 :: content");
        return modelAndView;
    }
} 