'use strict';

/**
 * @ngdoc overview
 * @name hireUApp
 * @description
 * # hireUApp
 *
 * Main module of the application.
 */
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
  ])
  .config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/");

    $stateProvider
      .state('main', {
        url: '/',
        templateUrl: 'views/main.html',
        controller: 'MainCtrl', // since not a directive, we have to load controller here
        resolve: {
          loadMyFiles: function($ocLazyLoad) {
            return $ocLazyLoad.load({
              files: [
                'scripts/controllers/main.js'
              ]
            })
          }
        }
      })
      .state('school-home', {
        url: '/s/umd',
        templateUrl: 'views/school-home.html',
        controller: 'SchoolCtrl',
        resolve: {
          loadMyFiles: function($ocLazyLoad) {
            return $ocLazyLoad.load({
              files: [
                'scripts/controllers/schoolController.js',
                'styles/school-home.css'
              ]
            })
          }
        }
      });
  });
