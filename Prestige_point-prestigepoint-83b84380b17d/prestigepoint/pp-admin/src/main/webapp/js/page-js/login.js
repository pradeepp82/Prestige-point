$(document).ready(function() {
    var e = ($.cookie("pm[remember]"), $.cookie("pm[email]"));
    void 0 != e && "null" != e ? ($("#emailId").val($.cookie("pm[email]")), $("#password").val($.cookie("pm[pass]")), $("#rememberMe").prop("checked", !0)) : $("#rememberMe").prop("checked", !1)
});
function remeberMe()
{
	 if ($("#rememberMe").is(":checked")) {
		 var e = $("#emailId").val(),
	            o = $("#password").val();
	        $.cookie("pm[email]", e, {
	            expires: 365
	        }), $.cookie("pm[pass]", o, {
	            expires: 365
	        }), $.cookie("pm[remember]", !0, {
	            expires: 365
	        })
	    } else $.cookie("pm[email]", null), $.cookie("pm[pass]", null), $.cookie("pm[remember]", !1)
}