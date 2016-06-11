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
    'oc.lazyLoad',
    'ui.select'
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
                'components/main/main.js'
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
                'components/school/schoolService.js',
                'config/config.js'
              ]
            });
          }
        }
      })
      .state('department-search', {
        url: '/search/department',
        templateUrl: 'components/departmentsearch/DepartmentSearch.html',
        controller: 'DeptSearchCtrl',
        resolve: {
          loadMyFiles: function($ocLazyLoad) {
            return $ocLazyLoad.load({
              files: [
                'components/departmentsearch/DepartmentSearchController.js',
                'components/search/search.js',
                'components/select2/select.js'
              ]
            });
          }
        }
      })
      .state('login', {
        url: '/login',
        templateUrl: 'components/login/login.html',
        controller: 'LoginCtrl',
        resolve: {
          loadMyFiles: function($ocLazyLoad) {
            return $ocLazyLoad.load({
              files: [
                'components/login/LoginController.js',
              ]
            });
          }
        }
      })
      .state('accountinfo', {
        url: '/accountinfo',
        templateUrl: 'components/accountinfo/accountinfo.html',
        controller: 'AccountInfoCtrl',
        resolve: {
          loadMyFiles: function($ocLazyLoad) {
            return $ocLazyLoad.load({
              files: [
                'components/accountinfo/AccountInfoController.js',
                'components/search/search.js',
                'components/select2/select.js'
              ]
            });
          }
        }
      })
      .state('departmentForm', {
        url: '/departmentform',
        templateUrl: 'components/departmentForm/departmentForm.html',
        controller: 'DepartmentFormCtrl',
        resolve: {
          loadMyFiles: function($ocLazyLoad) {
            return $ocLazyLoad.load({
              files: [
                'components/departmentForm/departmentFormController.js',
                'components/search/search.js',
                'components/select2/select.js'
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
              ]
            });
          }
        }
      });
  });
