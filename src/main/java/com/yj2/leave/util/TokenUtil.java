package com.yj2.leave.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.yj2.leave.exception.ExceptionEnum;
import com.yj2.leave.exception.ServiceException;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * token工具类
 */
public final class TokenUtil {

    private final static String SECRET = "defaultSecret";
    private final static long TIME_OUT = 6 * 60 * 60 * 1000L;

    private TokenUtil() {

    }
    public static String createJwt(String accountId) throws IllegalArgumentException {

        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        Algorithm al = Algorithm.HMAC256(SECRET);
        String token = JWT.create().withHeader(map)
                .withIssuer("orange")
                .withSubject(accountId)
                .withClaim("account_id", accountId)
                .withExpiresAt(new Date(System.currentTimeMillis() + TIME_OUT))
                .sign(al);

        return token;
    }

    /**
     * 验证jwt
     */
    public static boolean verifyJwt(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
        } catch (Exception e) {
            throw new ServiceException(ExceptionEnum.TOKEN_EXPIRE);
        }
        return true;
    }

    /**
     * 解析token
     * @param token
     * @return
     */
    public static Map<String, Claim> getClaim(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaims();
        } catch (Exception e) {
            throw new ServiceException(ExceptionEnum.TOKEN_EXPIRE);
        }
    }

    /**
     * 根据Token获取user_id
     *
     * @param token
     * @return user_id
     */
    public static String getaccountIdByToken(String token) {
        Map<String, Claim> claims = getClaim(token);
        Claim user_id_claim = claims.get("account_id");
        if (null == user_id_claim || StringUtils.isEmpty(user_id_claim.asString())) {
            throw new ServiceException(ExceptionEnum.TOKEN_EXPIRE);
        }
        return user_id_claim.asString();
    }
}
