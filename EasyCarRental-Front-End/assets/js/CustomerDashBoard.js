$("#customerProfilePage").css("display","block");
$("#bookingRequestPage").css("display","none");
$("#bookingResponsePage").css("display","none");
$("#paymentPage").css("display","none");

$("#linkProfile").click(function () {
    $("#customerProfilePage").css("display","block");
    $("#bookingRequestPage").css("display","none");
    $("#bookingResponsePage").css("display","none");
    $("#paymentPage").css("display","none");
});

$("#linkBookingRequest").click(function () {
    $("#customerProfilePage").css("display","none");
    $("#bookingRequestPage").css("display","block");
    $("#bookingResponsePage").css("display","none");
    $("#paymentPage").css("display","none");
});

$("#linkBookingResponse").click(function () {
    $("#customerProfilePage").css("display","none");
    $("#bookingRequestPage").css("display","none");
    $("#bookingResponsePage").css("display","block");
    $("#paymentPage").css("display","none");
});

$("#linkPayment").click(function () {
    $("#customerProfilePage").css("display","none");
    $("#bookingRequestPage").css("display","none");
    $("#bookingResponsePage").css("display","none");
    $("#paymentPage").css("display","block");
});