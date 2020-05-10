package com.example.jwtdemo;

import com.example.jwtdemo.model.AuthenticateRequest;
import com.example.jwtdemo.model.AuthenticateResponse;
import com.example.jwtdemo.util.JwtTokenUtil;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    MyUserDetailsService myUserDetailsService;
    @Autowired
    JwtTokenUtil jwtTokenUtil;


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> autheticateRequest(@RequestBody AuthenticateRequest authenticateRequest){

        /* loadUser details depends on application logic.here created Userdetails object with test data
        * */
       UserDetails userDetails =  myUserDetailsService.loadUserByUsername(authenticateRequest.getUserName());
       String jwt  = jwtTokenUtil.generateToken(userDetails);
        return new ResponseEntity<>(new AuthenticateResponse(jwt), HttpStatus.OK);
    }
}
