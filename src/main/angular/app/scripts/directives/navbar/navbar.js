'use strict';

angular.module('hireUApp', [])
.controller('NavigationCtrl',['$scope', function($scope) {
  $scope.schools = [
    { name : 'University of Maryland - College Park', id : 'umd' },
    { name :  'University of Maryland - Baltimore County', id : 'umbc'}
  ];

  $scope.currentCampus = null;

}])
.directive('navBar', function() {
  return {
    scope:{},
    controller : 'NavigationCtrl',
    templateUrl: 'scripts/directives/navbar/navbar.html',
  }
});
