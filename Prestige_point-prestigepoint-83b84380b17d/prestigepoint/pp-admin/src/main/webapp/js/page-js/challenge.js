/**
 * 
 */
function enableChallengeStatus(challengeDetails) {
	var challengeId = challengeDetails.id;
	var challengeValue = challengeDetails.value;//value is getting the id
	var challengeIdValue = document.getElementById(challengeId).checked;//it is getting the value
	
	$.ajax({
		url : "activeChallengeStatus.do?challengeValue=" + challengeValue
				+ "&challengeIdValue=" + challengeIdValue,
		type : "GET",
		contentType : "application/json; charset=utf-8",
		success : function(call) {
		},
		error : function() {
		}
	})
}
