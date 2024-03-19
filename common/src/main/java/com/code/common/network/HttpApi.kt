package com.code.common.network

import com.code.common.network.support.IHttpCallback

/**
 * 网络请求的统一接口类
 */
interface HttpApi {

    /**
     *抽象的http的get请求封装，异步
     */
    fun get(params:Map<String,Any>,path:String,callback: IHttpCallback)

    /**
     *抽象的http的get请求封装，同步
     */
    fun getSync(params:Map<String,Any>,path:String):Any?


    /**
     *抽象的http的post请求封装，异步
     */
    fun post(body:Any,path:String,callback: IHttpCallback)

    /**
     *抽象的http的post请求封装，同步
     */
    fun postSync(body:Any,path:String):Any?

    /**
     * 取消某个请求
     */
    fun cancelRequest(tag:Any)

    /**
     * 取消所有请求
     */
    fun cancelAllRequest()






}