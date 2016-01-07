angular.module('hireuApp', [])
.controller('SchoolCtrl', ['$scope', function($scope) {
	$scope.jobs = [
		{
			"rank": 1,
			"title": "CEO of hireU"
		}, {
			"rank": 2,
			"title": "Testudo Engineer"
		}, {
			"rank": 3,
			"title": "Tier-One Tech Support"
		}
	]
}]); 