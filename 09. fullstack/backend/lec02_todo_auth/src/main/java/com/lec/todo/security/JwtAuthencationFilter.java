package com.lec.todo.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtAuthencationFilter extends OncePerRequestFilter {
	
	@Autowired
	private TokenProvider tokenProvider;
	
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {

		try {
			// ��û���� token ��������
			String token = parseBearerToken(req);
			System.out.println("token = " + token);
			
			log.info("Filter is Running....");
			
			// ��ū�����ϱ� : JWT�̹Ƿ� �ΰ������� ��û���� �ʰ� ���� ����
			if(token != null && !token.equalsIgnoreCase("null")) {
				// userId��������, �������� ��쿡 ���ܸ� �߻�
				String userId = tokenProvider.validateAndGetUserId(token);
				
				log.info("Authenticated User Id : " + userId);
				
				// �����Ϸ� : SecurityContextHolder�� ����ؾ� ������ ����ڷ� �νĵȴ�.
				AbstractAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userId, // ������ �����ID. ���ڿ��� �ƴϾ �ƹ��ų� ���� ����. ��������� UserDetail��ü�� ����(�� ����)
						null,
						AuthorityUtils.NO_AUTHORITIES);
				
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
				SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
				securityContext.setAuthentication(authentication);
				SecurityContextHolder.setContext(securityContext);
			}
			
		} catch (Exception e) {
			logger.error("Security Context�� ��������� ������ �����ϴ�", e);
		}
		filterChain.doFilter(req, res);
	}

	private String parseBearerToken(HttpServletRequest req) {
		// http��û�� ����� �Ľ��ؼ� Bearer ��ū�� ����
		String bearerToken = req.getHeader("Authorization");
		System.out.println("req.getHeader(Authorization) : " + bearerToken);
		
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7); // "Bearer " �ڿ� ���� token�� ����
		}
		return null;
	}

}
