'use strict';

angular.module('hireUApp').controller('NavigationCtrl', ['$scope', 'subdomain', function($scope, subdomain) {

  $scope.subdomain = subdomain;

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
