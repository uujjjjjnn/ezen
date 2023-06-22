package com.lec.todo.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.lec.todo.model.UserEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TokenProvider {

	private static final String SECRET_KEY = "XxRpX30pMqDbiAkmlfArbrmVkDD4RqXxskGZmBFax5oGVxzXXWUzTR5JyskiHMIV9M1Oicegkpi46AdvrcX1E6CmTUBc6IFbTPiD";
	
	public String create(UserEntity userEntity) {
		// token�� ��ȿ�Ⱓ ����
		Date expireDate = Date.from(Instant.now().plus(1, ChronoUnit.DAYS));
		
		// jwt token�� ����
		return Jwts.builder()
				.signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY))) // header�� ����� ���� �� ������ ���� SECRET_KEY
				.setSubject(userEntity.getId()) // payload�� �� ����
				.setIssuer("Todo Application")  // token �߱���
				.setIssuedAt(new Date()) 		// token �߱���
				.setExpiration(expireDate) 		// token ��ȿ�Ⱓ
				.compact();
	}
	
	public String validateAndGetUserId(String token) {
		// ����� ���̷ε带 setSigningKey�� �Ѿ�� ��ũ��Ű�� �̿��� ������ �Ŀ� 
		// token�� ����� ��. �������� ���� �ʾҴٸ� ���̷ε�(claims)�� ����
		// �ƴ϶�� ���ܸ� �߻�����, ��������� �� userId�� �ʿ��ϱ� ������ getBody()�� ȣ��
		Claims claims = Jwts.parserBuilder()
				.setSigningKey(Decoders.BASE64.decode(SECRET_KEY))
				.build()
				.parseClaimsJws(token)
				.getBody();
		return claims.getSubject();
	}
}
