/**
 * 
 */
function callAllPlacedStudent() {
  if ($('#allPlacedStudent').prop('checked')) {
    document.getElementById("datepick").disabled = true;
    document.getElementById("picker").disabled = true;
    document.getElementById("datepick").value = " ";
    document.getElementById("picker").value = " ";
  }
  else
    {
    document.getElementById("datepick").disabled = false;
    document.getElementById("datepick").disabled = false;
    
    }
}
function uncheckEvent()
{
  $('#allPlacedStudent').attr('checked', false);
  
 
}