'use strict';

// Declare app level module which depends on filters, and services
angular.module('flyinghigh', ['flyinghigh.filters', 'flyinghigh.services', 'flyinghigh.directives', 'flyinghigh.controllers',
               'ui.bootstrap']).
  config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/welcome', {templateUrl: './partials/welcome.html', controller: 'LoginCtrl'});
    $routeProvider.when('/home', {templateUrl: './partials/home.html', controller: 'HomeCtrl'});
    $routeProvider.otherwise({redirectTo: '/welcome'});
  }]);
