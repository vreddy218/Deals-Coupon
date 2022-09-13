package com.example.demo.jwtFilters;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtils {
	private static final String SECRET_KEY="simple";
	
	public String generateToken(UserDetails userDetails)
	{
		Map<String,Object> claims=new HashMap<>();
		return createToken(claims,userDetails.getUsername());
	}
	
	public Boolean validateToken(String token,UserDetails userDetails)
	{
		String userName=extractUsername(token);
		return userName.equals(userDetails.getUsername())&& !isTokenExpired(token);
	}
	

	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	private Date extractExpiration(String token) {
		return extractClaim(token,Claims::getExpiration);
	}

	public String extractUsername(String token) {
		return extractClaim(token,Claims::getSubject);
	}

	private String createToken(Map<String, Object> claims, String subject) {
		
	Date now=new Date(System.currentTimeMillis());
	Date until=new Date(System.currentTimeMillis()+1000*60*60*10);
	return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(now).setExpiration(until)
			.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	
	}
	
	public <T> T extractClaim(String token,Function<Claims, T> claimsResolver)
	{
		final Claims claims=extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
}