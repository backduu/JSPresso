package JSPresso.controller;


import JSPresso.DTO.UserRegisterDTO;
import JSPresso.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signup")
public class SignUpController {
    private final UserService userService;

    @GetMapping
    public String signupForm() {

        return "signup"; // 회원가입 페이지 출력
    }

    @PostMapping
    public String signup(@ModelAttribute("user") UserRegisterDTO userRegisterDTO) {
        userService.signUp(userRegisterDTO);

        return "redirect:/login";
    }
}