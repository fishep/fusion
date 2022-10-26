import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.security.Key;
import java.time.Instant;
import java.util.Date;

public class JwtTest {

    static private String key = "12345678123456781234567812345678";

    static private String token = "token";

    @Test
    void jwt() {

        System.out.println("hello jwt");

        {
            // We need a signing key, so we'll create one just for this example. Usually
            // the key would be read from your application configuration instead.
            Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
            String jws = Jwts.builder().setSubject("test").signWith(key).compact();

            System.out.println("key: " + key);
            System.out.println("jws: " + jws);

            assert Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jws).getBody().getSubject().equals("test");
        }

        {
            SecretKey sKey = Keys.hmacShaKeyFor(key.getBytes());

            JwtBuilder builder = Jwts.builder();
            builder.setSubject("test");
            builder.setExpiration(Date.from(Instant.now().plusSeconds(30)));
            builder.claim("hello", "world");
            builder.signWith(sKey);
            String jws = builder.compact();

            System.out.println("key: " + key);
            System.out.println("sKey: " + sKey);
            System.out.println("jws: " + jws);

            try {
                Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(sKey).build().parseClaimsJws(jws);

                //OK, we can trust this JWT
                JwsHeader header = claimsJws.getHeader();
                Claims body = claimsJws.getBody();
                String subject = body.getSubject();
                Date expiration = body.getExpiration();
                String hello = body.get("hello", String.class);
                String signature = claimsJws.getSignature();

            } catch (JwtException e) {
                //don't trust the JWT!
                System.out.println(e.getMessage());
            }
        }

    }


}
