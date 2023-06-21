package com.lec.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.todo.model.UserEntity;
import com.lec.todo.persistence.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public UserEntity create(final UserEntity userEntity) {
		if(userEntity == null || userEntity.getUsername() == null) {
			throw new RuntimeException("����� ������ ������ �ֽ��ϴ�!");
		}
		final String username = userEntity.getUsername();
		if(userRepository.existsByUsername(username)) {
			log.warn("������̸��� �̹� �����մϴ�");
			throw new RuntimeException("������̸��� �̹� �����մϴ�");
		}
		return userRepository.save(userEntity);
	}
	
	public UserEntity getByCredentials(final String username, final String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}
	
	
}
