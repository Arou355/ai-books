package com.example.AIBooks.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class authController {

  private final AuthenticationService service;

  @PostMapping("/signup")
  public ResponseEntity<ARes> signup(
      @RequestBody AccountReq request
  ) {
    return ResponseEntity.ok(service.signup(request));
  }
  @PostMapping("/signin")
  public ResponseEntity<ARes> signin(
      @RequestBody LogInReq request
  ) {
    return ResponseEntity.ok(service.signin(request));
  }


}
