package backend.springBoard.Domain.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {

    private String title;

    private String writer;

    private String content;
}
