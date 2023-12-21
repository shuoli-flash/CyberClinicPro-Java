package com.shuo.userserver.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JwtUtil {

    /****
     * 默认为10天的token
     * @param uid String
     * @param openid String
     * @return String
     */
    public static String createToken(String uid,String openid){
        String token;
        token= JWT.create().withClaim("uid",uid)
                .withClaim("generatetime",System.currentTimeMillis())
                .withClaim("exptime",1000*1*60*60*24*10)//设置token过期时间为10天
                .sign(Algorithm.HMAC256(openid));
        return token;
    }

    /****
     * 自定义有效时长的token
     * @param uid String
     * @param account String
     * @param liveTime Long
     * @return String
     */
    public static String createToken(String uid,String account,Long liveTime){
        String token;
        token= JWT.create().withClaim("uid",uid)
                .withClaim("generatetime",System.currentTimeMillis())
                .withClaim("exptime",liveTime)//设置token过期时间为10天
                .sign(Algorithm.HMAC256(account));
        return token;
    }
    /****
     * 返回参数
     * true：toke有效
     * false：token无效
     * @param token String
     * @return boolean
     */
    public static boolean decodeToken(String token){
        Long currentTime = System.currentTimeMillis();
        try {
            Long generateTime = JWT.decode(token).getClaim("generatetime").asLong();
            Long expTime = JWT.decode(token).getClaim("exptime").asLong();
            if(currentTime - generateTime > expTime){
                return false;
            }
            else return true;
        }catch (Exception e){
            return true;
        }
    }
}
