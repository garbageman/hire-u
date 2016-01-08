'use strict';

angular.module('hireUApp')
.value('CONFIG', {
  url : {
    appURL : 'http://localhost:8080/services',
    services : {
      campusInfo : '/campus/info'
    }
  }
});
