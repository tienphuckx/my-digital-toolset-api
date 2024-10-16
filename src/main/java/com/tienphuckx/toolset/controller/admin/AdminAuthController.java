//package com.tienphuckx.toolset.controller.admin;
//
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    private final AuthenticationManager authenticationManager;
//    private final JwtUtil jwtUtil;
//    private final UserDetailsService userDetailsService;
//    private final PasswordEncoder passwordEncoder;
//    private final UserRepository userRepository;
//
//    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
//                          UserDetailsService userDetailsService, PasswordEncoder passwordEncoder,
//                          UserRepository userRepository) {
//        this.authenticationManager = authenticationManager;
//        this.jwtUtil = jwtUtil;
//        this.userDetailsService = userDetailsService;
//        this.passwordEncoder = passwordEncoder;
//        this.userRepository = userRepository;
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
//        );
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
//        final String jwt = jwtUtil.generateToken(userDetails);
//        return ResponseEntity.ok(new AuthResponse(jwt));
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
//        User user = new User();
//        user.setUsername(request.getUsername());
//        user.setPassword(passwordEncoder.encode(request.getPassword()));
//        user.setRole(User.Role.USER);  // Default role USER
//        userRepository.save(user);
//        return ResponseEntity.ok("User registered successfully");
//    }
//
//    @PostMapping("/refresh-token")
//    public ResponseEntity<?> refreshToken(@RequestHeader("Authorization") String token) {
//        String jwt = token.substring(7);
//        String username = jwtUtil.extractUsername(jwt);
//        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//        if (jwtUtil.validateToken(jwt, userDetails)) {
//            String newToken = jwtUtil.generateToken(userDetails);
//            return ResponseEntity.ok(new AuthResponse(newToken));
//        }
//        return ResponseEntity.badRequest().body("Invalid token");
//    }
//}
//
//class AuthRequest {
//    private String username;
//    private String password;
//    // Getters and setters
//}
//
//class RegisterRequest {
//    private String username;
//    private String password;
//    // Getters and setters
//}
//
//class AuthResponse {
//    private String token;
//    public AuthResponse(String token) {
//        this.token = token;
//    }
//    // Getter
//}
