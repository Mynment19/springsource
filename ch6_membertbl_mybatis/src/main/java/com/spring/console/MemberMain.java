package com.spring.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.MemberDTO;
import com.spring.service.MemberService;

public class MemberMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");		
		MemberService service = (MemberService) ctx.getBean("member");
		
//		MemberDTO dto = new MemberDTO();		
		//삽입
//		dto.setUserid("mynment19");
//		dto.setPassword("1234");
//		dto.setName("박정현");
//		dto.setGender("man");
//		dto.setEmail("mynment19@gmail.com");
//		if(service.insertMember(dto)) {
//			System.out.println("회원 가입 성공");
//		}
		
		
		//삭제
//		if(service.deleteMember("mynment19", "1234")) {
//			System.out.println("회원 탈퇴 성공");
//		}
//		
//		
//		
//		//수정
		MemberDTO updateDto = new MemberDTO();
		updateDto.setUserid("hong123");
		updateDto.setPassword("hong123@");
		updateDto.setEmail("coryo0628@naver.com");
		System.out.println(service.updateMember(updateDto)?"수정성공":"수정실패");
//		
//		
//		//조회
//		System.out.println(service.getRow("mynment19", "1234"));
//		
//		List<MemberDTO> list = service.getRows();
//		for (MemberDTO memberDTO : list) {
//			System.out.println(memberDTO);
//		}
		
		
		
	}

}
