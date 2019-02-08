package zw.co.deepkah.voucher.configuration.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.security.Roles;
import zw.co.deepkah.voucher.document.security.User;

import java.util.Set;

@Component
public class JwtValidator {


    private String secret = "vms@20!8@#";

    public User validate(String token) {

        User user = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            user = new User();

            user.setUsername(body.getSubject());
            user.setId(String.valueOf(body.get("userId")));
            user.setRolesSet((Set<Roles>) body.get("role"));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return user;
    }
}
