package mn.demo.appservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("v1/test")
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @PostMapping(value = "unauthorized")
    private ResponseEntity<?> v1TestUnauthorized(@RequestBody TestUnauthorizedRequest request) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = "{}";
        try {
            json = ow.writeValueAsString(request);
            LOGGER.info("{}", json);
        } catch (Exception ex) {}
        TestUnauthorizedResponse testUnauthorizedResponse = new TestUnauthorizedResponse(request.getBb1()+"edited", request.getBb2()+"edited2");
        return new ResponseEntity<>(testUnauthorizedResponse, HttpStatus.OK);
    }

    @PostMapping(value = "authorized")
    private ResponseEntity<?> v1TestAuthorized(@RequestBody TestUnauthorizedRequest testUnauthorizedRequest) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = "{}";
        try {
            json = ow.writeValueAsString(testUnauthorizedRequest);
            LOGGER.info("{}", json);
        } catch (Exception ex) {}
        TestUnauthorizedResponse testUnauthorizedResponse = new TestUnauthorizedResponse(testUnauthorizedRequest.getBb1()+"edited", testUnauthorizedRequest.getBb2()+"edited2");
        return new ResponseEntity<>(testUnauthorizedResponse, HttpStatus.OK);
    }

}