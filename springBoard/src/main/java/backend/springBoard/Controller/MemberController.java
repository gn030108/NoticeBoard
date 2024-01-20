package backend.springBoard.Controller;


import backend.springBoard.Domain.Member;
import backend.springBoard.Domain.State.LoginState;
import backend.springBoard.Domain.State.RegisterState;
import backend.springBoard.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;


    @PostMapping("/member/register")
    public ResponseEntity<RegisterState> register(@RequestBody Member newMember){
        RegisterState registerState =
                memberService.createMember(newMember.getName(), newMember.getMemberId(), newMember.getPassword());
        return ResponseEntity.ok(registerState);

    }
    @PostMapping("/member/login")
    public ResponseEntity<LoginState> login(@RequestBody Member member){
        LoginState loginState = memberService.login(member.getMemberId(), member.getPassword());
        return ResponseEntity.ok(loginState);
    }

    @PostMapping("/member/tokenLogin")
    public ResponseEntity<LoginState> tokenLogin(@RequestBody String tokenKey){
        LoginState loginState = memberService.tokenLogin(tokenKey);
        return ResponseEntity.ok(loginState);
    }




}
