package com.shop.entity;

import com.shop.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@TestPropertySource("classpath:application-test.properties")
class MemberTest {

    @Autowired
    MemberRepository memberRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("Auditing 테스트")
    @WithMockUser(username = "kim", roles = "user")
    public void auditingTest(){
        Member newMember = new Member();
        Member k = memberRepository.save(newMember);

        System.out.println(k.getCreatedBy());
        em.flush();
        em.clear();

//        Member member = memberRepository.findById(newMember.getId()).orElseThrow(EntityNotFoundException::new);
//
//        System.out.println("register Time : " + member.getRegTime());
//        System.out.println("updated Time : " + member.getUpdateTime());
//        System.out.println("created By : " + member.getCreateBy());
//        System.out.println("modified By : " + member.getModifiedBy());
    }

}