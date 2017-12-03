package ru.frank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.frank.model.VkMessage;

@Controller
public class DefaultController {

    @RequestMapping(value = "/callback", method = RequestMethod.POST, consumes = {"application/json"})
    public ResponseEntity<VkMessage> getDefaultResponse(@RequestBody VkMessage incomingMessage){

//        if(incomingMessage != null){
//            incomingMessage.setMessage(incomingMessage.getMessage() + " DAT RESPONSE!");
//        }

        return new ResponseEntity<VkMessage>(incomingMessage, HttpStatus.OK);
    }
}
