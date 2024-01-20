package backend.springBoard.Domain.State;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class LoginState {

    private Boolean state;
    private String cause;
    private String tokenKey;

    @Builder
    public LoginState(Boolean state, String cause) {
        this.state = state;
        this.cause = cause;
    }
}
