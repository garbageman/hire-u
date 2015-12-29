'use strict';

/**
 * @ngdoc function
 * @name hireUApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the hireUApp
 */
angular.module('hireUApp')
.controller('MainCtrl', ['$scope', function($scope) {
	$scope.jobs = [
		{
			"title": "Job 1",
			"text": "text for Job1"
			
		}, {
			"title": "Job 2",
			"text": "text for Job2"
			
		}, {
			"title": "Job 3",
			"text": "text for Job3"
		}
	];
}]);
