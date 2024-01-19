package backend.springBoard.Domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Token {

    Long createTokenTime;
    String token;
    String memberId;

    @Builder
    public Token(Long createTokenTime, String token, String memberId) {
        this.createTokenTime = createTokenTime;
        this.token = token;
        this.memberId = memberId;
    }
}

//초 : / 1000
//분 : / (1000 * 60)
//시 : / (1000 * 60 * 60)