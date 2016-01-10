angular.module("hireuApp", [])
.directive("navbar", function() {
	return {
		restrict: 'EA',
		templateUrl: 'navbar.html'
	}
});