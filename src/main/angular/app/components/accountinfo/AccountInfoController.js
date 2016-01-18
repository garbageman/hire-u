'use strict';

angular.module('hireUApp').controller('AccountInfoCtrl', function($scope) {
  $scope.email = 'dnagle@umd.edu';
  $scope.firstName = 'Damien';
  $scope.lastName = 'Nagle';

  $scope.testlist = [
    'Rutgers University - New Brunswick',
    'University of Maryland - College Park',
    'University of Maryland - Baltimore County',
    'Johns Hopkins University',
    'William & Mary',
    'Georgetown University'
  ];

  $scope.listtype = 'institution';
});
