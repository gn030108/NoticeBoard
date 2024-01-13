package backend.springBoard.Domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;        //회원명
    private String memberId;    //회원 아이디
    private String password;    //회원 비밀번호


    @Builder
    public Member(String name, String memberId, String password) {
        this.name = name;
        this.memberId = memberId;
        this.password = password;
    }
}
