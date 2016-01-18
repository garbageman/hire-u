'use strict';

angular.module('hireUApp')
.directive('search', function() {
  return {
      restrict: 'E',
      templateUrl : 'components/search/search.html',
      require: 'ngModel',
      replace: true,
      scope : {
        type : '=',
        list :'='
      },
      link: function(scope, iElement, iAttrs, ngModelCtrl) {

          scope.$watch('selected', function() {
             ngModelCtrl.$setViewValue(scope.selected);
          });

          ngModelCtrl.$render = function() {
             if (!$viewValue) $viewValue = null;

             scope.selected = ngModelCtrl.$viewValue;
          };
      }
  }
});
