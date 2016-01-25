'use strict';

angular.module('hireUApp').controller('DepartmentFormCtrl', function($scope) {
  $scope.email = 'dnagle@umd.edu';
  //$scope.firstName = 'Damien';
  $scope.lastName = 'Nagle';

  $scope.campuslist = [
    'Rutgers University - New Brunswick',
    'University of Maryland - College Park',
    'University of Maryland - Baltimore County',
    'Johns Hopkins University',
    'William & Mary',
    'Georgetown University'
  ];

  $scope.institutiontype = 'institution';
});
