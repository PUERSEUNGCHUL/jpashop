package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired private MemberService memberService;
    @Autowired private MemberRepository memberRepository;

    @Test
    public void join() throws Exception {

        //given
        Member member = new Member();
        member.setName("LEE");

        //when
        Long memberId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findMember(memberId));

    }

    @Test
    public void duplicated_join() throws Exception {

        //given
        Member member1 = new Member();
        member1.setName("LEE");

        Member member2 = new Member();
        member2.setName("LEE");

        //when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> {

            memberService.join(member2);
        });

        //then
    }

}