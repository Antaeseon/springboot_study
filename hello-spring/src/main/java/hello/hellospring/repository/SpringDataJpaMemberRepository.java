package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


// 자동으로 bean을 만들어준다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>,MemberRepository {
    @Override
    // select m from member m where m.name = ? 이러한 식으로 자동으로 jpql로 짜준다.
    Optional<Member> findByName(String name);
}
