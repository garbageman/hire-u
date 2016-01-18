'use strict';

angular.module('hireUApp').controller('AccountInfoCtrl', function($scope) {
  $scope.email = 'dnagle@umd.edu';
  $scope.firstName = 'Damien';
  $scope.lastName = 'Nagle';

  $scope.campuslist = [
    'Rutgers University - New Brunswick',
    'University of Maryland - College Park',
    'University of Maryland - Baltimore County',
    'Johns Hopkins University',
    'William & Mary',
    'Georgetown University'
  ];

  $scope.yearlist = [
    'Freshman',
    'Sophomore',
    'Junior',
    'Senior'
  ];

  $scope.majorlist = [
    'Computer Science',
    'Art',
    'Chemistry',
    'Biology',
    'Business',
    'Basket Weaving'
  ];

  $scope.institutiontype = 'institution';
  $scope.majortype = 'major';
  $scope.yeartype = 'year'
});
