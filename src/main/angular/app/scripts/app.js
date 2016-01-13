'use strict';

/**
 * @ngdoc overview
 * @name hireUApp
 * @description
 * # hireUApp
 *
 * Main module of the application.
 */

var app =
angular
  .module('hireUApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ui.router',
    'oc.lazyLoad'
  ]);
  app.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/');

    $stateProvider
      .state('main', {
        url: '/',
        templateUrl: 'components/main/main.html',
        controller: 'MainCtrl', // since not a directive, we have to load controller here
        resolve: {
          loadMyFiles: function($ocLazyLoad) {
            return $ocLazyLoad.load({
              files: [
                'components/main/main.js',
                'styles/main.css'
              ]
            });
          }
        }
      })
      .state('school-home', {
        url: '/s/:campus',
        templateUrl: 'components/school/school-home.html',
        controller: 'SchoolCtrl',
        resolve: {
          loadMyFiles: function($ocLazyLoad) {
            return $ocLazyLoad.load({
              files: [
                'components/school/schoolController.js',
                'styles/school-home.css',
                'components/school/schoolService.js',
                'config/config.js'
              ]
            });
          }
        }
      })
      .state('job-description', {
        url : '/j/job',
        templateUrl : 'components/job/job.html',
        resolve: {
          loadMyFiles: function($ocLazyLoad) {
            return $ocLazyLoad.load({
              files: [
                'styles/job.css'
              ]
            });
          }
        }
      });
  });
