// //------Clear InputFields-----------
// function setCustomerDetailsTextFieldValues(username, address, contact, password, email, name, drivingLicenseNo, nic){
//     $("#txtLoadCustomerName").val(name);
//     $("#txtLoadCustomerAddress").val(address);
//     $("#txtLoadCustomerContact").val(contact);
//     $("#txtLoadCustomerUserName").val(username);
//     $("#txtLoadCustomerPassword").val(password);
//     $("#txtLoadCustomerEmail").val(email);
//     $("#txtLoadCustomerDrivingLicenseNo").val(drivingLicenseNo);
//     $("#txtLoadCustomerNIC").val(nic);
//     // $("#txtLoadCustomerLoginUserName").val(loginUsername);
//     // $("#txtCustomerLoginPassword").val(loginPassword);
// }
//
// //----------------Get Customer by Username--------------
// $("#btnCustomerLogin").click(function () {
//     let typedUsername = $("#txtCustomerLoginUserName").val();
//     $.ajax({
//         url: baseURL+"customer?username="+typedUsername+"",
//         method: "get",
//         dataType: "json",
//         success: function (resp){
//             alert(resp.message);
//             console.log(resp.data);
//             var customer = resp.data;
//             setCustomerDetailsTextFieldValues(customer.name, customer.address, customer.contact, customer.email, customer.nic, customer.drivingLicenseNo);
//         },
//         error: function (error){
//             alert(JSON.parse(error.responseText).message);
//         }
//     });
// });