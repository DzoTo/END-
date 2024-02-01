package kz.singularity.bankappdelivery.auth;

import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import kz.singularity.bankappdelivery.model.user.User;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {
    private final String secret_key = "mysecretkey";
    private long accessTokenValidity = 60*60*1000;
    private final JwtParser jwtParser;

    private final String Token_Header = "Authorization";
    private final String Token_Prefix = "Bearer ";

    public JwtUtil(){
        this.jwtParser = Jwts.parser().setSigningKey(secret_key);
    }

    public String createToken(User user){
        Claims claims = Jwts.claims().setSubject(user.getUsername());
//        claims.put("firstname", user.getFirstname());
//        claims.put("lastname", user.getLastname());
        Date tokenCreateTime = new Date();
        Date tokenValidity = new Date(tokenCreateTime.getTime() + TimeUnit.MINUTES.toMillis(accessTokenValidity));
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(tokenValidity)
                .signWith(SignatureAlgorithm.HS256, secret_key)
                .compact();
    }

    private Claims parseJwtClaims(String token){
        return jwtParser.parseClaimsJws(token).getBody();
    }

    public Claims resolveClaims(HttpServletRequest request){
        try {
            String token = resolveToken(request);
            if(token != null){
                return parseJwtClaims(token);
            }
            return null;
        }catch (ExpiredJwtException ex){
            request.setAttribute("expired", ex.getMessage());
            throw ex;
        }catch (Exception ex){
            request.setAttribute("invalid", ex.getMessage());
            throw ex;
        }
    }

    public String resolveToken(HttpServletRequest request) {

        String bearerToken = request.getHeader(Token_Header);
        if (bearerToken != null && bearerToken.startsWith(Token_Prefix)) {
            return bearerToken.substring(Token_Prefix.length());
        }
        return null;
    }

    public boolean validateClaims(Claims claims) throws AuthenticationException {
        try {
            return claims.getExpiration().after(new Date());
        } catch (Exception e) {
            throw e;
        }
    }

    public String getUsername(Claims claims) {
        return claims.getSubject();
    }

    private List<String> getRoles(Claims claims) {
        return (List<String>) claims.get("roles");
    }

}
