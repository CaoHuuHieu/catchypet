function showMessage(text, state){
	  $.toastr.config({
        time: 3000,
      });
	if(state == "success"){
		$.toastr.success(text, {
            position: "top-right",
          });
	}else if(state == "warning"){
		$.toastr.warning(text, {
            position: "top-right",
          });
	}else if(state == "info"){
		$.toastr.infor(text, {
            position: "top-right",
          });
	}else if(state == "danger"){
		$.toastr.error(text, {
            position: "top-right",
          });
	}
	console.log(text, state, "log")
}

  function confirmDelete(url) {
        if (confirm("Bạn có chắc chắn muốn xóa?")) {
			window.location.href=url
             
        }
    }