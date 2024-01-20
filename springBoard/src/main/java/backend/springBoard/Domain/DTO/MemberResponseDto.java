package backend.springBoard.Domain.DTO;


import backend.springBoard.Domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResponseDto {
    private String name;
    private String userId;

    public static MemberResponseDto of(Member member){
        return MemberResponseDto.builder()
                .name(member.getName())
                .userId(member.getMemberId())
                .build();
    }
}
