package backend.springBoard.Repository;


import backend.springBoard.Domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {

    String findByPassword(String memberId);
}
