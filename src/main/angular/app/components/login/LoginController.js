'use strict';

angular.module('hireUApp').controller('LoginCtrl', function($scope) {
  $scope.signup = false;
  $scope.message = 'Login';

  $scope.toggleSignup = function() {
    if ($scope.signup) {
      $scope.signup = false;
      $scope.message = 'Login';
    } else {
      $scope.signup = true;
      $scope.message = 'Sign Up';
    }
  };

  
});
