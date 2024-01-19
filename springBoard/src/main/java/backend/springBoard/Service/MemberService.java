package backend.springBoard.Service;

import backend.springBoard.Domain.Member;
import backend.springBoard.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final TokenProvider tokenProvider;

    /**
     * 회원가입
     * @param name 회원 이름
     * @param memberId 회원의 아이디
     * @param pw 회원의 비밀번호
     */
    public void createMember(String name, String memberId, String pw){
        Member newMember = Member.builder()
                .name(name)
                .memberId(memberId)
                .password(pw)
                .build();
        memberRepository.save(newMember);
    }
    //로그인 -> 로그인시 uuid토큰을 반환하도록.

    /**
     * 회원의 일반 로그인
     * @param memberId 회원 아이디
     * @param pw 회원 비밀번호
     * @return 일반 로그인 성공시 token 키값 반환. 실패시 null
     */
    public String login(String memberId, String pw){
        String byPassword = memberRepository.findByPassword(memberId);
        if(byPassword.equals(pw)){
            //DB저장된 pw와 입력된 pw가 같을경우 로그인성공.
            return tokenProvider.createToken(memberId);
        }
        return "null";
    }

    /**
     * 토큰을 주면 로그인 유효시간이 남았는지 검사하는 메서드.
     * @param token 토큰 키값
     * @return 인증성공시 true, 예외발생시 false;
     */
    public Boolean tokenLogin(String token){
        return tokenProvider.validToken(token);
    }


}
