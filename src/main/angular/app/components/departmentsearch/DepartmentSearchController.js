'use strict';

angular.module('hireUApp')
.controller('DeptSearchCtrl', function($scope) {
  $scope.list = [
    'Department of Agriculture',
    'Department of Information Technology',
    'Department of Transportation Services',
    'Department of Computer Science',
    'Department of Chemistry',
    'Department of Nuclear Physics'
  ];

});
