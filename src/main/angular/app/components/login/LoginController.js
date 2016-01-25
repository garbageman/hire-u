'use strict';

angular.module('hireUApp').controller('LoginCtrl', function($scope, $cookies) {
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

  $scope.login = function() {
    if ($scope.signup) {
      /* Sign up code goes here */
    } else {
      /* Login code goes here */
      $cookies.put('loggedin', true);
    }
  }



});
