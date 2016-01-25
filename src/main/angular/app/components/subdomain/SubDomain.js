'use strict';

angular.module('hireUApp').factory('subdomain', ['$location', function ($location) {
    var host = $location.host();
    if (host.indexOf('.') < 0)
        return null;
    else
        return host.split('.')[0];
}]);
