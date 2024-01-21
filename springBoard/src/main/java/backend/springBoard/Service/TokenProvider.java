package backend.springBoard.Service;

import backend.springBoard.Domain.Token;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.UUID;
@Component
public class TokenProvider {

    long duration = 30;

    HashMap<String,Token> tokenStorage = new HashMap<>();

    /**
     * 토큰 생성 메서드. uuid, 현재시간, memberId가 들어있는 Token을 생성후 hashMap에서 관리한다.
     * @param memberId 회원의 아이디
     * @return String 형태의 tokenUUID
     */
    public String createToken(String memberId){

        String uuid = memberId+UUID.randomUUID().toString();

        LocalTime now = LocalTime.now();
        long second = now.getLong(ChronoField.SECOND_OF_DAY);

        Token token = Token.builder()
                .memberId(memberId)
                .token(uuid)
                .memberId(memberId)
                .build();
        tokenStorage.put(uuid,token);
        return uuid;

    }

    /**
     * 토큰검사. tokenKey를 주면 유효시간을 검사한다. 기본적으로 하루시간중 몇분이나 지났는지를 따지기때문에
     * 여기서 다음날로 넘어간다거나 하면 오류가 생길수도..??
     * @param tokenKey 해당하는 토큰의 키값
     * @return 유효시간이 있다면 true, 아닐경우 false;
     */
    public Boolean validToken(String tokenKey){

        if(tokenStorage.containsKey(tokenKey)){
            //해당하는 키가 있는경우
            Token token = tokenStorage.get(tokenKey);

            LocalTime now = LocalTime.now();
            long nowSecond = now.getLong(ChronoField.SECOND_OF_DAY);

            //유효시간이 정해진 시간보다는 적으면서 0보다는 클경우.
            return nowSecond - token.getCreateTokenTime() <= duration && nowSecond - token.getCreateTokenTime() >= 0;
        }

        return false;
    }

}
