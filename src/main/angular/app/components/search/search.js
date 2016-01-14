'use strict';

angular.module('hireUApp')
.directive('search', function() {
  return {
    restrict: 'E',
    transclude: true,
    templateUrl : 'components/search/search.html'
  }
});
