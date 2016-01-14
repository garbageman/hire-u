'use strict';

angular.module('hireUApp')
.directive('search', function() {
  return {
    scope : {
      list : '='
    },
    templateUrl : 'components/search/search.html'
  }
});
