'use strict';

angular.module('hireUApp')
.controller('SchoolCtrl', function($scope, $state, CampusService) {
	$scope.jobs = [
		{
			'rank': 1,
			'title': 'CEO of hireU'
		}, {
			'rank': 2,
			'title': 'Testudo Engineer'
		}, {
			'rank': 3,
			'title': 'Tier-One Tech Support'
		}
	];

	function getCampusInfo() {
		CampusService.getCampusInfo($state.params.campus).then(
			function (response) {
				if (response.data !== null) {
					$scope.campus = {};
					$scope.campus.university = response.data.university;
					$scope.campus.city = response.data.city;
					$scope.campus.state = response.data.state;
				}
			},
			function (error) {
				console.log(error);
			}
		);
	}

	getCampusInfo();
});
