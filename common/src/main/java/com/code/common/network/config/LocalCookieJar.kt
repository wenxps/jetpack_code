package com.code.common.network.config

import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

/**
 * 用于持久化 cookieJar 实现类
 */
class LocalCookieJar : CookieJar{

    // cookie 本地化存储
    private val cache = mutableListOf<Cookie>()
    override fun loadForRequest(url: HttpUrl): List<Cookie> {

        // 过期的 Cookie
        val invalidCookies: MutableList<Cookie> = ArrayList()
        // 有效的 Cookies
        val validCookies:MutableList<Cookie> = ArrayList()

        for (cookie in cache){
            if (cookie.expiresAt < System.currentTimeMillis()){
                //判断是否过期
                invalidCookies.add(cookie)
            }else if(cookie.matches(url)){
                //匹配cookie对应的url
                validCookies.add(cookie)
            }
        }
        // 缓存中移除过期的 Cookie
        cache.removeAll(invalidCookies)
        // 返回 List<Cookie> 让 request 进行设置
        return validCookies
    }

    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        cache.addAll(cookies)
    }


}