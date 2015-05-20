'use strict';

/**
 * @ngdoc overview
 * @name mswFrontendApp
 * @description
 * # mswFrontendApp
 *
 * Main module of the application.
 */
angular
  .module('mswFrontendApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
