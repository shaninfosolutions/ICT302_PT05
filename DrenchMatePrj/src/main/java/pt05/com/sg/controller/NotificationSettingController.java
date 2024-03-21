package pt05.com.sg.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "${spring.mvc.cors.allowed-origins}")
@RestController
@RequestMapping("api/v1")
public class NotificationSettingController {

}
