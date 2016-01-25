'use strict';

angular.module('hireUApp')
.controller('DeptSearchCtrl', function($scope) {
  $scope.testlist = [
    'Department of Agriculture',
    'Department of Information Technology',
    'Department of Transportation Services',
    'Department of Computer Science',
    'Department of Chemistry',
    'Department of Nuclear Physics'
  ];

  $scope.check = function(selection) {
      $scope.currentpostings = $scope.testpostings[selection];
  };

  $scope.currentpostings = null;

  $scope.testpostings = {
    'Department of Agriculture' : [
      {
        'title' : 'Accountant',
        'qualifications' : 'None',
        'duties' : 'Keep track of the money spent on horse food.',
        'time' : '10-15 hours'
      },
      {
        'title' : 'Horse Feeder',
        'qualifications' : 'None',
        'duties' : 'Feed the horses. Order horse food',
        'time' : '5-10 hours'
      },
      {
        'title' : 'Horse Rider',
        'qualifications' : '3 Years Horsemanship',
        'duties' : 'Ride the horses every day',
        'time' : '20 hours'
      }
    ],
    'Department of Information Technology' : [
      {
        'title' : 'Student Software Engineer',
        'qualifications' : 'Java Programming, CMSC132 or equivalent',
        'duties' : 'Develop various applications that are used by the university',
        'time' : '10-15 hours'
      },
      {
        'title' : 'Student Technician',
        'qualifications' : 'None',
        'duties' : 'Help students with IT problems',
        'time' : '10-15 hours'
      }
    ]
  };

  $scope.selection = null;

  $scope.controllertype='department';

});
