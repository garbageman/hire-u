'use strict';

angular.module('hireUApp')
.service('CampusService', function($q, $http, CONFIG) {

  this.getCampusInfo = function (url) {
    var deferred = $q.defer();
    $http({
      url : CONFIG.url.appURL + CONFIG.url.services.campusInfo + '?url=' + url,
      method : 'GET'
    }).success(function(data) {
      deferred.resolve({ status :'SUCCESS',
        message : 'Success in GET campus info',
        data : data
      });
    }).error(function(error) {
      deferred.reject({ status : 'ERROR',
        message : 'Error with GET campus info',
        data : error
      });
    });

    return deferred.promise;
  };

});
