package backend.springBoard.Domain.State;

import backend.springBoard.Domain.DTO.MemberResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RegisterState {
    private Boolean state;
    private String cause;
    private MemberResponseDto memberResponseDto;

    public RegisterState(Boolean state, String cause) {
        this.state = state;
        this.cause = cause;
    }
}
