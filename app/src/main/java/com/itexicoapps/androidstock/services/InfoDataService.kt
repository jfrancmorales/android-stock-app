package com.itexicoapps.androidstock.services

import retrofit2.http.*

interface InfoDataService {

    @POST("/WebService/SSOAuthService.cfc")
    fun getApiKey(@Query("TypeId") typeId: String,
                  @Query("method") method: String,
                  @Query("APIKey") ApiKey: String,
                  @Query("ID") loanId: String)

    @POST ("/index.cfm/ssokey/format/json")
    fun getSsoPacket(@Body AuthenticationKey: String)

    @POST ("/index.cfm/authentication/getauthtoken/format/json")
    fun getSsoToken(@Body AuthenticationKey: String)

    @POST("/index.cfm/loans/{loanNumber}/accountinformation")
    fun getAccountInfo(@Path("loanNumber") loadNumber: String, @Body AuthenticationKey: String)

    @POST("/index.cfm/loans/{loanNumber}/balance")
    fun getLoanBalance(@Path("loanNumber") loadNumber: String, @Body AuthenticationKey: String)

    @POST("/index.cfm/loans/{loanNumber}/paymenthistory")
    fun getPaymentHistory(@Path("loanNumber") loadNumber: String, @Body AuthenticationKey: String)

    @POST("/index.cfm/loans/{loanNumber}/scheduledpayment")
    fun getPaymentHistoryDetail(@Path("loanNumber") loadNumber: String, @Body AuthenticationKey: String)

    @POST("/index.cfm/loans/{loanNumber}/paymenthistorydetail/{paymentId}")
    fun getScheduledPayment(@Path("loanNumber") loadNumber: String, @Path("paymentId") paymentId: String,
                            @Body AuthenticationKey: String)

    @POST("/index.cfm/loans/{loanNumber}/paymentinformation")
    fun getPaymentInformation(@Path("loanNumber") loadNumber: String, @Body AuthenticationKey: String)

    // Example how to use @Field Map to add several Query Params
    @GET("/index.cfm/ssokey/format/json")
    @FormUrlEncoded
    fun getUserInformationExample1(@FieldMap params: Map<String, String>)

}