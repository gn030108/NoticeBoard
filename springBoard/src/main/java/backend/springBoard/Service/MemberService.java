package backend.springBoard.Service;

import backend.springBoard.Domain.Member;
import backend.springBoard.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    //회원가입
    public void createMember(String name, String memberId, String pw){
        Member newMember = Member.builder()
                .name(name)
                .memberId(memberId)
                .password(pw)
                .build();
        memberRepository.save(newMember);
    }
    //로그인 -> 로그인시 uuid토큰을 반환하도록.
    public void login(String memberId, String pw){
        String byPassword = memberRepository.findByPassword(memberId);
        if(byPassword.equals(pw)){
            //DB저장된 pw와 입력된 pw가 같을경우 로그인성공.

        }
    }


}
