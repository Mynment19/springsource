package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.domain.AuthDTO;
import com.spring.domain.ChangeDTO;
import com.spring.domain.LoginDTO;
import com.spring.domain.MemberDTO;
import com.spring.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mapper;
	@Autowired
	private BCryptPasswordEncoder bPasswordEncoder;
	
	//로그인
	@Override
	public AuthDTO login(LoginDTO loginDTO) {	
		// 1234 ==> bPasswordEncoder.encode(1234) ==> 암호화
		// matches(암호화하기 전 코드, 암호화 된 코드)
		// matches(1234, db 암호화 된 코드)
		
		// 비밀번호가 일치하는가?
		// db에서 암호화된 비번 가져오기
		String encodePass = mapper.getPass(loginDTO.getUserid());
		
		if (bPasswordEncoder.matches(loginDTO.getPassword(), encodePass)) {
			return mapper.login(loginDTO.getUserid());			
		}else {
			return null;
		}
		
	}
	
	// 회원가입
	@Override
	public boolean register(MemberDTO memberDTO) {
		// 비밀번호 암호화 : encode(암호화할 원본 코드)
		//				matches(암화하기 전, 암호화 코드)
		memberDTO.setPassword(bPasswordEncoder.encode(memberDTO.getPassword()));
		return mapper.insert(memberDTO)==1?true:false;
	}
	
	
	// 중복 아이디 체크
	@Override
	public boolean dupId(String userid) {
		return mapper.dupId(userid) == 0 ? true:false;
	}



	@Override
	public boolean remove(LoginDTO loginDTO) {
		
		// 비밀번호 확인
		String encodePass = mapper.getPass(loginDTO.getUserid());
		
		if(bPasswordEncoder.matches(loginDTO.getPassword(), encodePass)) {
			return mapper.leave(loginDTO.getUserid()) == 1 ? true:false ;	
		}
		return false;
	}

	@Override
	public boolean change(ChangeDTO changeDTO) {
		String encodePass = mapper.getPass(changeDTO.getUserid());
		
		if(bPasswordEncoder.matches(changeDTO.getCurrentPassword(), encodePass)) {
			// 변경 비밀번호 암호화
			changeDTO.setNewPassword(bPasswordEncoder.encode(changeDTO.getConfirmPassword()));
			
			return mapper.change(changeDTO) == 1 ? true:false ;	
		}
		
		return false;
	}
	
	

	
	


	



}
