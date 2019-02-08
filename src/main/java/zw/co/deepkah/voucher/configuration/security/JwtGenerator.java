package zw.co.deepkah.voucher.configuration.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.security.User;

@Component
public class JwtGenerator {


    public String generate(User user) {


        Claims claims = Jwts.claims()
                .setSubject(user.getUsername());
        claims.put("userId", String.valueOf(user.getId()));
        claims.put("role", user.getRolesSet());


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "vms@20!8@#")
                .compact();
    }
}
