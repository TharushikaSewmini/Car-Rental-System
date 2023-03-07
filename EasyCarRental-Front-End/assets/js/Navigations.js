$("#dashBoardPage").css("display","block");
$("#carPage").css("display","none");
$("#customerPage").css("display","none");
$("#driverPage").css("display","none");
$("#bookingPage").css("display","none");
$("#bookingRequestPage").css("display","none");
$("#paymentPage").css("display","none");

$("#linkDashBoard").click(function () {
    $("#dashBoardPage").css("display","block");
    $("#carPage").css("display","none");
    $("#customerPage").css("display","none");
    $("#driverPage").css("display","none");
    $("#bookingPage").css("display","none");
    $("#bookingRequestPage").css("display","none");
    $("#paymentPage").css("display","none");
});

$("#linkCars").click(function () {
    $("#dashBoardPage").css("display","none");
    $("#carPage").css("display","block");
    $("#customerPage").css("display","none");
    $("#driverPage").css("display","none");
    $("#bookingPage").css("display","none");
    $("#bookingRequestPage").css("display","none");
    $("#paymentPage").css("display","none");
});

$("#linkCustomers").click(function () {
    $("#dashBoardPage").css("display","none");
    $("#carPage").css("display","none");
    $("#customerPage").css("display","block");
    $("#driverPage").css("display","none");
    $("#bookingPage").css("display","none");
    $("#bookingRequestPage").css("display","none");
    $("#paymentPage").css("display","none");
});

$("#linkDrivers").click(function () {
    $("#dashBoardPage").css("display","none");
    $("#carPage").css("display","none");
    $("#customerPage").css("display","none");
    $("#driverPage").css("display","block");
    $("#bookingPage").css("display","none");
    $("#bookingRequestPage").css("display","none");
    $("#paymentPage").css("display","none");
});

$("#linkBooking").click(function () {
    $("#dashBoardPage").css("display","none");
    $("#carPage").css("display","none");
    $("#customerPage").css("display","none");
    $("#driverPage").css("display","none");
    $("#bookingPage").css("display","block");
    $("#bookingRequestPage").css("display","none");
    $("#paymentPage").css("display","none");
});

$("#linkBookingRequest").click(function () {
    $("#dashBoardPage").css("display","none");
    $("#carPage").css("display","none");
    $("#customerPage").css("display","none");
    $("#driverPage").css("display","none");
    $("#bookingPage").css("display","none");
    $("#bookingRequestPage").css("display","block");
    $("#paymentPage").css("display","none");
});

$("#linkPayment").click(function () {
    $("#dashBoardPage").css("display","none");
    $("#carPage").css("display","none");
    $("#customerPage").css("display","none");
    $("#driverPage").css("display","none");
    $("#bookingPage").css("display","none");
    $("#bookingRequestPage").css("display","none");
    $("#paymentPage").css("display","block");
});