'use strict';

angular.module('hireUApp')
.directive('search', function() {
  return {
    restrict: 'E',
    scope : {
      list : '=',
      value : '='
    },
    templateUrl : 'components/search/search.html'
  }
});
