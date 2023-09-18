package org.galapagos.controller;

import lombok.extern.log4j.Log4j;
import org.galapagos.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j
@RequestMapping("/travel")
public class TravelController {

    @Autowired
    private TravelService travelService;
}
