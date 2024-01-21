package backend.springBoard.Service;


import backend.springBoard.Domain.Board;
import backend.springBoard.Domain.DTO.BoardDto;
import backend.springBoard.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public void createBoard(Board board){
        boardRepository.save(board);
    }

    /**
     * 제목으로 게시글 찾기?
     * @param title
     * @return
     */
    public BoardDto findBoardByTitle(String title){
        if(boardRepository.existsByTitle(title)){
            Board board = boardRepository.findByTitle(title);

            return BoardDto.builder()
                    .title(board.getTitle())
                    .writer(board.getWriter())
                    .content(board.getContent())
                    .build();
        }
        return new BoardDto();
    }
    public void deleteBoard(Long id){
    }

}
