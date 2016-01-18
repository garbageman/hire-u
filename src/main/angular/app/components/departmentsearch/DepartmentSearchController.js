'use strict';

angular.module('hireUApp')
.controller('DeptSearchCtrl', function($scope) {
  $scope.testlist = [
    'Department of Agriculture',
    'Department of Information Technology',
    'Department of Transportation Services',
    'Department of Computer Science',
    'Department of Chemistry',
    'Department of Nuclear Physics'
  ];

  $scope.selected = null;

  $scope.controllertype='department';

});
