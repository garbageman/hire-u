'use strict';

angular.module('hireUApp')
.value('CONFIG', {
  url : {
    appURL : 'localhost:8080/services',
    services : {
      campusInfo : '/campus/info'
    }
  }
});
