package backend.springBoard.Service;

import backend.springBoard.Domain.DTO.MemberResponseDto;
import backend.springBoard.Domain.Member;
import backend.springBoard.Domain.State.LoginState;
import backend.springBoard.Domain.State.RegisterState;
import backend.springBoard.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final TokenProvider tokenProvider;

    /**
     * 회원가입을 위한 메서드
     * @param name 회원이 이름.
     * @param memberId 회원의 사용아이디
     * @param pw 회원의 비밀번호
     * @return 이미 가입되어있는 userId일경우 RegisterState -> (False,"입력한 아이디가 이미 있는 아이디입니다.")
     *         중복 아이디가 아닐경우 RegisterState -> (True, " 회원가입이 완료되었습니다.")
     */
    public RegisterState createMember(String name, String memberId, String pw){
        Member newMember = Member.builder()
                .name(name)
                .memberId(memberId)
                .password(pw)
                .build();

        if(memberRepository.existsByMemberId(memberId)){    //이미 가입되어 있는 UserId라면?
            return new RegisterState(Boolean.FALSE,"입력한 아이디가 이미 있는 아이디입니다.");
        }
        memberRepository.save(newMember);
        return new RegisterState(Boolean.TRUE,"회원가입이 완료되었습니다.",MemberResponseDto.of(newMember));
    }
    /**
     * 회원의 일반 로그인
     * @param memberId 회원 아이디
     * @param pw 회원 비밀번호
     * @return 일반 로그인 성공시 token 키값 반환. 실패시 null
     */
    public LoginState login(String memberId, String pw){
        String byPassword = memberRepository.findByPassword(memberId);
        if(byPassword.equals(pw)){
            //DB저장된 pw와 입력된 pw가 같을경우 로그인성공.
            return LoginState.builder()
                    .state(Boolean.TRUE)
                    .cause("로그인이 정상적으로 완료되었습니다.")
                    .tokenKey(tokenProvider.createToken(memberId))
                    .build();
        }
        return LoginState.builder()
                .state(Boolean.FALSE)
                .cause("입력된 PW 정보가 다릅니다.")
                .build();
    }

    /**
     * 토큰을 주면 로그인 유효시간이 남았는지 검사하는 메서드.
     * @param token 토큰 키값
     * @return 인증성공시 true, 예외발생시 false;
     */
    public LoginState tokenLogin(String token){

        if(tokenProvider.validToken(token)){
            LoginState loginState = LoginState.builder()
                    .state(Boolean.TRUE)
                    .cause("로그인 성공")
                    .build();
            return loginState;
        }
        return LoginState.builder()
                .state(Boolean.FALSE)
                .cause("토큰 유효기간이 지났거나 일치하지 않습니다.")
                .build();
    }


}
