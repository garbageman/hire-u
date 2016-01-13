'use strict';

angular.module('hireUApp').controller('NavigationCtrl',['$scope', function($scope) {
  $scope.schools = [
    { name : 'University of Maryland - College Park', id : 'umd' },
    { name :  'University of Maryland - Baltimore County', id : 'umbc'}
  ];

  $scope.currentCampus = 'Home';
  $scope.selecting = false;

  $scope.select = function(option) {
    if ($scope.selecting == false) {
      $scope.selecting = true;
    } else {
      $scope.currentCampus = option;
      $scope.selecting = false;
    }
  }

}]).directive('navBar', function() {
  return {
    controller : 'NavigationCtrl',
    templateUrl: 'components/navbar/navbar.html',
    resolve: {
      loadMyFiles: function($ocLazyLoad) {
        return $ocLazyLoad.load({
          files: [
            'components/navbar/navbar.css'
          ]
        });
      }
    }
  }
});
