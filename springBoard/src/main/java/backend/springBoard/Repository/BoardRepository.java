package backend.springBoard.Repository;


import backend.springBoard.Domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {

    Board findByTitle(String title);

    Board findByWriter(String writer);

    Boolean existsByTitle(String title);

    Boolean existsByWriter(String writer);


}
