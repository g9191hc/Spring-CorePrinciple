package spring.corePrinciples.repository;

import org.springframework.stereotype.Repository;
import spring.corePrinciples.member.Member;

import java.util.HashMap;
import java.util.Map;
@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
