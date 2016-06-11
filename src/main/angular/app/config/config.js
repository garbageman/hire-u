'use strict';

angular.module('hireUApp')
.value('CONFIG', {
  url : {
    appURL : '/services',
    services : {
      campusInfo : '/campus/info'
    }
  }
});
