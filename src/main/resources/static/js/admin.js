// Lấy danh sách các phần tử dropdown
var dropdowns = document.querySelectorAll('.dropdown');

// Lặp qua từng phần tử dropdown
dropdowns.forEach(function(dropdown) {
	// Lấy dropdown-content của phần tử hiện tại
	var dropdownContent = dropdown.querySelector('.dropdown-content');
	
	// Thêm sự kiện click cho phần tử dropdown
	dropdown.addEventListener('click', function() {
		var icon = dropdown.querySelector('fa-solid');
		console.log("hihi", icon)
		// Ẩn tất cả các dropdown-content khác
		dropdowns.forEach(function(otherDropdown) {
			if (otherDropdown !== dropdown) {
				var otherDropdownContent = otherDropdown.querySelector('.dropdown-content');
				otherDropdownContent.style.display = 'none';

			}
		});
		// Hiển thị hoặc ẩn dropdown-content của phần tử hiện tại
		if (dropdownContent.style.display === 'none') {
			dropdownContent.style.display = 'block';
			icon.style.transform = 'rotate(180deg)';
		} else {
			dropdownContent.style.display = 'none';
			icon.style.transform = 'none';
		}
	});
});
$('#content').summernote({
	placeholder: "Nội dung",
	tabsize: 2,
	height: 200,
});
function confirmDelete(url) {
	if (confirm("Bạn chắc chắn muốn xóa dữ liệu?")) {
		console.log(url, "url")
		window.location.href = "http://localhost:8080/" + url;
	}
}
function confirmLockAccount(url) {
	if (confirm("Bạn chắc chắn muốn khóa tài khoản này?")) {
		console.log(url, "url")
		window.location.href = "http://localhost:8080/" + url;
	}
}
function confirmUnlockAccount(url) {
	if (confirm("Bạn chắc chắn muốn mở khóa tài khoản này?")) {
		console.log(url, "url")
		window.location.href = "http://localhost:8080/" + url;
	}
}
